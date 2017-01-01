/*package com.niit.backend.implementation;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.dao.UserDao;
import com.niit.backend.model.User;

@SuppressWarnings("deprecation")
@EnableTransactionManagement
@Repository("userDao")
public class UserDaoImpl implements UserDao{
Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public User authenticate(User user) {
		logger.debug("USERDAOIMPL :: AUTHENTICATE");
		Session session=sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		Query query=session.createQuery(
		"from USER where username=?  and password=?");
		//select * from User where username='smith' and password='123'
		query.setString(0, user.getUsername());
		query.setString(1, user.getPassword());
		User validUser=(User)query.uniqueResult();
		session.flush();
		session.close();
		if(validUser!=null)
		logger.debug("VALID USER IS  " + validUser.getUsername() + " " + validUser.getRole() + " " + validUser.isOnline());;
		if(validUser==null)
			logger.debug("Valid USER is null");
		return validUser;
		
	}
	
	public void updateUser(User user) {
		logger.debug("USERDAOIMPL::UPDATE");
		logger.debug("ISONLINE VALUE IS [BEFORE UPDATE]" + user.isOnline());
		Session session=sessionFactory.openSession();
		User existingUser=(User)session.get(User.class, user.getId());
		//update online status as true
		existingUser.setOnline(user.isOnline()); 
		
		session.update(existingUser);
		session.flush();
		session.close();
		logger.debug("ISONLINE VALUE IS [AFTER UPDATE] " + existingUser.isOnline());
	}
	
	public User registerUser(User user) {
		logger.debug("USERDAOIMPL - registerUser");
		Session session=sessionFactory.openSession();
		session.save(user);
		session.flush();
		session.close();
		logger.debug("User id in Dao " + user.getId());
		return user;
		
			}
	
	public List<User> list()
	{
		String hql = "from User";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = query.list();
		return listUser;
	}

}
*/
package com.niit.backend.implementation;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.dao.UserDao;
import com.niit.backend.model.User;

@EnableTransactionManagement
@Repository("userDao")
public class UserDaoImpl implements UserDao
{
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	   public void addUser(User user)
	   {
		  logger.debug("Entering to addUser.....");
		  sessionFactory.getCurrentSession().saveOrUpdate(user);
	   }
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Transactional
	public User authenticate(User user) {
		logger.debug("USERDAOIMPL :: AUTHENTICATE");
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where username=?  and password=?");
		//select * from User where username='smith' and password='123'
		query.setString(0, user.getUsername());
		query.setString(1, user.getPassword());
		User validUser=(User)query.uniqueResult();
		/*session.flush();
		session.close();*/
		if(validUser!=null)
		logger.debug("VALID USER IS  " + validUser.getUsername() + " " + validUser.getRole() + " " + validUser.isOnline());;
		if(validUser==null)
			logger.debug("Valid USER is null");
		return validUser;
		
	}
	
	@Transactional
	public void updateUser(User user) {
		logger.debug("USERDAOIMPL::UPDATE");
		logger.debug("ISONLINE VALUE IS [BEFORE UPDATE]" + user.isOnline());
		Session session=sessionFactory.getCurrentSession();
		User existingUser=(User)session.get(User.class, user.getId());
		//update online status as true
		existingUser.setOnline(user.isOnline()); 
		
		session.update(existingUser);
		/*session.flush();
		session.close();*/
		logger.debug("ISONLINE VALUE IS [AFTER UPDATE] " + existingUser.isOnline());
	}
	
	@Transactional
	public User registerUser(User user) {
		logger.debug("USERDAOIMPL - registerUser");
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
		/*session.flush();
		session.close();*/
		logger.debug("User id in Dao " + user.getId());
		return user;
		
			}
	
	@SuppressWarnings("deprecation")
	@Transactional
	public List<User> userList()
	{
		@SuppressWarnings("unchecked")
		List<User> list= (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
				
	}
	@Override
	public List<User> getAllUsers(User user) {
		Session session=sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("select * from proj2_user where username in (select username from proj2_user where username!=? minus(select to_id from friend where from_id=? union select from_id from friend where to_id=?))");
		query.setString(0, user.getUsername());
		query.setString(1, user.getUsername());
		query.setString(2, user.getUsername());
		query.addEntity(User.class);
		List<User> users=query.list();
		System.out.println(users);
		session.close();
		return users;
	}

//	@Override
//	public List<User> list() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

	
}