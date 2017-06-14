package com.file;

/**
 * TMonitorinfo entity. @author MyEclipse Persistence Tools
 */

public class TMonitorinfo implements java.io.Serializable {

	// Fields

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

	// Constructors

	/** default constructor */
	public TMonitorinfo() {
	}

	/** full constructor */
	public TMonitorinfo(Integer monitorId, String monitorName, String area,
			String monitorItem, String monitorStatus) {
		this.monitorId = monitorId;
		this.monitorName = monitorName;
		this.area = area;
		this.monitorItem = monitorItem;
		this.monitorStatus = monitorStatus;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMonitorId() {
		return this.monitorId;
	}

	public void setMonitorId(Integer monitorId) {
		this.monitorId = monitorId;
	}

	public String getMonitorName() {
		return this.monitorName;
	}

	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMonitorItem() {
		return this.monitorItem;
	}

	public void setMonitorItem(String monitorItem) {
		this.monitorItem = monitorItem;
	}

	public String getMonitorStatus() {
		return this.monitorStatus;
	}

	public void setMonitorStatus(String monitorStatus) {
		this.monitorStatus = monitorStatus;
	}

}