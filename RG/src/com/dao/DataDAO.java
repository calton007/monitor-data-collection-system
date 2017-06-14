package com.dao;

import java.util.Date;
import java.util.List;

import com.file.TMonitordata;

public interface DataDAO {
	
	public List<TMonitordata> getData(Integer monitorId, Date monitorBegin, Date monitorEnd);
	

}
