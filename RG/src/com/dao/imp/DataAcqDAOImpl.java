package com.dao.imp;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dao.DataAcqDAO;

import com.file.TDataacquiretask;

import com.util.HibernateSessionFactory;


public class DataAcqDAOImpl implements DataAcqDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<TDataacquiretask> getByProjId(Integer projectId) 
	{
		Session session = HibernateSessionFactory.getSession();
		
		Transaction tx = session.beginTransaction();
		
		List<TDataacquiretask> t = null;
		
		try
		{
			Query<TDataacquiretask> query = session.createQuery(
					"from TDataacquiretask where projectId = :projectId",
					TDataacquiretask.class);
			query.setParameter("projectId", projectId);
			
			t = query.list();
			
			tx.commit();
		}
		catch(Exception ex)
		{
			if(ex != null)
				
				tx.rollback();
		}
		finally
		{
			HibernateSessionFactory.closeSession();
		}
		return t;
	}

	@Override
	public void newDataAcq(TDataacquiretask task)
	{
		Session session = HibernateSessionFactory.getSession();
		
		Transaction tx = session.beginTransaction();
		
		try
		{
			session.persist(task);
			
			tx.commit();
		}
		catch(Exception ex)
		{
			if(tx != null)
				
				tx.rollback();
		}
		finally
		{
			HibernateSessionFactory.closeSession();
		}
		
	}

	@Override
	public TDataacquiretask getById(Integer id) 
	{
		Session session = HibernateSessionFactory.getSession();
		
		Transaction tx = session.beginTransaction();
		
		TDataacquiretask task = null;
		
		try
		{
			task = (TDataacquiretask)session.get(TDataacquiretask.class, id);
			
			tx.commit();
		}
		catch(Exception ex)
		{
			if(tx != null)
				
				tx.rollback();
		}
		finally
		{
			HibernateSessionFactory.closeSession();
		}
		return task;
	}

	@Override
	public boolean existsByProjectAndMonitor(Integer projectId, Integer monitorId)
	{
		Session session = HibernateSessionFactory.getSession();
		
		Transaction tx = session.beginTransaction();
		
		try
		{
			Query<Long> query = session.createQuery(
					"select count(t.id) from TDataacquiretask t where t.projectId = :projectId and t.monitorId = :monitorId",
					Long.class);
			query.setParameter("projectId", projectId);
			query.setParameter("monitorId", monitorId);
			
			boolean exists = query.uniqueResult() > 0;
			
			tx.commit();
			return exists;
		}
		catch(Exception ex)
		{
			if(tx != null)
				tx.rollback();
			throw ex;
		}
		finally
		{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public void delDataAcq(Integer id, Integer projectId)
	{
		Session session = HibernateSessionFactory.getSession();
		
		Transaction tx = session.beginTransaction();
		
		try
		{
			Query<TDataacquiretask> query = session.createQuery(
					"from TDataacquiretask where projectId = :projectId and monitorId = :monitorId",
					TDataacquiretask.class);
			query.setParameter("projectId", projectId);
			query.setParameter("monitorId", id);
			
			List<TDataacquiretask> tasks = query.list();
			if (tasks.isEmpty()) {
				tx.rollback();
				return;
			}
			TDataacquiretask task = tasks.get(0);
			
			session.remove(task);
			
			tx.commit();
		}
		catch(Exception ex)
		{
			if(ex != null)
				tx.rollback();
		}
		finally
		{
			HibernateSessionFactory.closeSession();
		}
		
	}

}
