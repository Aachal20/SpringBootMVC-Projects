package in.aachal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;


@SpringBootApplication
public class BootMvcProjDataRenderingApplication {

	/*@Bean
	public ViewResolver createUBVResolver() {
		System.out.println("BootMvcProjDataRenderingApplication.createUBVResolver()");
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		//resolver.setViewClass(InternalResourceView.class);
		resolver.setViewClass(JstlView.class);
		return resolver;
	}*/

	/*@Bean
	public ViewResolver createIRVVResolver() {
		System.out.println("BootMvcProjDataRenderingApplication.createIRVResolver()");
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		//resolver.setViewClass(InternalResourceView.class);
		resolver.setViewClass(JstlView.class);
		return resolver;
	}*/

	@Bean
	public ViewResolver createRBVResolver() {
		System.out.println("BootMvcProjDataRenderingApplication.createRBVResolver()");
		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
		resolver.setBasename("in/aachal/commons/views");
		//resolver.setViewClass(InternalResourceView.class);

		return resolver;
	}

	@Bean
	public ViewResolver createXVResolver() {
		System.out.println("BootMvcProjDataRenderingApplication.createXVResolver()");
		XmlViewResolver xml = new XmlViewResolver();
		xml.setLocation(new ClassPathResource("in/aachal/cfgs/views.xml"));
		//resolver.setViewClass(InternalResourceView.class);
		return xml;
	}
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProjDataRenderingApplication.class, args);
	}

}
