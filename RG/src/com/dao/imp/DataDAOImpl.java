package com.dao.imp;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
			DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			
			f.format(monitorBegin);
			
			
			Query query = session.createQuery("from TMonitordata where monitorid = '"
					+ monitorId +"' and monitordatetime between '"  + f.format(monitorBegin) + 
					"' and '" + f.format(monitorEnd) + "'");
			
			list = (List<TMonitordata>)query.list();
			
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
