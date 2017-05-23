package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;
import dev.sgp.entite.VisiteWeb;

public class VisitesWebService {
	
	List<VisiteWeb> listeVisites = new ArrayList<>();
	
	public VisitesWebService() {
		super();
		
		//this.listeDepartements = listeDepartements;
	}
	
	public List<VisiteWeb> listerDepartements() {
		
		return listeVisites;

	}
	
	public void ajouterVisite(VisiteWeb visite) {
		listeVisites.add(visite);
	}
	
}
