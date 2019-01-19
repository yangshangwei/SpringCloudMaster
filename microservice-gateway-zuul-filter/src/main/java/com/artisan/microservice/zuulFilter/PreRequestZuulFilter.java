package com.artisan.microservice.zuulFilter;


import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


public class PreRequestZuulFilter  extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return true;
	}


	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}
	
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request =    RequestContext.getCurrentContext().getRequest();
		System.out.println("pre filter, 请求路径："  +request.getRequestURI());
		return null;
	}


}
