package com.hzzz.tcm.web.controller;

import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {
	private static Properties enviroment;

	static {
		try {
			enviroment = new Properties();
			InputStream in = BaseController.class.getResourceAsStream("/environment.properties");
			enviroment.load(in);
		} catch (Exception e) {
		}
	}
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected int whichmainmenu;

	protected String queue_sendmail = enviroment.getProperty("queue.sendmail");

	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

	protected void outPutJson(String json) {
		this.output(json, "application/x-json;charset=UTF-8");
	}

	private void output(String str, String contentType) {
		HttpServletResponse reps = this.response;
		reps.reset();
		reps.setCharacterEncoding("UTF-8");
		reps.setContentType(contentType);
		try {
			PrintWriter out = reps.getWriter();
			out.print(str);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getWhichmainmenu() {
		return whichmainmenu;
	}

	public void setWhichmainmenu(int whichmainmenu) {
		this.whichmainmenu = whichmainmenu;
	}

}
