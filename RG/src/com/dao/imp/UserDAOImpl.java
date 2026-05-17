package com.dao.imp;

import java.util.List;

import com.dao.UserDAO;

import com.file.TSystemuser;

import com.util.HibernateSessionFactory;

import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
			Query<TSystemuser> query = session.createQuery(
					"from TSystemuser where userName = :userName and password = :password",
					TSystemuser.class);
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			
			List<TSystemuser> list = query.list();
			
			if(list != null && !list.isEmpty())
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
