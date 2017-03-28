package com.lbs.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

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

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

	    return new EmbeddedServletContainerCustomizer() {
	        @Override
	        public void customize(ConfigurableEmbeddedServletContainer container) {

	            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
	            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
	            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");

	            container.addErrorPages(error401Page, error404Page, error500Page);//增加自定义错误页面
	            
	            container.setSessionTimeout(1800);//设置session过期事件  单位为S
	        }
	    };
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
