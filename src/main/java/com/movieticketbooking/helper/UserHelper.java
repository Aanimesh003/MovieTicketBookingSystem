package com.movieticketbooking.helper;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserHelper {
	
	@Before("execution (*  com.movieticketbooking.controller.*.getAllUser())")
	public void checkAuthorization() {
		 System.out.println("User is authorised");
	}

}
