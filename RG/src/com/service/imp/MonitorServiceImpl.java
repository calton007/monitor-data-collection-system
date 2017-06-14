package com.service.imp;

import java.util.List;

import com.dao.MonitorDAO;
import com.dao.imp.MonitorDAOImpl;
import com.file.TMonitorinfo;
import com.service.MonitorService;

public class MonitorServiceImpl implements MonitorService {

	@Override
	public List<TMonitorinfo> getByArea(String area, Integer projectId) 
	{
		MonitorDAO monitorDAO = new MonitorDAOImpl();
		return monitorDAO.getByArea(area, projectId);
	}
	
	@Override
	public List<TMonitorinfo> notGetByArea(String area, Integer projectId) 
	{
		MonitorDAO monitorDAO = new MonitorDAOImpl();
		return monitorDAO.notGetByArea(area, projectId);
	}

	@Override
	public TMonitorinfo getMonitorById(Integer id)
	{
		MonitorDAO monitorDAO = new MonitorDAOImpl();
		return monitorDAO.getMonitorById(id);
	}

}
