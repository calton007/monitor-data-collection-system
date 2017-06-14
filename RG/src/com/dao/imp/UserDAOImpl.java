package com.dao.imp;

import java.util.List;

import com.dao.UserDAO;

import com.file.TSystemuser;

import com.util.HibernateSessionFactory;

import org.hibernate.Query;

import org.hibernate.Session;

import org.hibernate.Transaction;

public class UserDAOImpl implements UserDAO {

	@Override
	@SuppressWarnings("unchecked")
	public TSystemuser login(String userName, String password) 
	{
		Session session = HibernateSessionFactory.getSession();
		
		Transaction tx = session.beginTransaction();
		
		TSystemuser user = null;
		
		try
		{
			Query query = session.createQuery("from TSystemuser where username = '" + userName + "' and password = '" + password + "'");
			
			List<TSystemuser> list = query.list();
			
			if(list!=null )
			{
				user = list.get(0);
	        }				
			
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
		return user;
	}

}
