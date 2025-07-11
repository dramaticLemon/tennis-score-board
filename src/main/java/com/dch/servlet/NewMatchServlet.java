package com.dch.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dch.repository.PlayerRepository;
import com.dch.service.OngoingMatchesService;
import com.dch.utils.JpaUtil;
import com.dch.utils.TransactionHelper;

import jakarta.persistence.EntityManagerFactory;

@SuppressWarnings("unchecked")
@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet{

	private OngoingMatchesService ongoingMatchesService;

    @Override
    public void init() {
		EntityManagerFactory emf = JpaUtil.getTennisEntityManagerFactory();
		TransactionHelper transactionHelper = new TransactionHelper(emf);
		PlayerRepository playerRepository = new PlayerRepository(transactionHelper, emf);
        this.ongoingMatchesService = new OngoingMatchesService(playerRepository);
    }

	@Override
	protected void doGet(
        HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
			String path = "/create-match.jsp";
			ServletContext servletContext = getServletContext();
			response.setContentType("text/html;charset=UTF-8");
    		request.setCharacterEncoding("UTF-8");

			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
			requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(
        HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {

			String playerOneName = request.getParameter("player-one-name");
			String playerTwoName = request.getParameter("player-two-name");
	
			if (playerOneName.equalsIgnoreCase(playerTwoName)) {
				request.setAttribute(
					"errorMessage", "Игроки не могут быть одинаковыми");
				request.getRequestDispatcher("/create-match.jsp").forward(request, response);
				return;
			}

			// logic create current match object
			String uuid = ongoingMatchesService.createMatch(playerOneName, playerTwoName);
			
			String path = request.getContextPath() + "/match-score";
			String redirectURL = path + "?match_id=" + uuid;
			response.sendRedirect(redirectURL);
			
	}
}
