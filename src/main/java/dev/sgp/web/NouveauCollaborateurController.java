package dev.sgp.web;

import java.io.IOException;
import java.util.UUID;
import java.time.LocalDate;
import java.util.List;
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
//@WebServlet("/NouveauCollaborateurController")
public class NouveauCollaborateurController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
       

    public NouveauCollaborateurController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/collab/nouveau.jsp")
		.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UUID id = UUID.randomUUID();
		
		Collaborateur collab = new Collaborateur();
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String dateNaissanceBefore = request.getParameter("datedenaissance");
		
		LocalDate dateNaissance = LocalDate.parse(dateNaissanceBefore);
		
		
		String adresse = request.getParameter("adresse");
		String numsecu = request.getParameter("numsecu");
		
		String emailPro = prenom + "." + nom + "@societe.com" ;
		
		collab.setNom(nom);
		collab.setPrenom(prenom);
		collab.setDateDeNaissance(dateNaissance);
		collab.setNumSecu(numsecu);
		
		collab.setAdresse(adresse);
		
		//collaborateurs.add(collab);
		
		collabService.sauvegarderCollaborateur(collab);
		
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();

		request.setAttribute("collaborateurs", collaborateurs);
		
		
		response.sendRedirect(request.getContextPath() + "/collaborateurs/lister");
		
		doGet(request, response);
	}

}
