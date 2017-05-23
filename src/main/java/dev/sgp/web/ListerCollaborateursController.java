package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

/**
 * Servlet implementation class ListerCollaborateursController
 */
//@WebServlet("/ListerCollaborateursController")
public class ListerCollaborateursController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// récupération du service

	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListerCollaborateursController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();

		request.setAttribute("collaborateurs", collaborateurs);
		
		request.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

		
		//doGet(request, response);
	}

}
