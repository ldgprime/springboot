package com.cos.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration					//web.xml 오버로딩	
public class WebConfig implements WebMvcConfigurer {
	@Value("${file.path}")
	private String fileRealPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
	
		
		//파일 경로 인식하게 하기                                          
		registry.addResourceHandler("/media/**")//경로설정, 필수
		.addResourceLocations("file:///"+fileRealPath)//경로설정, 필수		
		.setCachePeriod(3600)//캐시에  1분마다 다운로드
		.resourceChain(true)//필수
		.addResolver(new PathResourceResolver());
		
	}
}
