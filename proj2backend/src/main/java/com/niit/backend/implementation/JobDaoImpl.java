package com.niit.backend.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.dao.JobDao;
import com.niit.backend.model.Job;
import com.niit.backend.model.User;

@Repository("jobDao")
@Transactional
public class JobDaoImpl implements JobDao {
	@Autowired
private SessionFactory sessionFactory;
	@Transactional
	public Job registerJob(Job job) {
		//logger.debug("JOBDAOIMPL - registerUser");
		Session session=sessionFactory.getCurrentSession();
		session.save(job);
		/*session.flush();
		session.close();*/
		//logger.debug("Job id in Dao " + job.getJobId());
		return job;
		
			}
	@Transactional
	@Override
	public void postJob(Job job) {
		Session session=sessionFactory.getCurrentSession();
		session.save(job);
		/*session.flush();
		session.close();*/

	}
    /*@Transactional
	@Override
	public List<Job> getAllJobs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job");
		List<Job> jobs=query.list();
		//session.close();
		return jobs;
	}*/
	
	
	@SuppressWarnings("deprecation")
	@Transactional
	public List<Job> getAllJobs()
	{
		@SuppressWarnings("unchecked")
		List<Job> list= (List<Job>) sessionFactory.getCurrentSession().createCriteria(Job.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
				
	}

	@Transactional
	   public void addJob(Job job)
	   {
		  System.out.println("Entering to addUser.....");
		  sessionFactory.getCurrentSession().saveOrUpdate(job);
	   }

}