package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;


@WebServlet("/collaborateurs/editer")
public class EditerCollaborateurController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;


	public EditerCollaborateurController() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		
		//response.getWriter().write("<h1>Hello EditerCollaborateurController</h1>");
		
		request.getRequestDispatcher("/WEB-INF/views/collab/editer.jsp").forward(request, response);

		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nom");

		String prenom = request.getParameter("prenom");
		
		String adresse = request.getParameter("adresse");

		String dateNaissanceBefore = request.getParameter("datedenaissance");
		LocalDate dateNaissance = LocalDate.parse(dateNaissanceBefore);
		
		String numsecu = request.getParameter("numsecu");
		
		
		if (nom == null) {
			response.setStatus(400);

			response.getWriter().write("<h1>Errur, Parametres incorrects ! Un nom est attendu</h1>");
		}
		
		if (prenom == null) {
			response.setStatus(400);

			response.getWriter().write("<h1>Errur, Parametres incorrects ! Un prenom est attendu</h1>");
		}

		int status = response.getStatus();
		
		if(status != 400)
		 {
			response.setStatus(201);
			response.sendRedirect(request.getContextPath() + "/collaborateurs/lister");
			
			//collabService.find();
			
		}
		
		//doGet(request, response);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.sendRedirect(request.getContextPath() + "/collaborateurs/lister");
		
	}

}
