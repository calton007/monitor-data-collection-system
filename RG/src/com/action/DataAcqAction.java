package com.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.file.TDataacquiretask;
import com.file.TEvaluateprojectinfo;
import com.file.TMonitorinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.DataAcqService;
import com.service.imp.DataAcqServiceImpl;


public class DataAcqAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer taskId;
	private String taskName;
	private Integer projectId;
	private String area;
	private Integer monitorId;
	private Date monitorBegin;
	private Date monitorEnd;
	private Timestamp submitDeadline;
	private String status;
	private Integer charger;
	private String monitorName;
	private String monitorItem;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getMonitorId() {
		return monitorId;
	}
	public void setMonitorId(Integer monitorId) {
		this.monitorId = monitorId;
	}
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
	public Timestamp getSubmitDeadline() {
		return submitDeadline;
	}
	public void setSubmitDeadline(Timestamp submitDeadline) {
		this.submitDeadline = submitDeadline;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getCharger() {
		return charger;
	}
	public void setCharger(Integer charger) {
		this.charger = charger;
	}
	public String queryProj() throws Exception
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		DataAcqService dataAcqService = new DataAcqServiceImpl();
		TEvaluateprojectinfo t = (TEvaluateprojectinfo)session.get("pingjia");
		List<TDataacquiretask> list = dataAcqService.getByProjId(t.getProjectId());
		session.put("monitorlist", list);
		if(list != null && list.size()>0)
			session.put("monitorhead", list.get(0));
		return SUCCESS;
	}
	public String newDataAcq()throws Exception
	{
		TDataacquiretask task = new TDataacquiretask();
		DataAcqService dataAcqService = new DataAcqServiceImpl();
		Map<String, Object> session = ActionContext.getContext().getSession();
		TEvaluateprojectinfo project = (TEvaluateprojectinfo)session.get("pingjia");
		TMonitorinfo info = (TMonitorinfo)session.get("monitoritem");
		task.setTaskId(project.getProjectId());
		task.setTaskName(project.getProjectName());
		task.setProjectId(project.getProjectId());
		task.setArea(project.getArea());
		task.setMonitorId(info.getMonitorId());
		task.setMonitorName(info.getMonitorName());
		task.setMonitorItem(info.getMonitorItem());
		task.setMonitorBegin((Date)session.get("begin"));
		task.setMonitorEnd((Date)session.get("end"));
		task.setSubmitDeadline(project.getSubmitDeadline());
		if(info.getMonitorId()>=1 && info.getMonitorId()<=10)
			task.setStatus("已完成");
		else
			task.setStatus("处理中");
		task.setCharger(10002);
		dataAcqService.newDataAcq(task);		
		List<TDataacquiretask> list = dataAcqService.getByProjId(project.getProjectId());
		session.put("monitorlist", list);
		if(list != null && list.size()>0)
			session.put("monitorhead", list.get(0));
		return SUCCESS;		
	}
	public String getSingleMonitor() throws Exception
	{
		DataAcqService dataAcqService = new DataAcqServiceImpl();
		TDataacquiretask task = dataAcqService.getById(id);
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("singlemonitor", task);		
		return SUCCESS;
	}
	public String delDataAcq() throws Exception
	{
		DataAcqService dataAcqService = new DataAcqServiceImpl();
		Map<String, Object> session = ActionContext.getContext().getSession();
		TEvaluateprojectinfo project = (TEvaluateprojectinfo)session.get("pingjia");
		dataAcqService.delDataAcq(id, project.getProjectId());
		List<TDataacquiretask> list = dataAcqService.getByProjId(project.getProjectId());
		session.put("monitorlist", list);
		if(list != null && list.size()>0)
			session.put("monitorhead", list.get(0));
		return SUCCESS;
		
	}

}
