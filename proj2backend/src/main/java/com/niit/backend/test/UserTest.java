package com.niit.backend.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.UserDao;
import com.niit.backend.model.User;

public class UserTest {
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		UserDao userDao = (UserDao)context.getBean("userDao"); 
		User user = (User)context.getBean("user");
		
		//user.setId(123);
		/*user.setUsername("user");
		user.setEmail("user@gmail.com");
		user.setPassword("user");
		user.setStatus(true);
		user.setRole("student");
		user.setOnline(true);
		
		userDao.registerUser(user);*/
		
		System.out.println(userDao.userList().get(0).getId());
		
	}

}