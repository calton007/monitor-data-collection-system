package com.action;

import java.util.List;
import java.util.Map;

import com.file.TEvaluateprojectinfo;
import com.file.TMonitorinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.MonitorService;
import com.service.imp.MonitorServiceImpl;

public class MonitorAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer monitorId;
	private String monitorName;
	private String area;
	private String monitorItem;
	private String monitorStatus;
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getMonitorItem() {
		return monitorItem;
	}
	public void setMonitorItem(String monitorItem) {
		this.monitorItem = monitorItem;
	}
	public String getMonitorStatus() {
		return monitorStatus;
	}
	public void setMonitorStatus(String monitorStatus) {
		this.monitorStatus = monitorStatus;
	}
	public String getByArea() throws Exception
	{
		
		MonitorService monitorService = new MonitorServiceImpl();
		Map<String, Object> session = ActionContext.getContext().getSession();
		TEvaluateprojectinfo t = (TEvaluateprojectinfo)session.get("pingjia");
		List<TMonitorinfo> list = monitorService.getByArea(t.getArea(),t.getProjectId());
		session.put("monitorarea", list);		
		return SUCCESS;
	}
	public String notGetByArea() throws Exception
	{
		
		MonitorService monitorService = new MonitorServiceImpl();
		Map<String, Object> session = ActionContext.getContext().getSession();
		TEvaluateprojectinfo t = (TEvaluateprojectinfo)session.get("pingjia");
		List<TMonitorinfo> list = monitorService.notGetByArea(t.getArea(),t.getProjectId());
		session.put("notmonitorarea", list);		
		return SUCCESS;
	}
	public String getMonitorById() throws Exception
	{
		MonitorService monitorService = new MonitorServiceImpl();
		TMonitorinfo m = monitorService.getMonitorById(id);
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("monitoritem", m);
		return SUCCESS;
	}

}
