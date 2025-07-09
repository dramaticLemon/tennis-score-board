package com.dch.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class HeadersFilter implements Filter{
	
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");

		try {
			chain.doFilter(request, response);
		} catch (Throwable t) {
			request.setAttribute("javax.servlet.error.exception", t);
			request.getRequestDispatcher("/error-handler").forward(request, response);
		}
    }

	@Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }
}
