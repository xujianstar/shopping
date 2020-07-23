package pingan.com.cn.controller;


import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pingan.com.cn.service.SkuService;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/search")
public class SkuController {
    @Autowired
    private SkuService skuService ;

    @GetMapping("/import")
    public Result importData(){
        System.out.println("-----------import----------------");
        skuService.importData();
        return new Result(true, StatusCode.OK,"导入成功");
    }
    @GetMapping
    public Map search(@RequestParam(required = true) Map searchMap){
        return skuService.search(searchMap);
    }

}
