package pingan.com.cn.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pingan.com.cn.service.TestService;

@RestController
public class EurekaRibbonController {
    @Autowired
    public TestService testService;

    @RequestMapping("/testRibbon")
    public String testRibbon(){
        return testService.test(" java_word ");
    }
}
