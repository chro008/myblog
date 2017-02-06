package com.lbs.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setWebEnvironment(true);
		app.run(args);
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	/*
	 * @Bean public FilterRegistration getBaseFilter() { DemoFilter
	 * demoFilter=new DemoFilter(); FilterRegistrationBean registrationBean=new
	 * FilterRegistrationBean(); registrationBean.setFilter(demoFilter);
	 * List<String> urlPatterns=new ArrayList<String>();
	 * urlPatterns.add("/*");//拦截路径，可以添加多个
	 * registrationBean.setUrlPatterns(urlPatterns);
	 * registrationBean.setOrder(1); return registrationBean; }
	 * 
	 * @Bean public ServletListenerRegistrationBean<EventListener>
	 * getBaseListener() { ServletListenerRegistrationBean<EventListener>
	 * registrationBean =new ServletListenerRegistrationBean<>();
	 * registrationBean.setListener(new DemoListener()); return
	 * registrationBean; }
	 */
}
