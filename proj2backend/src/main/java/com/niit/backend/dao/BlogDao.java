package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.BlogComment;
import com.niit.backend.model.BlogPost;
import com.niit.backend.model.User;

public interface BlogDao {
	public List<BlogPost> getBlogPosts();
	public BlogPost getBlogPost(int id);
	public BlogPost addBlogPost(User user,BlogPost blogPost);
	public List<BlogComment> getBlogComments(int blogId);
	public BlogPost addBlogPostComment(User user,BlogComment blogComment);
}