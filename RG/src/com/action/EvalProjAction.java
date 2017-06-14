package com.action;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.file.TEvaluateprojectinfo;
import com.file.TSystemuser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.EvalProjService;
import com.service.imp.EvalProjServiceImpl;

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
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Timestamp getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Timestamp submitDate) {
		this.submitDate = submitDate;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getByUserId() throws Exception
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		TSystemuser user =	(TSystemuser) session.get("user");
		EvalProjService evalProjService = new EvalProjServiceImpl();
		List<TEvaluateprojectinfo> list = evalProjService.getByUserId(user.getEmployNumber());
		session.put("list", list);
		session.remove("monitorlist");
		return SUCCESS;		
	}
	
	public String queryProj() throws Exception
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		EvalProjService e = new EvalProjServiceImpl();
		TEvaluateprojectinfo pingjia = e.getProjById(id);
		session.put("pingjia", pingjia);
		session.remove("monitorlist");
		if(pingjia.getStatus().equals("未选定"))
			return "select";
		else
			return "query";
	}
	public String selectedStatus() throws Exception
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		EvalProjService e = new EvalProjServiceImpl();		
		TEvaluateprojectinfo n = (TEvaluateprojectinfo) session.get("pingjia");
		n.setStatus("已选定");
		e.selectedStatus(n);
		n = e.getProjById(n.getId());
		session.put("pingjia", n);
		return SUCCESS;
	}
}
