package com.action;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.file.TMonitordata;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.DataService;
import com.service.imp.DataServiceImpl;

public class DataAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer monitorId;
	private String monitorName;
	private String monitorItem;
	private Timestamp monitorDateTime;
	private Float data;
	private Date monitorBegin;
	private Date monitorEnd;
	public Date getMonitorBegin() {
		return monitorBegin;
	}
	public void setMonitorBegin(Date monitorBegin) {
		this.monitorBegin = monitorBegin;
	}
	public Date getMonitorEnd() {
		return monitorEnd;
	}
	public void setMonitorEnd(Date monitorEnd) {
		this.monitorEnd = monitorEnd;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMonitorId() {
		return monitorId;
	}
	public void setMonitorId(Integer monitorId) {
		this.monitorId = monitorId;
	}
	public String getMonitorName() {
		return monitorName;
	}
	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}
	public String getMonitorItem() {
		return monitorItem;
	}
	public void setMonitorItem(String monitorItem) {
		this.monitorItem = monitorItem;
	}
	public Timestamp getMonitorDateTime() {
		return monitorDateTime;
	}
	public void setMonitorDateTime(Timestamp monitorDateTime) {
		this.monitorDateTime = monitorDateTime;
	}
	
	public Float getData() {
		return data;
	}
	public void setData(Float data) {
		this.data = data;
	}
	public String getMonitorData() throws Exception
	{
		DataService dataservice = new DataServiceImpl();
		Map<String, Object> session = ActionContext.getContext().getSession();
		List<TMonitordata> list = dataservice.getData(monitorId, monitorBegin, monitorEnd);
		session.put("datalist",list);
		if(list!=null && list.size()>0)
		{
			session.put("datahead", list.get(0));
			session.put("dataend", list.get(list.size()-1));
		}
		exportCSV();
		return SUCCESS;
	}
	public void exportCSV()throws Exception
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		@SuppressWarnings("unchecked")
		List<TMonitordata> list = (List<TMonitordata>)session.get("datalist");
		DateFormat f = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String temp;
		String[] s;
		Float avg=(float)0, now;
		Integer size;
		size=list.size();
		for(int i=0;i<size;i++)
			avg+=list.get(i).getData();
		avg/=list.size();
		try {
			   FileWriter fw = new FileWriter("C:\\Program Files\\Tomcat 7\\webapps\\RG\\test.csv");
			   String header = "MonitorDate,MonitorTime,Data1,Data2\r\n";
			   fw.write(header);
			   
				    StringBuffer str = new StringBuffer();
				    for (int j = 0; j < size; j++) 
				    {
				    	now = list.get(j).getData();
				    	s= f.format(list.get(j).getMonitorDateTime()).split(" ");
				    	temp = s[0]+","+s[1]+","+now.toString()+","+avg.toString()+"\r\n";
				    	str.append(temp);
				    }
				    fw.write(str.toString());
				    fw.flush();
			  
			   fw.close();
			  } 
		catch (IOException e) 
		{
			   e.printStackTrace();
		}
				
		
	}

}
