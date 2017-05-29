package dev.sgp.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.sun.mail.imap.protocol.Status;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;

@Path("/collaborateurs")
public class CollaborateursResource {

	@EJB
	private CollaborateurService collabService;

	// @GET
	// @Produces(MediaType.APPLICATION_JSON)
	// public List<Collaborateur> list() {
	//
	// List<Collaborateur> collaborateurs =
	// collabService.listerCollaborateurs();
	//
	// return collaborateurs;
	// }

	@GET
	@Path("/{matricule}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur findByMatricule(@PathParam("matricule") String matricule) {

		Collaborateur collaborateur = collabService.find(matricule);

		return collaborateur;
	}

	@GET
	@Path("/{matricule}/banque")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> findByMatriculeBanque(@PathParam("matricule") String matricule) {

		Collaborateur collaborateur = collabService.find(matricule);

		Map<String, String> banqueWrap = new HashMap<>();

		banqueWrap.put("Banque", collaborateur.getBanque());
		banqueWrap.put("Bic", collaborateur.getBic());
		banqueWrap.put("Iban", collaborateur.getIban());

		return banqueWrap;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public List<Collaborateur> list(@QueryParam("departement") @DefaultValue("0") Integer departementId) {

		List<Collaborateur> collaborateurs;

		if (departementId != 0) {
			collaborateurs = collabService.findByDpt(departementId);
		} else {
			collaborateurs = collabService.listerCollaborateurs();
		}
		return collaborateurs;
	}

	@PUT
	@Path("/{matricule}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void modify(Collaborateur newCollab, @PathParam("matricule") String matricule) {

		collabService.modifierCollaborateur(matricule, newCollab);

	}

	@PUT
	@Path("/{matricule}/banque")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response modifyBanque(Map<String, String> banqueWrap, @PathParam("matricule") String matricule) {
		
		//Serie de tests à deplacer vers le service 
		
		List<String> menquant = new ArrayList<String>();
		
		ResponseBuilder builder;

		if (banqueWrap.get("Banque") == null || banqueWrap.get("Banque").isEmpty() ) {
			menquant.add("Banque");
		}

		if ((banqueWrap.get("Bic") == null || banqueWrap.get("Bic").isEmpty()) ) {
			menquant.add("Bic");
		}

		if ((banqueWrap.get("Iban") == null || banqueWrap.get("Iban").isEmpty())) {
			menquant.add("Iban");
		}
		
		
		if(menquant.size() == 0) {
			collabService.modifierCollaborateurBanque(matricule, banqueWrap);
			builder = Response.ok("texte");

			builder.language("fr")

			.header("Content-type", "text/html");

			return builder.build();
			
		} else {
			
			builder = Response.status(Response.Status.EXPECTATION_FAILED);
			
			
			builder.language("fr")

			
			
			.entity("champs menquant : " + menquant)
			
			;

			return builder.build();
		}



	}

}
