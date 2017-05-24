package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dev.sgp.entite.VisiteLog;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisitesWebService;


@WebServlet("/collaborateurs/statistiques")
public class StatistiquesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject private VisitesWebService visiteService;

    public StatistiquesController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<VisiteWeb> listeVisitesWeb = visiteService.listerVisites();
		
		List<VisiteLog> listeVisiteLog = visiteService.construireStatistiques();
		
//		int nbNouveau = (int) listeVisites.stream()
//                .filter(x -> x.getChemin().equals("/sgp/collaborateurs/nouveau")).count();
//        int maxNouveau = listeVisites.stream().filter(x -> x.getChemin().equals("/sgp/collaborateurs/nouveau"))
//                .max((p1, p2) -> Integer.compare(p1.getTempsExecution(), p2.getTempsExecution())).get()
//                .getTempsExecution();
//        int minNouveau = listeVisites.stream().filter(x -> x.getChemin().equals("/sgp/collaborateurs/nouveau"))
//                .min((p1, p2) -> Integer.compare(p1.getTempsExecution(), p2.getTempsExecution())).get()
//                .getTempsExecution();
//        
//        int nbLister = (int) listeVisites.stream()
//                .filter(x -> x.getChemin().equals("/sgp/collaborateurs/lister")).count();
//        int maxLister = listeVisites.stream().filter(x -> x.getChemin().equals("/sgp/collaborateurs/lister"))
//                .max((p1, p2) -> Integer.compare(p1.getTempsExecution(), p2.getTempsExecution())).get()
//                .getTempsExecution();
//        int minLister = listeVisites.stream().filter(x -> x.getChemin().equals("/sgp/collaborateurs/lister"))
//                .min((p1, p2) -> Integer.compare(p1.getTempsExecution(), p2.getTempsExecution())).get()
//                .getTempsExecution();
        

		
		request.setAttribute("listeVisitesWeb", listeVisitesWeb);
		
		request.setAttribute("listeVisiteLog", listeVisiteLog);
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/statistiques/statistiques.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
