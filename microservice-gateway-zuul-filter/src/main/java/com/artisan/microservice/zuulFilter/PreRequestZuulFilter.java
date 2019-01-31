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
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		System.out.println("pre filter, 请求路径："  +request.getRequestURI());
		String token = request.getParameter("accessToken");
		if (token == null) {
			ctx.setSendZuulResponse(false);
			ctx.setResponseBody("no accesss");
			ctx.setResponseStatusCode(401);
		}
		return null;
	}


}
