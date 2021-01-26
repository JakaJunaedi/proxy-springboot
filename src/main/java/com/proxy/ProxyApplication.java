package com.proxy;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy

public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	// @Bean
	// public TomcatServletWebServerFactory containerFactory() {
    //     return new TomcatServletWebServerFactory() {
	      
	// 	  protected void postProcessContext(Context context) {
	//         SecurityConstraint securityConstraint = new SecurityConstraint();
	//         securityConstraint.setUserConstraint("CONFIDENTIAL");
	//         SecurityCollection collection = new SecurityCollection();
	//         collection.addPattern("/*");
	//         securityConstraint.addCollection(collection);
	//         context.addConstraint(securityConstraint);
	//       }	    };
	// }
}