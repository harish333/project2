package com.niit.backend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.FriendDao;
import com.niit.backend.model.Friend;



public class FriendTest {
	public static void main(String[] args ) 
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		FriendDao friendDao = (FriendDao)context.getBean("friendDao"); 
		Friend friend= (Friend)context.getBean("friend");
		/*friend.setId(1);
		friend.setFromId("hari");
		friend.setToId("harish");
		friend.setStatus('A');*/
		
		//friendDao.updatePendingRequest('A',"hari","sunny");
		//friendDao.sendFriendRequest( "hari","sunny");
		
		/*List<Friend> list =  friendDao.getAllFriends("hari");
		
		for(Friend l : list)
		{
			System.out.println(l.getId()+" | "+l.getStatus()+" | "+l.getFromId()+" | "+l.getToId());
		}*/
		friendDao.getPendingRequest("hari");
		//System.out.println(friendDao.getAllFriends("hari").get());
}}