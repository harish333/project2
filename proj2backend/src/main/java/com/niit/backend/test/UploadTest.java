package com.niit.backend.test;
//import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.FileUploadDao;
import com.niit.backend.model.UploadFile;



public class UploadTest {
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		FileUploadDao fileUploadDao = (FileUploadDao)context.getBean("fileUploadDao"); 
		UploadFile uploadFile = (UploadFile)context.getBean("uploadFile");
		
		//uploadFile.setId(123);
		uploadFile.setFileName("pic1");
		uploadFile.setUsername("harish");
		uploadFile.setData(null);
		fileUploadDao.save(uploadFile);
		
}}