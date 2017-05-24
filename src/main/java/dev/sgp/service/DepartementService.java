package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dev.sgp.entite.Departement;

@ApplicationScoped
public class DepartementService {
	
	List<Departement> listeDepartements = new ArrayList<>();
	
	@Inject
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
