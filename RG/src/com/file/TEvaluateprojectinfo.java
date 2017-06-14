package com.file;

import java.sql.Timestamp;

/**
 * TEvaluateprojectinfo entity. @author MyEclipse Persistence Tools
 */

public class TEvaluateprojectinfo implements java.io.Serializable {

	// Fields

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

	// Constructors

	/** default constructor */
	public TEvaluateprojectinfo() {
	}

	/** full constructor */
	public TEvaluateprojectinfo(Integer projectId, String projectName,
			String area, Timestamp submitDate, Timestamp submitDeadline,
			String status, Integer userId) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.area = area;
		this.submitDate = submitDate;
		this.submitDeadline = submitDeadline;
		this.status = status;
		this.userId = userId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Timestamp getSubmitDate() {
		return this.submitDate;
	}

	public void setSubmitDate(Timestamp submitDate) {
		this.submitDate = submitDate;
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

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	

}