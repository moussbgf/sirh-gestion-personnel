package dev.sgp.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;

@Stateless
public class CollaborateurService {
	
	@Inject Event<CollabEvt> collabEvt;
	
	@PersistenceContext(unitName="sgp-pu") private EntityManager em;
	
	//List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	
	public CollaborateurService() {
		super();
	}

	public List<Collaborateur> listerCollaborateurs() {
		
		return em.createQuery("select c from Collaborateur c", Collaborateur.class).getResultList();

	}

	public void sauvegarderCollaborateur(Collaborateur collab) {

		//listeCollaborateurs.add(collab);
		
		CollabEvt nouveauCollabEvt = new CollabEvt();
		
		nouveauCollabEvt.setMatricule(collab.getMatricule());
		nouveauCollabEvt.setDateHeure(collab.getDateHeureCreation());
		nouveauCollabEvt.setType(TypeCollabEvt.CREATION_COLLAB);
		
		em.persist(collab);
		
		collabEvt.fire(nouveauCollabEvt);

	}
	
	public Collaborateur find(String matricule) {

//		List<Collaborateur> result = listeCollaborateurs.stream()
//			     .filter(item -> item.getMatricule().equals(matricule))
//			     .collect(Collectors.toList());
		
		
		return em.find(Collaborateur.class, matricule);
		
	}
}
