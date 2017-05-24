package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dev.sgp.entite.CollabEvt;
import dev.sgp.service.ActiviteService;


@WebServlet("/collaborateurs/activites")
public class ActiviteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject private ActiviteService activiteService;

    public ActiviteController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<CollabEvt> listActivite = activiteService.listerActivitesCollab();
		
		request.setAttribute("listActivite", listActivite);
		
		request.getRequestDispatcher("/WEB-INF/views/statistiques/activites.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		doGet(request, response);
	}

}
