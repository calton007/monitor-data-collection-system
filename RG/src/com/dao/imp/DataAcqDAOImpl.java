package com.dao.imp;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;

import org.hibernate.Transaction;

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
			Query query = session.createQuery("from TDataacquiretask where projectid = '" + projectId + "'");
			
			t = (List<TDataacquiretask>) query.list();
			
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
			session.save(task);
			
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
	public void delDataAcq(Integer id, Integer projectId)
	{
		Session session = HibernateSessionFactory.getSession();
		
		Transaction tx = session.beginTransaction();
		
		try
		{
			Query query = session.createQuery("from TDataacquiretask where projectid = '" + projectId + "' and monitorid = '"+id+"'");
			
			TDataacquiretask task = (TDataacquiretask)query.list().get(0);			
			
			session.delete(task);
			
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
