package com.service;

import java.util.List;

import com.file.TMonitorinfo;

public interface MonitorService {
	
	public List<TMonitorinfo> getByArea(String area, Integer projectId);
	
	public List<TMonitorinfo> notGetByArea(String area, Integer projectId);
	
	public TMonitorinfo getMonitorById(Integer id);

}
