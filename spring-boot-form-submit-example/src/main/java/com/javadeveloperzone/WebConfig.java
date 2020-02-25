package com.javadeveloperzone;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;


@Configuration
public class WebConfig {
   //Register ABCFilter 	
   @Bean
   public FilterRegistrationBean abcFilter() {
	   FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
	   filterRegBean.setFilter(new MyFilter());
	   filterRegBean.addUrlPatterns("/*");
	   return filterRegBean;
   }
}
