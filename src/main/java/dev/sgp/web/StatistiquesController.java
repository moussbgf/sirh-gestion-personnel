package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisitesWebService;
import dev.sgp.util.Constantes;


//@WebServlet("/Statistiques")
public class StatistiquesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private VisitesWebService visiteService = Constantes.VISITE_SERVICE;

    public StatistiquesController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<VisiteWeb> listeVisites = visiteService.listerDepartements();
		
		request.setAttribute("listeVisites", listeVisites);
		
		request.getRequestDispatcher("/WEB-INF/views/statistiques/statistiques.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
