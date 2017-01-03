package com.niit.backend.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.BlogDao;
import com.niit.backend.model.BlogPost;

public class BlogPostTest {
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		BlogDao blogDao = (BlogDao)context.getBean("blogDao"); 
		BlogPost blogPost = (BlogPost)context.getBean("blogPost");
		
		//user.setId(123);
		/*user.setUsername("user");
		user.setEmail("user@gmail.com");
		user.setPassword("user");
		user.setStatus(true);
		user.setRole("student");
		user.setOnline(true);
		userDao.registerUser(user);*/
		//System.out.println(userDao.userList().get(0).getId());
		blogPost.setCreatedBy(null);
		blogPost.setBody("hai");
		blogDao.addBlogPost( null,blogPost);
	}

}