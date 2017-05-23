package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisitesWebService;
import dev.sgp.util.Constantes;


@WebServlet("/collaborateurs/nouveau")
public class StatistiquesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private VisitesWebService visiteService = Constantes.VISITE_SERVICE;

    public StatistiquesController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<VisiteWeb> listeVisites = visiteService.listerDepartements();
		
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
        

		
		request.setAttribute("listeVisites", listeVisites);
		
		request.getRequestDispatcher("/WEB-INF/views/statistiques/statistiques.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
