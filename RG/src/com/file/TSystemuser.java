package com.file;

/**
 * TSystemuser entity. @author MyEclipse Persistence Tools
 */

public class TSystemuser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer employNumber;
	private String employName;
	private String employType;
	private String sex;
	private String level;
	private String userName;
	private String password;
	private String department;
	private String group;

	// Constructors

	/** default constructor */
	public TSystemuser() {
	}

	/** minimal constructor */
	public TSystemuser(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TSystemuser(Integer id, Integer employNumber, String employName,
			String employType, String sex, String level, String userName,
			String password, String department, String group) {
		this.id = id;
		this.employNumber = employNumber;
		this.employName = employName;
		this.employType = employType;
		this.sex = sex;
		this.level = level;
		this.userName = userName;
		this.password = password;
		this.department = department;
		this.group = group;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmployNumber() {
		return this.employNumber;
	}

	public void setEmployNumber(Integer employNumber) {
		this.employNumber = employNumber;
	}

	public String getEmployName() {
		return this.employName;
	}

	public void setEmployName(String employName) {
		this.employName = employName;
	}

	public String getEmployType() {
		return this.employType;
	}

	public void setEmployType(String employType) {
		this.employType = employType;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}