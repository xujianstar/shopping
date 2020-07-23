package pingan.com.cn.remoteinvoke;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface TestHystrixServer {
    @RequestMapping("/getUserInfo")
    public String getUserInfo(@RequestParam String name);
}
