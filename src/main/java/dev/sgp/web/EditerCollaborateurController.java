package dev.sgp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/collaborateurs/editer")
public class EditerCollaborateurController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditerCollaborateurController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		response.getWriter().write("<h1>Hello EditerCollaborateurController</h1>");

		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String matricule = request.getParameter("matricule");

		String titre = request.getParameter("titre");

		String nom = request.getParameter("nom");

		String prenom = request.getParameter("prenom");

		response.setContentType("text/html");
		
		
		
		if (matricule == null) {
			response.setStatus(400);

			response.getWriter().write("<h1>Errur, Parametres incorrects ! Un matricule est attendu</h1>");
		}
		
		if (titre == null) {
			response.setStatus(400);

			response.getWriter().write("<h1>Errur, Parametres incorrects ! Un titre est attendu</h1>");
		}
		
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
			response.getWriter().write("<h1>Edition de collaborateur</h1>"
					+ "<h2>Creation d'un collaborateur avec les infos suivantes : </h2><br>"
					+ "<p>" 
					+ "Matricule : " + matricule + "<br>\n" 
					+ "titre : " + titre + "<br>\n"
					+ "nom : " + nom + "<br>\n"
					+ "prenom : " + prenom + "<br>\n"
					+ "</p>");
		}
		
		//doGet(request, response);
	}

}
