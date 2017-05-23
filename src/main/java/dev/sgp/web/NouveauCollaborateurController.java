package dev.sgp.web;

import java.io.IOException;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

/**
 * Servlet implementation class NouveauCollaborateurController
 */
// @WebServlet("/NouveauCollaborateurController")
public class NouveauCollaborateurController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	public NouveauCollaborateurController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("erreur", 0);
		
		request.getRequestDispatcher("/WEB-INF/views/collab/nouveau.jsp").forward(request, response);
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Collaborateur collab = new Collaborateur();
		
		request.setAttribute("erreur", 0);

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String dateNaissanceBefore = request.getParameter("datedenaissance");
		LocalDate dateNaissance = LocalDate.parse(dateNaissanceBefore);
		String numsecu = request.getParameter("numsecu");
		
		
		/* fichier application.properties dans /resources */
		ResourceBundle bundle = ResourceBundle.getBundle("application");

		String suffixe = bundle.getString("suffixe.email");
		

		String matricule = UUID.randomUUID().toString();
		String emailPro = prenom + "." + nom + suffixe;
		ZonedDateTime dateHeureCreation = ZonedDateTime.now();

		collab.setMatricule(matricule);
		collab.setNom(nom);
		collab.setPrenom(prenom);
		collab.setDateDeNaissance(dateNaissance);
		collab.setAdresse(adresse);
		collab.setNumSecu(numsecu);
		collab.setEmailPro(emailPro);
		collab.setActif(true);
		collab.setDateHeureCreation(dateHeureCreation);
		
		Map<Boolean, List<String>> validationParams = validerParametres(request, "nom","prenom", "adresse", "numsecu");

		if (validationParams.get(false) != null || numsecu.length() < 15) {
			response.setStatus(400);
			
			request.setAttribute("erreur", 1);
			
			//response.getWriter().append("<p class=\"alert alert-danger\">Les champs suivants sont manquants : " + validationParams.get(false).stream().collect(Collectors.joining(",")) + " </p>");
			
			String errorMessage = "";
			
			if (validationParams.get(false) != null) {
				errorMessage = "Les champs suivants sont menquants : " + validationParams.get(false).stream().collect(Collectors.joining(","));
			}
			
			if(numsecu.length() < 15) {
				errorMessage += " Et numero de sécu incorrect (15 charac) !";
			}
			
			request.setAttribute("errorMessage", errorMessage);
			
			request.getRequestDispatcher("/WEB-INF/views/collab/nouveau.jsp")
			.forward(request, response);
		} else {
			response.setStatus(201);
			
			response.getWriter().write("Création d'un collaborateur avec les informations suivantes : " 
				+ validationParams.get(true).stream().map(p -> p + "=" + request.getParameter(p)).collect(Collectors.joining(",")));
		
			collabService.sauvegarderCollaborateur(collab);
			
			response.sendRedirect(request.getContextPath() + "/collaborateurs/lister");
		}
		
		
		
		
		
		

		// doGet(request, response);
	}

	private Map<Boolean, List<String>> validerParametres(HttpServletRequest req, String... params) {
		return Stream.of(params)
				.collect(Collectors.groupingBy(param -> req.getParameter(param) != null && !"".equals(req.getParameter(param))));
	}

}
