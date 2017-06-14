package com.dao.imp;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.dao.EvalProjDAO;

import com.file.TEvaluateprojectinfo;

import com.util.HibernateSessionFactory;

public class EvalProjDAOImpl implements EvalProjDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<TEvaluateprojectinfo> getByUserId(Integer userId) 
	{
		Session session = HibernateSessionFactory.getSession();
		
		Transaction tx = session.beginTransaction();
		
		List<TEvaluateprojectinfo> list = null;		
		
		try
		{
			Query query = session.createQuery("from TEvaluateprojectinfo where UserId='" + userId +"'");
			
			list = (List<TEvaluateprojectinfo>)query.list();
			
			tx.commit();
			
			
		}
		catch(Exception ex)
		{
			if(tx != null)
			{
				tx.rollback();
			}
			
		}
		finally
		{
			HibernateSessionFactory.closeSession();
		}
		return list;
	}

	@Override
	public TEvaluateprojectinfo getProjById(Integer id)
	{
		Session session = HibernateSessionFactory.getSession();
		
		Transaction tx = session.beginTransaction();
		
		TEvaluateprojectinfo t = null;
		try
		{
			t = (TEvaluateprojectinfo)session.get(TEvaluateprojectinfo.class, id);
			
		
			tx.commit();
		}
		catch(Exception ex)
		{
			if(tx != null)
			{
				tx.rollback();
			}
			
		}
		finally
		{
			HibernateSessionFactory.closeSession();
		}
		
		return t;
	}

	@Override
	public void selectedStatus(TEvaluateprojectinfo t) 
	{
		Session session = HibernateSessionFactory.getSession();
		
		Transaction tx = session.beginTransaction();
		
		try
		{
			session.update(t);
			
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
