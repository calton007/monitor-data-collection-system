package com.service.imp;

import java.util.Date;
import java.util.List;

import com.dao.DataDAO;
import com.dao.imp.DataDAOImpl;
import com.file.TMonitordata;
import com.service.DataService;

public class DataServiceImpl implements DataService {

	@Override
	public List<TMonitordata> getData(Integer monitorId, Date monitorBegin,
			Date monitorEnd) {
		DataDAO dataDAO = new DataDAOImpl();
		return dataDAO.getData(monitorId, monitorBegin, monitorEnd);
	}

}
