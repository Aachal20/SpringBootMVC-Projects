package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class BootMvcProj16FileUploadingDownloadingApplication {

	/*@Bean(name="multipartResolver")
	public CommonsMultipartResolver createCMR() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSizePerFile(50*1024*1042);
		resolver.setMaxUploadSize(-1);
		return resolver;
	}*/
	
	/*@Bean
	public ViewResolver createIRVR() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj16FileUploadingDownloadingApplication.class, args);
	}

}
