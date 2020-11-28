package pingan.com.cn;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClientApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApp.class,args);
    }
    @Value("${foo}")
    String foo;
    @RequestMapping(value = "/foo")
    public String hi(){
        System.out.println("打印结果="+foo);
        return foo;
    }
}
