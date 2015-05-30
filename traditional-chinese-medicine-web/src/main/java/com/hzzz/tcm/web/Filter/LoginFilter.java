package com.hzzz.tcm.web.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		if (req.getServletPath().indexOf("login") > 0 || req.getServletPath().indexOf("resources") > 0) {
			arg2.doFilter(request, response);
			return;
		}
		String contextPath = req.getContextPath();
		String servletPath = req.getServletPath();
		String servletName = request.getServerName();
		int serverPort = request.getServerPort();
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null || "".equals(username)) {
			res.sendRedirect("http://" + servletName + ":" + serverPort + contextPath + "/login");
		} else {
			// 已经登陆,继续此次请求
			arg2.doFilter(request, res);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
