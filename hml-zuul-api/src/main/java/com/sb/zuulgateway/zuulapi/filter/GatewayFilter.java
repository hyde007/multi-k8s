package com.sb.zuulgateway.zuulapi.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class GatewayFilter extends ZuulFilter {
	
	private Logger LOGGER = LoggerFactory.getLogger(GatewayFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
		LOGGER.info("req: "+req.getRequestURL());
		
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
