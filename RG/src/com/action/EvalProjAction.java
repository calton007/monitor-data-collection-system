package com.action;

import java.sql.Timestamp;
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

public class EvalProjAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;	
	private Integer projectId;
	private String projectName;
	private String area;
	private Timestamp submitDate;
	private Timestamp submitDeadline;
	private String status;
	private Integer userId;
	public Integer getId() {
		return id;
	}
	@StrutsParameter
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProjectId() {
		return projectId;
	}
	@StrutsParameter
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	@StrutsParameter
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getArea() {
		return area;
	}
	@StrutsParameter
	public void setArea(String area) {
		this.area = area;
	}
	public Timestamp getSubmitDate() {
		return submitDate;
	}
	@StrutsParameter
	public void setSubmitDate(Timestamp submitDate) {
		this.submitDate = submitDate;
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
	public Integer getUserId() {
		return userId;
	}
	@StrutsParameter
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getByUserId() throws Exception
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		TSystemuser user =	(TSystemuser) session.get("user");
		if (user == null) {
			return "login";
		}
		EvalProjService evalProjService = new EvalProjServiceImpl();
		List<TEvaluateprojectinfo> list = evalProjService.getByUserId(user.getEmployNumber());
		session.put("list", list);
		session.remove("monitorlist");
		session.remove("taskEntry");
		return SUCCESS;		
	}
	
	public String queryProj() throws Exception
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("taskEntry");
		EvalProjService e = new EvalProjServiceImpl();
		TEvaluateprojectinfo pingjia = e.getProjById(id);
		if (pingjia == null) {
			return INPUT;
		}
		session.put("pingjia", pingjia);
		DataAcqService dataAcqService = new DataAcqServiceImpl();
		List<TDataacquiretask> monitorList = dataAcqService.getByProjId(pingjia.getProjectId());
		session.put("monitorlist", monitorList);
		session.put("hasMonitorTasks", monitorList != null && !monitorList.isEmpty());
		if(monitorList != null && !monitorList.isEmpty()) {
			session.put("monitorhead", monitorList.get(0));
		} else {
			session.remove("monitorhead");
		}
		MonitorService monitorService = new MonitorServiceImpl();
		List<TMonitorinfo> monitorArea = monitorService.getByArea(pingjia.getArea(), pingjia.getProjectId());
		session.put("monitorarea", monitorArea);
		if("未选定".equals(pingjia.getStatus()))
			return "select";
		else
			return "query";
	}
	public String selectedStatus() throws Exception
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		EvalProjService e = new EvalProjServiceImpl();		
		TEvaluateprojectinfo n = (TEvaluateprojectinfo) session.get("pingjia");
		if (n == null) {
			return INPUT;
		}
		n.setStatus("已选定");
		e.selectedStatus(n);
		n = e.getProjById(n.getId());
		session.put("pingjia", n);
		return SUCCESS;
	}
}

