package pingan.com.cn.service.impl;

import com.alibaba.fastjson.JSON;
import entity.Result;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import pingan.com.cn.dao.SkuEsMapper;
import pingan.com.cn.feign.SkuFeign;
import pingan.com.cn.pojo.Sku;
import pingan.com.cn.pojo.SkuInfo;
import pingan.com.cn.service.SkuService;

import java.util.*;


@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    SkuFeign skuFeign;

    @Autowired
    SkuEsMapper skuEsMapper;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    public void importData(){
        // 调用feign
        Result<List<Sku>> skuList = skuFeign.findAll();
        List<SkuInfo> SkuInfoList = JSON.parseArray(JSON.toJSONString(skuList.getData()), SkuInfo.class);
        
        skuEsMapper.saveAll(SkuInfoList);
    }
    @Override
    public Map search(Map searchMap) {

        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();

        // 多条件查询: must  , must not ,should
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        if(searchMap!=null&&searchMap.size()>=1){
            String keyword = searchMap.get("keyword") ==null? "" : (String) searchMap.get("keyword");
            if(keyword !=null  && !"".equals(keyword.trim())  ){
                // 单条件查询
                // nativeSearchQueryBuilder.withQuery(QueryBuilders.queryStringQuery(keyword).field("name"));
                boolQueryBuilder.must(QueryBuilders.queryStringQuery(keyword).field("name"));
            }

            String category = searchMap.get("category") ==null? "" : (String) searchMap.get("category");
            if(!StringUtils.isEmpty(category)){
                // 单条件查询
                // nativeSearchQueryBuilder.withQuery(QueryBuilders.queryStringQuery(category).field("categoryName"));
                boolQueryBuilder.must(QueryBuilders.termQuery("categoryName",category));
            }

            String brand = searchMap.get("brand") ==null? "" : (String) searchMap.get("brand");
            if(!StringUtils.isEmpty(category)){
                // 单条件查询
                // nativeSearchQueryBuilder.withQuery(QueryBuilders.queryStringQuery(brand).field("brandName"));
                boolQueryBuilder.must(QueryBuilders.termQuery("brandName",brand));
            }
            nativeSearchQueryBuilder.withQuery(boolQueryBuilder);

            //  gui ge   jia  ge   fengye   paixu


        }
        NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder.build();
        AggregatedPage<SkuInfo> page = elasticsearchTemplate.queryForPage(nativeSearchQuery, SkuInfo.class);
        // 分组查询
        nativeSearchQueryBuilder.addAggregation(AggregationBuilders.terms("skuCategory").field("categoryName"));
        AggregatedPage<SkuInfo> aggregatedPage = elasticsearchTemplate.queryForPage(nativeSearchQueryBuilder.build(), SkuInfo.class);

        StringTerms stringTerm = aggregatedPage.getAggregations().get("skuCategory");



        List<String> categoryList = new ArrayList<String>();
        for(StringTerms.Bucket bucket : stringTerm.getBuckets()){
            String categoryName = bucket.getKeyAsString();
            categoryList.add(categoryName);
        }

        Map<String,Object> resultMap =new HashMap<>();
        String brand = searchMap.get("brand") == null ?"": (String) searchMap.get("brand");
        if (StringUtils.isEmpty(brand)){
            List<String> brandNameList = searchBrandList(nativeSearchQueryBuilder);
            resultMap.put("brandList",brandNameList);

        }

        // 查询品牌
        // 查询规格
        Map<String,Set<String>> specList = searchSpecList(nativeSearchQueryBuilder);

        // 总记录数
        long totalElements  = page.getTotalElements();
        // 总页数
        int totalPages = page.getTotalPages();
        // 数据结果集
        List<SkuInfo>  content = page.getContent();

//        resultMap.put("categoryList",categoryList);//商品分类的列表数据
        resultMap.put("rows",content);
        resultMap.put("total",totalElements);
        resultMap.put("totalPages",totalPages);
        resultMap.put("categoryList",categoryList);
        resultMap.put("specList",specList);
        return resultMap;
    }

    public List<String> searchBrandList(NativeSearchQueryBuilder nativeSearchQueryBuilder){
        nativeSearchQueryBuilder.addAggregation(AggregationBuilders.terms("subBrandName").field("brandName"));
        AggregatedPage<SkuInfo>  aggregatedPage = elasticsearchTemplate.queryForPage(nativeSearchQueryBuilder.build(), SkuInfo.class);
        StringTerms stringTerm = aggregatedPage.getAggregations().get("subBrandName");
        List<String> brandNameList = new ArrayList<String>();

        for(StringTerms.Bucket bucket : stringTerm.getBuckets()){
            String brandName = bucket.getKeyAsString();
            brandNameList.add(brandName);
        }
        return brandNameList;
    }

    public Map<String,Set<String>> searchSpecList(NativeSearchQueryBuilder nativeSearchQueryBuilder){
        nativeSearchQueryBuilder.addAggregation(AggregationBuilders.terms("subSpec").field("spec.keyword").size(1000));
        AggregatedPage<SkuInfo>  aggregatedPage = elasticsearchTemplate.queryForPage(nativeSearchQueryBuilder.build(), SkuInfo.class);
        StringTerms stringTerm = aggregatedPage.getAggregations().get("subSpec");
        List<String> specList = new ArrayList<String>();

        for(StringTerms.Bucket bucket : stringTerm.getBuckets()){
            String specName = bucket.getKeyAsString();
            specList.add(specName);
        }
        Map<String,Set<String>> allSpec = new HashMap<String, Set<String>>();
        for(String specs : specList){
            HashMap<String,String> specMap = JSON.parseObject(specs,HashMap.class);

            for(Map.Entry<String,String> entry : specMap.entrySet()){
                String key = entry.getKey();      // 规格名称
                String value = entry.getValue();  // 规格值
                Set<String> specSet = allSpec.get(key);
                if(specSet==null){
                    specSet =  new HashSet<String>();
                }
                specSet.add(value);
                allSpec.put(key,specSet);
            }
        }

        return allSpec;
    }


}
