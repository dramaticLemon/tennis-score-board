package com.dch.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/error-handler")
public class ErrorHandlerServlet extends HttpServlet{
	private static final Logger log = LoggerFactory.getLogger(ErrorHandlerServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		String message = (String) request.getAttribute("javax.servlet.error.message");

		int code = statusCode != null ? statusCode : 500;
		String msg = message != null ? message : (throwable != null ? throwable.getMessage() : "Unknown error");
		
		if (throwable != null) {
    		log.error("[{}] : {} : {}", code, throwable.getClass().getSimpleName(), msg, throwable);
		} else {
			log.error("[{}] : {}", code, msg);
		}
        response.getWriter().write("<h1>Упс! Что-то пошло не так</h1>");
	}
}
