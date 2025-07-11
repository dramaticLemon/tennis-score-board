package com.dch.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dch.models.Match;
import com.dch.repository.MatchRepository;
import com.dch.repository.PlayerRepository;
import com.dch.service.FinishMatchesPersistenseService;
import com.dch.utils.JpaUtil;
import com.dch.utils.TransactionHelper;

import jakarta.persistence.EntityManagerFactory;

@WebServlet("/mathes")
public class ArhiveMatchesServlet extends HttpServlet{
	
	FinishMatchesPersistenseService finishMatchesPersistenseService;

	

    @Override
    public void init() {
		EntityManagerFactory emf = JpaUtil.getArchiveEntityManagerFactory();
		TransactionHelper transactionHelper = new TransactionHelper(emf);
		PlayerRepository playerRepository = new PlayerRepository(transactionHelper, emf);
		MatchRepository matchRepository = new MatchRepository(transactionHelper, emf);
        finishMatchesPersistenseService = new FinishMatchesPersistenseService(
			transactionHelper, emf, playerRepository, matchRepository);
    }

	@Override
	protected void doGet(
        HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
			String path = "/arhive-matches.jsp";
			ServletContext servletContext = getServletContext();
			response.setContentType("text/html;charset=UTF-8");
    		request.setCharacterEncoding("UTF-8");

			int page = 1;
			int pageSize = 3;

			try {
				page = Integer.parseInt(request.getParameter("page"));
				if (page < 1) page = 1;
			} catch (Exception ignored) {}


			List<Match> list = finishMatchesPersistenseService.findMatchesPaginated(page, pageSize);
			long totalMatches = finishMatchesPersistenseService.countMatches();
			int totalPages = (int) Math.ceil((double) totalMatches / pageSize);


			request.setAttribute("matchesList", list);
			request.setAttribute("currentPage", page);
			request.setAttribute("totalPages", totalPages);

			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
			requestDispatcher.forward(request, response);
		}
	
	@Override
	protected void doPost(
		HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
			String path = "/arhive-matches.jsp";
			String query = request.getParameter("query");
			System.out.println("Inputed query is " + query);

			ServletContext servletContext = getServletContext();
			response.setContentType("text/html;charset=UTF-8");
    		request.setCharacterEncoding("UTF-8");

			List<Match> list = finishMatchesPersistenseService.findMatchesByPlayerName(query);
			request.setAttribute("matchesList", list);
			
			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
			requestDispatcher.forward(request, response);


		}
}
