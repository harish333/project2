package com.niit.backend.dao;

import com.niit.backend.model.UploadFile;

public interface FileUploadDao {
	public void save(UploadFile uploadFile);
	UploadFile getFile(String username);
}