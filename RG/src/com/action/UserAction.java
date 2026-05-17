package com.action;

import java.util.Map;

import com.file.TSystemuser;
import org.apache.struts2.ActionContext;
import org.apache.struts2.ActionSupport;
import org.apache.struts2.interceptor.parameter.StrutsParameter;
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
	@StrutsParameter
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployNumber() {
		return employNumber;
	}
	@StrutsParameter
	public void setEmployNumber(int employNumber) {
		this.employNumber = employNumber;
	}
	public String getEmployName() {
		return employName;
	}
	@StrutsParameter
	public void setEmployName(String employName) {
		this.employName = employName;
	}
	public String getEmployType() {
		return employType;
	}
	@StrutsParameter
	public void setEmployType(String employType) {
		this.employType = employType;
	}
	public String getSex() {
		return sex;
	}
	@StrutsParameter
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLevel() {
		return level;
	}
	@StrutsParameter
	public void setLevel(String level) {
		this.level = level;
	}
	public String getUserName() {
		return userName;
	}
	@StrutsParameter
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	@StrutsParameter
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment() {
		return department;
	}
	@StrutsParameter
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getGroup() {
		return group;
	}
	@StrutsParameter
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

