package dev.sgp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListerCollaborateursController
 */
@WebServlet("/ListerCollaborateursController")
public class ListerCollaborateursController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		// TODO Auto-generated method stub

		response.getWriter().write("Salut ListerCollaborateursController !");

		// récupère la valeur d'un paramètre dont le nom est avecPhoto

		String avecPhotoParam = request.getParameter("avecPhoto");

		// récupère la valeur d'un paramètre dont le nom est departement

		String departementParam = request.getParameter("departement");

		response.setContentType("text/html");

		// code HTML écrit dans le corps de la réponse

		response.getWriter().write("<h1>Liste des collaborateurs</h1>"

				+ "<ul>"

				+ "<li>avecPhoto=" + avecPhotoParam + "</li>"

				+ "<li>departement=" + departementParam + "</li>"

				+ "</ul>");

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
		doGet(request, response);
	}

}
