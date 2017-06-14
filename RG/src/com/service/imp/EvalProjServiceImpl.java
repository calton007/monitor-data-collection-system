package com.service.imp;

import java.util.List;

import com.dao.EvalProjDAO;
import com.dao.imp.EvalProjDAOImpl;
import com.file.TEvaluateprojectinfo;
import com.service.EvalProjService;

public class EvalProjServiceImpl implements EvalProjService {

	@Override
	public List<TEvaluateprojectinfo> getByUserId(Integer userId) 
	{
		EvalProjDAO evalProjDAO = new EvalProjDAOImpl();		
		return evalProjDAO.getByUserId(userId);
	}

	@Override
	public TEvaluateprojectinfo getProjById(Integer id) 
	{
		EvalProjDAO evalProjDAO = new EvalProjDAOImpl();
		return evalProjDAO.getProjById(id);
	}

	@Override
	public void selectedStatus(TEvaluateprojectinfo t) 
	{
		EvalProjDAO evalProjDAO = new EvalProjDAOImpl();
		evalProjDAO.selectedStatus(t);
		
	}

	

}
