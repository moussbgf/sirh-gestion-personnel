package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;


@WebServlet("/collaborateurs/lister")
public class ListerCollaborateursController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// récupération du service

	//private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	//private DepartementService dptService = Constantes.DEPT_SERVICE;
	
	@Inject private CollaborateurService collabService;
	@Inject private DepartementService dptService;

	public ListerCollaborateursController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();

		List<Departement> departements = dptService.listerDepartements();
		
		
		request.setAttribute("collaborateurs", collaborateurs);
		
		request.setAttribute("departements", departements);
		
		request.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp")
		.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//doGet(request, response);
	}

}
