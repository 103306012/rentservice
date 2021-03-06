package com.rentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rentservice.interceptor.LoginInterceptor;

import org.springframework.validation.Validator;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	LoginInterceptor logininterceptor;
	@Value("${directory.path}")
	private String path;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(logininterceptor).addPathPatterns("/uploadproduct/**", "/profile/**", "/rentlist/**",
				"/viewproduct/rent/**");
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/bootstrap/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/4.4.1-1/").resourceChain(false);
		registry.addResourceHandler("/images/**").addResourceLocations("file:" + path).resourceChain(false);
	}

}
