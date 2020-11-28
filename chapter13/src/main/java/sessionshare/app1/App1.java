package sessionshare.app1;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

@EnableRedisHttpSession
@SpringBootApplication
@RestController
public class App1 {

    @Value("${server.port}")
    private String port;

    public static void main(String[] args) {
        SpringApplication.run(App1.class,args);
    }

    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request , String sessionKey){
        try {
            HttpSession session = request.getSession(false);
            String sessionValue = "空";
            if(session!=null){
                sessionValue = (String)session.getAttribute(sessionKey);
                return port +":" +sessionValue ;
            }else{
                return port +":" +sessionValue ;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return port +":false:kong";
    }


    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request , String sessionKey, String sessionValue){
        try {
            HttpSession session = request.getSession(true);
            session.setAttribute(sessionKey,sessionValue);
            return "success,port:" + port;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "false,port:" + port;
    }
}
