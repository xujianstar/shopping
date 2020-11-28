
package com.itmayiedu.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages="com.itmayiedu")
@EnableAutoConfiguration
@EnableDiscoveryClient
public class App1 {
	 public static void main(String[] args) {
		 SpringApplication.run(App1.class, args);
	}
}
