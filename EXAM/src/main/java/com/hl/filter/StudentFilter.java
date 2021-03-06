package com.hl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.hl.entity.Userinfo;

public class StudentFilter implements Filter{
	private static Logger logger = Logger.getLogger(StudentFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		logger.info("==============学生权限过滤器初始化================");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("==============学生权限过滤器执行中================");
		HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;
	    String contextPath = req.getContextPath();
		Userinfo user = (Userinfo) req.getSession().getAttribute("crruentUser");
		if (user.getRoleid() != 1) { //权限是学生
			logger.info("==============学生权限过滤器跳转================");
			res.sendRedirect(contextPath + "/role_error.html");
		} else {
			logger.info("==============学生权限过滤器放行================");
			chain.doFilter(req, res);
		}
	     
		
	}

	@Override
	public void destroy() {
		logger.info("==============学生过滤器销毁================");
		
	}

}
