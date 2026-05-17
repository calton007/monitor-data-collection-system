package com.dao.imp;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dao.DataDAO;
import com.file.TMonitordata;
import com.util.HibernateSessionFactory;

public class DataDAOImpl implements DataDAO 
{

	@SuppressWarnings("unchecked")
	@Override
	public List<TMonitordata> getData(Integer monitorId, Date monitorBegin,
			Date monitorEnd) {
		Session session = HibernateSessionFactory.getSession();
		
		Transaction tx = session.beginTransaction();
		
		List<TMonitordata> list = null;
		
		try
		{
			Query<TMonitordata> query = session.createQuery(
					"from TMonitordata where monitorId = :monitorId and monitorDateTime between :begin and :end",
					TMonitordata.class);
			query.setParameter("monitorId", monitorId);
			query.setParameter("begin", monitorBegin);
			query.setParameter("end", monitorEnd);
			
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

}
