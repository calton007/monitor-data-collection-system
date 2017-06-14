package com.action;

import java.util.Map;

import com.file.TSystemuser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;
import com.service.imp.UserServiceImpl;

public class UserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int employNumber;
	private String employName;
	private String employType;
	private String sex;
	private String level;
	private String userName;
	private String password;
	private String department;
	private String group;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployNumber() {
		return employNumber;
	}
	public void setEmployNumber(int employNumber) {
		this.employNumber = employNumber;
	}
	public String getEmployName() {
		return employName;
	}
	public void setEmployName(String employName) {
		this.employName = employName;
	}
	public String getEmployType() {
		return employType;
	}
	public void setEmployType(String employType) {
		this.employType = employType;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	public String login() throws Exception
	{
		UserService userService = new UserServiceImpl();
		TSystemuser user = userService.login(userName, password);
		Map<String, Object> session = ActionContext.getContext().getSession(); 		
		
		if(user!=null)
		{			
			session.put("user", user);
			return "success";
		}
		else
			return "fail";
	}
	

}
