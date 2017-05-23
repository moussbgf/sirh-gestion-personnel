package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.sgp.entite.Collaborateur;


public class CollaborateurService {
	
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();

	public List<Collaborateur> listerCollaborateurs() {

		return listeCollaborateurs;

	}

	public void sauvegarderCollaborateur(Collaborateur collab) {

		listeCollaborateurs.add(collab);

	}
	
	public Collaborateur find(String matricule) {

		List<Collaborateur> result = listeCollaborateurs.stream()
			     .filter(item -> item.getMatricule().equals(matricule))
			     .collect(Collectors.toList());
		
		return result.get(0);
		
	}
}
