package pingan.com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.internal.EnableZipkinServer;

@EnableEurekaClient
@SpringBootApplication
@EnableZipkinServer
public class ZipkinServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServiceApplication.class,args);
    }

}
