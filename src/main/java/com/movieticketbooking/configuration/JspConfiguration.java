package com.movieticketbooking.configuration;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class JspConfiguration {
	
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/templates");    //// Location of your JSP files within resources
		resolver.setSuffix(".jsp");
		return resolver;
	}

}
