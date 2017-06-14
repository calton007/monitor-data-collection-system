package com.service;

import java.util.Date;
import java.util.List;

import com.file.TMonitordata;

public interface DataService {
	
	public List<TMonitordata> getData(Integer monitorId, Date monitorBegin,	Date monitorEnd);

}
