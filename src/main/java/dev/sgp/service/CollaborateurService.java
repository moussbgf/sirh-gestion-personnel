package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;

@ApplicationScoped
public class CollaborateurService {
	
	@Inject Event<CollabEvt> collabEvt;
	
	
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	
	public CollaborateurService() {
		super();
	}

	public List<Collaborateur> listerCollaborateurs() {

		return listeCollaborateurs;

	}

	public void sauvegarderCollaborateur(Collaborateur collab) {

		listeCollaborateurs.add(collab);
		
		CollabEvt nouveauCollabEvt = new CollabEvt();
		
		nouveauCollabEvt.setMatricule(collab.getMatricule());
		nouveauCollabEvt.setDateHeure(collab.getDateHeureCreation());
		nouveauCollabEvt.setType(TypeCollabEvt.CREATION_COLLAB);
		
		
		collabEvt.fire(nouveauCollabEvt);

	}
	
	public Collaborateur find(String matricule) {

		List<Collaborateur> result = listeCollaborateurs.stream()
			     .filter(item -> item.getMatricule().equals(matricule))
			     .collect(Collectors.toList());
		
		return result.get(0);
		
	}
}
