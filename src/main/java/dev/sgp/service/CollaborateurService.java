package dev.sgp.service;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;

@Stateless
public class CollaborateurService {

	@Inject
	Event<CollabEvt> collabEvt;

	@PersistenceContext(unitName = "sgp-pu")
	private EntityManager em;

	// List<Collaborateur> listeCollaborateurs = new ArrayList<>();

	public CollaborateurService() {
		super();
	}

	public List<Collaborateur> listerCollaborateurs() {

		return em.createQuery("select c from Collaborateur c", Collaborateur.class).getResultList();

	}

	public Collaborateur find(String matricule) {

		// List<Collaborateur> result = listeCollaborateurs.stream()
		// .filter(item -> item.getMatricule().equals(matricule))
		// .collect(Collectors.toList());

		return em.find(Collaborateur.class, matricule);

	}

	public List<Collaborateur> findByDpt(Integer departementId) {

		// List<Collaborateur> result = listeCollaborateurs.stream()
		// .filter(item -> item.getMatricule().equals(matricule))
		// .collect(Collectors.toList());

		TypedQuery<Collaborateur> q = em.createQuery("select c from Collaborateur c where c.departement.id = :idDpt ",
				Collaborateur.class);

		q.setParameter("idDpt", departementId);

		return q.getResultList();

	}

	public void sauvegarderCollaborateur(Collaborateur collab) {

		// listeCollaborateurs.add(collab);

		CollabEvt nouveauCollabEvt = new CollabEvt();

		nouveauCollabEvt.setMatricule(collab.getMatricule());
		nouveauCollabEvt.setDateHeure(collab.getDateHeureCreation());
		nouveauCollabEvt.setType(TypeCollabEvt.CREATION_COLLAB);

		em.persist(collab);

		collabEvt.fire(nouveauCollabEvt);

	}

	public void modifierCollaborateur(String matricule, Collaborateur collab) {

		// listeCollaborateurs.add(collab);

		Collaborateur collaborateur = find(matricule);

		if (collaborateur != null) {

			CollabEvt nouveauCollabEvt = new CollabEvt();

			nouveauCollabEvt.setMatricule(collab.getMatricule());
			nouveauCollabEvt.setDateHeure(collab.getDateHeureCreation());
			nouveauCollabEvt.setType(TypeCollabEvt.MODIFICATION_COLLAB);

			collaborateur.setEmailPro(collab.getEmailPro());

			collabEvt.fire(nouveauCollabEvt);
		}

	}

	public void modifierCollaborateurBanque(String matricule, Map<String, String> banqueWrap) {

		Collaborateur collaborateur = find(matricule);

		if (collaborateur != null) {
			
			collaborateur.setBanque(banqueWrap.get("Banque"));
			collaborateur.setBic(banqueWrap.get("Bic"));
			collaborateur.setIban(banqueWrap.get("Iban"));

		}

	}

}
