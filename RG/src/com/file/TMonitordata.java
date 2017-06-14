package com.file;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * TMonitordata entity. @author MyEclipse Persistence Tools
 */

public class TMonitordata implements java.io.Serializable {

	// Fields

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

	// Constructors

	/** default constructor */
	public TMonitordata() {
	}

	/** full constructor */
	public TMonitordata(Integer monitorId, String monitorName,
			String monitorItem, Timestamp monitorDateTime, Float data) {
		this.monitorId = monitorId;
		this.monitorName = monitorName;
		this.monitorItem = monitorItem;
		this.monitorDateTime = monitorDateTime;
		this.data = data;
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

	public String getMonitorItem() {
		return this.monitorItem;
	}

	public void setMonitorItem(String monitorItem) {
		this.monitorItem = monitorItem;
	}

	public Date getMonitorDateTime() {
		return this.monitorDateTime;
	}

	public void setMonitorDateTime(Timestamp monitorDateTime) {
		this.monitorDateTime = monitorDateTime;
	}

	

	public Float getData() {
		return this.data;
	}

	public void setData(Float data) {
		this.data = data;
	}

}