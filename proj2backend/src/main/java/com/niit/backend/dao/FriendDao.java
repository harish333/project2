package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.Friend;

public interface FriendDao {
public List<Friend> getAllFriends(String username);
public void sendFriendRequest(String from,String to);
public List<Friend> getPendingRequest(String username);

public void updatePendingRequest(char friendStatus, String fromId, String username);
}