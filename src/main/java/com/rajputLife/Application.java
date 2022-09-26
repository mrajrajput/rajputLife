package com.rajputLife;

//import javax.faces.webapp.FacesServlet;
//import org.ocpsoft.rewrite.servlet.RewriteFilter;
import com.rajputLife.repository.ProductRepository;
import com.sun.faces.config.ConfigureListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.faces.webapp.FacesServlet;
import java.util.Locale;

@EnableAutoConfiguration
//@ComponentScan({"com.auth0.samples.bootfaces"})

@SpringBootApplication
@ComponentScan(basePackages = {"com.rajputLife",
				"com.rajputLife/*",  //don't remove this!!
		"com.rajputLife.controller/*",
		"com.rajputLife.controller",
		"com.rajputLife.entity.security",
		"com.rajputLife.security.configuration",
		"com.rajputLife.security.oauth",
		"com.rajputLife.security.userDetails",
		"com.rajputLife.repository",
 		"com.rajputLife.repository.security"}

			)
public class Application  extends WebMvcConfigurerAdapter { //extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public ServletRegistrationBean facesServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
		registration.setLoadOnStartup(1);
		return registration;
	}

	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return servletContext -> {
			servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
//            servletContext.setInitParameter("primefaces.THEME", "omega-light");
		};
	}

	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<>(new ConfigureListener());
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("ns/login.xhtml");
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}



//	@Bean
//	public ServletRegistrationBean servletRegistrationBean() {
//		FacesServlet servlet = new FacesServlet();
//		return new ServletRegistrationBean(new FacesServlet(), "*.jsf");
//	}
//
////	@Bean
////	public ServletRegistrationBean servletRegistrationBean() {
////		ServletRegistrationBean servletRegistration = new ServletRegistrationBean(new FacesServlet());
////		servletRegistration.addUrlMappings("*.xhtml");
////		servletRegistration.setLoadOnStartup(1);
////		return servletRegistration;
////	}
//
//	@Bean
//	public FilterRegistrationBean rewriteFilter() {
//		FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
//		rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
//				DispatcherType.ASYNC, DispatcherType.ERROR));
//		rwFilter.addUrlPatterns("/*");
//		return rwFilter;
//	}
}
