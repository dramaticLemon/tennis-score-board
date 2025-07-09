package com.dch.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("unchecked")
@WebServlet("/match-score")
public class MatchScoreServlet extends HttpServlet {
	@Override
	protected void doGet(
        HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
			String path = "/view-score-table.jsp";
			String uuid = request.getParameter("match_id");

			ServletContext servletContext = getServletContext();
			request.setAttribute("match_id", uuid);
			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
			requestDispatcher.forward(request, response);
	}
}
	
