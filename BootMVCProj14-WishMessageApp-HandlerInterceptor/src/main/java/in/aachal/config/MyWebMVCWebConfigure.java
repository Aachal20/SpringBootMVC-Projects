package in.aachal.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import in.aachal.interceptor.TimeCheckInterceptor;

@Component
public class MyWebMVCWebConfigure implements WebMvcConfigurer {
  
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	System.out.println("MyWebMVCWebConfigure.addInterceptors()");
	registry.addInterceptor(new TimeCheckInterceptor());
		WebMvcConfigurer.super.addInterceptors(registry);
	}
} 
