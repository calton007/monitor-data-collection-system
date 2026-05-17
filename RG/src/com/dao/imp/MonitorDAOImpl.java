package com.dao.imp;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dao.MonitorDAO;

import com.file.TMonitorinfo;

import com.util.HibernateSessionFactory;

public class MonitorDAOImpl implements MonitorDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<TMonitorinfo> getByArea(String area, Integer projectId) 
	{
		Session session = HibernateSessionFactory.getSession();
		
		Transaction tx = session.beginTransaction();
		
		List<TMonitorinfo> list = null;
		
		try
		{
			Query<TMonitorinfo> query = session.createQuery(
					"from TMonitorinfo x where x.area = :area and x.monitorId not in "
							+ "(select t.monitorId from TDataacquiretask t where t.projectId = :projectId)",
					TMonitorinfo.class);
			query.setParameter("area", area);
			query.setParameter("projectId", projectId);
			
			list = query.list();
			
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
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TMonitorinfo> notGetByArea(String area, Integer projectId) 
	{
		Session session = HibernateSessionFactory.getSession();
		
		Transaction tx = session.beginTransaction();
		
		List<TMonitorinfo> list = null;
		try
		{
			Query<TMonitorinfo> query = session.createQuery(
					"from TMonitorinfo x where x.area = :area and x.monitorId in "
							+ "(select t.monitorId from TDataacquiretask t where t.projectId = :projectId)",
					TMonitorinfo.class);
			query.setParameter("area", area);
			query.setParameter("projectId", projectId);
			
			list = query.list();
			
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
		return list;
	}

	@Override
	public TMonitorinfo getMonitorById(Integer id)
	{
		Session session = HibernateSessionFactory.getSession();
		
		Transaction tx = session.beginTransaction();
		
		TMonitorinfo t = null;
		try
		{
			t = (TMonitorinfo) session.get(TMonitorinfo.class, id);
			
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

}
