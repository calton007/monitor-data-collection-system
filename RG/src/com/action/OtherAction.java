package com.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.ActionContext;
import org.apache.struts2.ActionSupport;
import org.apache.struts2.interceptor.parameter.StrutsParameter;

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
	@StrutsParameter
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	@StrutsParameter
	public void setEnd(Date end) {
		this.end = end;
	}
	public String submit() throws Exception
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(begin != null && end != null && begin.before(end))
		{
			session.put("begin", begin);
			session.put("end", end);
			
		}	
		else
		{
			session.remove("begin");
			session.remove("end");
			addActionError("请选择有效的监测日期，结束日期必须晚于开始日期");
			return INPUT;
		}
		return SUCCESS;
	}

}

