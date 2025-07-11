package com.dch.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dch.repository.PlayerRepository;
import com.dch.service.OngoingMatchesService;
import com.dch.service.calculate.score.logic.CurrentMatch;
import com.dch.service.calculate.score.logic.GameEvent;
import com.dch.service.calculate.score.logic.enums.GameEventType;
import com.dch.utils.JpaUtil;
import com.dch.utils.TransactionHelper;

import jakarta.persistence.EntityManagerFactory;

@SuppressWarnings("unchecked")
@WebServlet("/match-score")
public class MatchScoreServlet extends HttpServlet {
	private OngoingMatchesService ongoingMatchesService;
	private static final Logger log = LoggerFactory.getLogger(MatchScoreServlet.class);

    @Override
    public void init() {
        EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		TransactionHelper transactionHelper = new TransactionHelper(emf);
		PlayerRepository playerRepository = new PlayerRepository(transactionHelper, emf);
        this.ongoingMatchesService = new OngoingMatchesService(playerRepository);
    }
    

	@Override
	protected void doGet(
        HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
			String path = "/view-score-table.jsp";
			String uuid = request.getParameter("match_id");

			ServletContext servletContext = getServletContext();
			CurrentMatch currentMatch = ongoingMatchesService.getMatchbyUUID(uuid);

			request.setAttribute("first-name", currentMatch.getFirstName());
			request.setAttribute("last-name", currentMatch.getLastName());
			request.setAttribute("sets-score-first", currentMatch.getPlayerOneSetScore());
			request.setAttribute("sets-score-last", currentMatch.getPlayerTwoSetScore());
			request.setAttribute("games-score-first", currentMatch.getPlayerOneGameScore());
			request.setAttribute("games-score-last", currentMatch.getPlayerTwoGameScore());
			request.setAttribute("points-score-first", currentMatch.getPlayerOnePointScore());
			request.setAttribute("points-score-last", currentMatch.getPlayerTwoPointScore());

			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
			requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(
		HttpServletRequest request, HttpServletResponse response)
		throws  ServletException, IOException {
			String path = "/view-score-table.jsp";
			String finishPath = "/final-table-score.jsp";
			String uuid = request.getParameter("match_id");
			String name = request.getParameter("username");

			ServletContext servletContext = getServletContext();

			CurrentMatch currentMatch = ongoingMatchesService.getMatchbyUUID(uuid);
			GameEvent event = currentMatch.recordPoint(name);

			if(event.getType().equals(GameEventType.MATCH_WON)) {
				request.setAttribute("first-name", currentMatch.getFirstName());
				request.setAttribute("last-name", currentMatch.getLastName());
				request.setAttribute("sets-score-first", currentMatch.getPlayerOneSetScore());
				request.setAttribute("sets-score-last", currentMatch.getPlayerTwoSetScore());
				request.setAttribute("games-score-first", currentMatch.getPlayerOneGameScore());
				request.setAttribute("games-score-last", currentMatch.getPlayerTwoGameScore());
				request.setAttribute("points-score-first", currentMatch.getPlayerOnePointScore());
				request.setAttribute("points-score-last", currentMatch.getPlayerTwoPointScore());

				RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(finishPath);
			requestDispatcher.forward(request, response);
			return;
			}

			request.setAttribute("first-name", currentMatch.getFirstName());
			request.setAttribute("last-name", currentMatch.getLastName());
			request.setAttribute("sets-score-first", currentMatch.getPlayerOneSetScore());
			request.setAttribute("sets-score-last", currentMatch.getPlayerTwoSetScore());
			request.setAttribute("games-score-first", currentMatch.getPlayerOneGameScore());
			request.setAttribute("games-score-last", currentMatch.getPlayerTwoGameScore());
			request.setAttribute("points-score-first", currentMatch.getPlayerOnePointScore());
			request.setAttribute("points-score-last", currentMatch.getPlayerTwoPointScore());

			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
			requestDispatcher.forward(request, response);
		}
}
	
