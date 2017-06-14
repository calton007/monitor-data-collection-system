package com.service.imp;

import java.util.List;

import com.dao.DataAcqDAO;
import com.dao.imp.DataAcqDAOImpl;
import com.file.TDataacquiretask;
import com.service.DataAcqService;

public class DataAcqServiceImpl implements DataAcqService {

	@Override
	public List<TDataacquiretask> getByProjId(Integer projectId) 
	{
		
		DataAcqDAO dataAcqDAO = new DataAcqDAOImpl();
		return dataAcqDAO.getByProjId(projectId);
	}

	@Override
	public void newDataAcq(TDataacquiretask task)
	{
		DataAcqDAO dataAcqDAO = new DataAcqDAOImpl();
		dataAcqDAO.newDataAcq(task);
		
	}

	@Override
	public TDataacquiretask getById(Integer id) 
	{
		DataAcqDAO dataAcqDAO = new DataAcqDAOImpl();
		return dataAcqDAO.getById(id);
		
	}

	@Override
	public void delDataAcq(Integer id, Integer projectId) 
	{
		DataAcqDAO dataAcqDAO = new DataAcqDAOImpl();
		dataAcqDAO.delDataAcq(id, projectId);
		
	}

}
