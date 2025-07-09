package com.dch.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter("/*")
public class ErrorLoggingFilter implements Filter{
	private static final Logger log = LoggerFactory.getLogger(ErrorLoggingFilter.class);

	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            log.error("Error excecuted request", t);

            request.setAttribute("javax.servlet.error.status_code", 500);
            request.setAttribute("javax.servlet.error.exception", t);
            request.setAttribute("javax.servlet.error.message", t.getMessage());

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