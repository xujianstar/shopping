package pingan.com.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pingan.com.cn.remoteinvoke.InvokeRemoteUser;

@RestController
public class CallRemoteUserController {
    @Autowired
    InvokeRemoteUser invokeRemoteUser;

    @RequestMapping("/invokeRemoteUser")
    public String invokeRemoteUser(@RequestParam String name){
        System.out.println("invokeRemoteUser");
        return invokeRemoteUser.getUserInfo(name);
    }
}
