package com.action;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OtherAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date begin;
	private Date end;
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String submit() throws Exception
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(begin.before(end))
		{
			session.put("begin", begin);
			session.put("end", end);
			
		}	
		else
		{
			session.put("begin", "日期有误");
			session.put("end", "日期有误");
		}
		return SUCCESS;
	}

}
