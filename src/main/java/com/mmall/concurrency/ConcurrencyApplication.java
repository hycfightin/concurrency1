package com.mmall.concurrency;

import com.mmall.concurrency.aop.aspect.MyAspect;
import com.mmall.concurrency.exmple.HttpFilter;
import com.mmall.concurrency.exmple.HttpInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ConcurrencyApplication  extends WebMvcConfigurerAdapter  {

	public static void main(String[] args) {
		SpringApplication.run(ConcurrencyApplication.class, args);
	}

	@Bean(name = "myAspect")
	public MyAspect initMyAspect() {
		return new MyAspect();
	}


	@Bean
	public FilterRegistrationBean httpFilter( ) {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(	new HttpFilter());
		registrationBean.addUrlPatterns("/threadLocal/*");
		return  registrationBean;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
	}
}
