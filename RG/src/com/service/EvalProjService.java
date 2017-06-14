package com.service;

import java.util.List;

import com.file.TEvaluateprojectinfo;


public interface EvalProjService 
{
	public List<TEvaluateprojectinfo> getByUserId(Integer userId);
	
	public TEvaluateprojectinfo getProjById(Integer id);
	
	public void selectedStatus(TEvaluateprojectinfo t);

}
