package pingan.com.cn;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestGateway {
    @RequestMapping("/say")
    public String say(){
        return "how are you";
    }
}
