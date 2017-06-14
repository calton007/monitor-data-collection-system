package com.dao;

import java.util.List;

import com.file.TEvaluateprojectinfo;

public interface EvalProjDAO 
{
	public List<TEvaluateprojectinfo> getByUserId(Integer userId);
	
	public TEvaluateprojectinfo getProjById(Integer id);
	
	public void selectedStatus(TEvaluateprojectinfo t);

}
