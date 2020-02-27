package com.javadeveloperzone;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class MyFilter implements Filter {

	private ServletContext context;

	@Override
	public void init (FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter (ServletRequest request,
			ServletResponse response, FilterChain chain)
					throws IOException, ServletException {
		String url = request instanceof HttpServletRequest ?
				((HttpServletRequest) request).getRequestURL().toString() : "N/A";
				System.out.println("from filter, processing url: " + url);
				
				HttpServletResponse res = (HttpServletResponse) response;
		        res.setHeader("Access-Control-Allow-Origin", "*");
		        res.setHeader("Access-Control-Allow-Credentials", "true");
				res.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
				res.setHeader("Access-Control-Max-Age", "3600");
		        res.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
				
				HttpServletRequest req = (HttpServletRequest) request;
				Enumeration<String> params = req.getParameterNames();
				Map<String, Object> modelMap = new HashMap<>();
				while(params.hasMoreElements()){
					String name = params.nextElement();
					modelMap.put(params.nextElement(), request.getParameter(params.nextElement()));

					//this.context.log(req.getRemoteAddr() + "::Request Params::{"+name+"="+value+"}");
				}

				/*
				 * Cookie[] cookies = req.getCookies(); if(cookies != null){ for(Cookie cookie :
				 * cookies){ this.context.log(req.getRemoteAddr() +
				 * "::Cookie::{"+cookie.getName()+","+cookie.getValue()+"}"); } }
				 */
				// pass the request along the filter chain
				chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
	}

	@Override
	public void destroy () {
	}
}