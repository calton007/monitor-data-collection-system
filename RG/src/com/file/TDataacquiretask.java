package com.file;

import java.sql.Timestamp;
import java.util.Date;

/**
 * TDataacquiretask entity. @author MyEclipse Persistence Tools
 */

public class TDataacquiretask implements java.io.Serializable {

	// Fields

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

	// Constructors

	/** default constructor */
	public TDataacquiretask() {
	}

	/** full constructor */
	public TDataacquiretask(Integer taskId, String taskName, Integer projectId,
			String area, Integer monitorId, Date monitorBegin,
			Date monitorEnd, Timestamp submitDeadline, String status,
			Integer charger, String monitorName, String monitorItem) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.projectId = projectId;
		this.area = area;
		this.monitorId = monitorId;
		this.monitorBegin = monitorBegin;
		this.monitorEnd = monitorEnd;
		this.submitDeadline = submitDeadline;
		this.status = status;
		this.charger = charger;
		this.monitorName = monitorName;
		this.monitorItem = monitorItem;
	}

	// Property accessors

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
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getMonitorId() {
		return this.monitorId;
	}

	public void setMonitorId(Integer monitorId) {
		this.monitorId = monitorId;
	}

	

	public Date getMonitorBegin() {
		return this.monitorBegin;
	}

	public void setMonitorBegin(Date monitorBegin) {
		this.monitorBegin = monitorBegin;
	}

	public Date getMonitorEnd() {
		return this.monitorEnd;
	}

	public void setMonitorEnd(Date monitorEnd) {
		this.monitorEnd = monitorEnd;
	}

	public Timestamp getSubmitDeadline() {
		return this.submitDeadline;
	}

	public void setSubmitDeadline(Timestamp submitDeadline) {
		this.submitDeadline = submitDeadline;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCharger() {
		return this.charger;
	}

	public void setCharger(Integer charger) {
		this.charger = charger;
	}

}