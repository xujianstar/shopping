package pingan.com.cn.dao;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import pingan.com.cn.pojo.SkuInfo;

@Repository
public interface SkuEsMapper extends ElasticsearchRepository<SkuInfo,Long> {
}
