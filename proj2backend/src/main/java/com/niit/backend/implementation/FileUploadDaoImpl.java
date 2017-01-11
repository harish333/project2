package com.niit.backend.implementation;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.dao.FileUploadDao;
import com.niit.backend.model.UploadFile;



@Transactional
@Repository("fileUploadDao")
@EnableTransactionManagement
public class FileUploadDaoImpl implements FileUploadDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public FileUploadDaoImpl() {
	}

	public FileUploadDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void save(UploadFile uploadFile) {
		Session session=sessionFactory.getCurrentSession();
		session.save(uploadFile);
		/*session.flush();
		session.close();*/
	}

	@Override
	public UploadFile getFile(String username) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from UploadFile where username=?");
		query.setParameter(0, username);
        UploadFile uploadFile=(UploadFile)query.setMaxResults(1).uniqueResult();
		//session.close();
		return uploadFile;
	}

}