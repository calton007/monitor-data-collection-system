package com.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.file.TDataacquiretask;
import com.file.TEvaluateprojectinfo;
import com.file.TMonitorinfo;
import com.file.TSystemuser;
import org.apache.struts2.ActionContext;
import org.apache.struts2.ActionSupport;
import org.apache.struts2.interceptor.parameter.StrutsParameter;
import com.service.DataAcqService;
import com.service.EvalProjService;
import com.service.MonitorService;
import com.service.imp.DataAcqServiceImpl;
import com.service.imp.EvalProjServiceImpl;
import com.service.imp.MonitorServiceImpl;


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
	@StrutsParameter
	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}
	public String getMonitorItem() {
		return monitorItem;
	}
	@StrutsParameter
	public void setMonitorItem(String monitorItem) {
		this.monitorItem = monitorItem;
	}
	public Integer getId() {
		return id;
	}
	@StrutsParameter
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTaskId() {
		return taskId;
	}
	@StrutsParameter
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	@StrutsParameter
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Integer getProjectId() {
		return projectId;
	}
	@StrutsParameter
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getArea() {
		return area;
	}
	@StrutsParameter
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getMonitorId() {
		return monitorId;
	}
	@StrutsParameter
	public void setMonitorId(Integer monitorId) {
		this.monitorId = monitorId;
	}
	public Date getMonitorBegin() {
		return monitorBegin;
	}
	@StrutsParameter
	public void setMonitorBegin(Date monitorBegin) {
		this.monitorBegin = monitorBegin;
	}
	public Date getMonitorEnd() {
		return monitorEnd;
	}
	@StrutsParameter
	public void setMonitorEnd(Date monitorEnd) {
		this.monitorEnd = monitorEnd;
	}
	public Timestamp getSubmitDeadline() {
		return submitDeadline;
	}
	@StrutsParameter
	public void setSubmitDeadline(Timestamp submitDeadline) {
		this.submitDeadline = submitDeadline;
	}
	public String getStatus() {
		return status;
	}
	@StrutsParameter
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getCharger() {
		return charger;
	}
	@StrutsParameter
	public void setCharger(Integer charger) {
		this.charger = charger;
	}
	public String queryProj() throws Exception
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		DataAcqService dataAcqService = new DataAcqServiceImpl();
		TEvaluateprojectinfo t = (TEvaluateprojectinfo)session.get("pingjia");
		if (t == null) {
			session.put("taskEntry", Boolean.TRUE);
			refreshProjectList(session);
			addActionError("请先选择评价项目");
			return INPUT;
		}
		session.remove("taskEntry");
		List<TDataacquiretask> list = dataAcqService.getByProjId(t.getProjectId());
		session.put("monitorlist", list);
		session.put("hasMonitorTasks", list != null && !list.isEmpty());
		if(list != null && list.size()>0)
			session.put("monitorhead", list.get(0));
		else
			session.remove("monitorhead");
		MonitorService monitorService = new MonitorServiceImpl();
		session.put("monitorarea", monitorService.getByArea(t.getArea(), t.getProjectId()));
		return SUCCESS;
	}
	public String newDataAcq()throws Exception
	{
		TDataacquiretask task = new TDataacquiretask();
		DataAcqService dataAcqService = new DataAcqServiceImpl();
		Map<String, Object> session = ActionContext.getContext().getSession();
		TEvaluateprojectinfo project = (TEvaluateprojectinfo)session.get("pingjia");
		TMonitorinfo info = (TMonitorinfo)session.get("monitoritem");
		Object begin = session.get("begin");
		Object end = session.get("end");
		if (project == null || info == null || !(begin instanceof Date) || !(end instanceof Date)) {
			if (project == null) {
				refreshProjectList(session);
				addActionError("请先选择评价项目");
			} else if (info == null) {
				addActionError("请先选择监测点");
				refreshMonitorLists(session, dataAcqService, project);
			} else {
				addActionError("请先选择监测日期");
				refreshMonitorLists(session, dataAcqService, project);
			}
			return INPUT;
		}
		if (dataAcqService.existsByProjectAndMonitor(project.getProjectId(), info.getMonitorId())) {
			addActionError("该监测点已选择");
			refreshMonitorLists(session, dataAcqService, project);
			return INPUT;
		}
		task.setTaskId(project.getProjectId());
		task.setTaskName(project.getProjectName());
		task.setProjectId(project.getProjectId());
		task.setArea(project.getArea());
		task.setMonitorId(info.getMonitorId());
		task.setMonitorName(info.getMonitorName());
		task.setMonitorItem(info.getMonitorItem());
		task.setMonitorBegin((Date)begin);
		task.setMonitorEnd((Date)end);
		task.setSubmitDeadline(project.getSubmitDeadline());
		if(info.getMonitorId()>=1 && info.getMonitorId()<=10)
			task.setStatus("已完成");
		else
			task.setStatus("处理中");
		task.setCharger(10002);
		dataAcqService.newDataAcq(task);		
		refreshMonitorLists(session, dataAcqService, project);
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
		if (project == null || id == null) {
			return INPUT;
		}
		dataAcqService.delDataAcq(id, project.getProjectId());
		List<TDataacquiretask> list = dataAcqService.getByProjId(project.getProjectId());
		session.put("monitorlist", list);
		session.put("hasMonitorTasks", list != null && !list.isEmpty());
		if(list != null && list.size()>0)
			session.put("monitorhead", list.get(0));
		else
			session.remove("monitorhead");
		MonitorService monitorService = new MonitorServiceImpl();
		session.put("monitorarea", monitorService.getByArea(project.getArea(), project.getProjectId()));
		return SUCCESS;
		
	}

	private void refreshProjectList(Map<String, Object> session)
	{
		TSystemuser user = (TSystemuser) session.get("user");
		if (user == null) {
			return;
		}
		EvalProjService evalProjService = new EvalProjServiceImpl();
		session.put("list", evalProjService.getByUserId(user.getEmployNumber()));
	}

	private void refreshMonitorLists(Map<String, Object> session, DataAcqService dataAcqService,
			TEvaluateprojectinfo project)
	{
		List<TDataacquiretask> list = dataAcqService.getByProjId(project.getProjectId());
		session.put("monitorlist", list);
		session.put("hasMonitorTasks", list != null && !list.isEmpty());
		if(list != null && list.size()>0)
			session.put("monitorhead", list.get(0));
		else
			session.remove("monitorhead");
		MonitorService monitorService = new MonitorServiceImpl();
		session.put("monitorarea", monitorService.getByArea(project.getArea(), project.getProjectId()));
	}

}

