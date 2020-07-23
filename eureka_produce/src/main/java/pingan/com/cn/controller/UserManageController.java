package pingan.com.cn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManageController {
    @RequestMapping("/getUserInfo")
    public String getUserInfo(@RequestParam String name){
        return "Welcome 444,"+name+" use Spring Cloud";
    }
}
