package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;
import dev.sgp.entite.Departement;

public class DepartementService {
	
	List<Departement> listeDepartements = new ArrayList<>();
	
	public DepartementService() {
		super();
		
		//this.listeDepartements = listeDepartements;
	}
	
	public List<Departement> listerDepartements() {
		
		return listeDepartements;

	}
	
	public void ajouterDepartements(Departement dept) {
		
		listeDepartements.add(dept);
		
	}
	
}
