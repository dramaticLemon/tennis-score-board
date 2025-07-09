package com.dch.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("unchecked")
@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet{

	@Override
	protected void doGet(
        HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
			String path = "/create-match.jsp";
			ServletContext servletContext = getServletContext();
			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
			requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(
        HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {

			String uuid = String.valueOf(UUID.randomUUID());
			// get user names form parameter
			// logic create current match object
			// перенаправить на отображение таблицы
			String path = request.getContextPath() + "/match-score";
			String redirectURL = path + "?match_id=" + uuid;
			response.sendRedirect(redirectURL);
			
	}
}
