package dev.sgp.service;


import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dev.sgp.entite.Departement;

@Stateless
public class DepartementService {
	
	//List<Departement> listeDepartements = new ArrayList<>();
	
	@PersistenceContext(unitName="sgp-pu") private EntityManager em;
	
	@Inject
	public DepartementService() {
		super();
		
		//this.listeDepartements = listeDepartements;
	}
	
	public List<Departement> listerDepartements() {
		
		
		
		return em.createQuery("select c from Departement c", Departement.class).getResultList();

	}
	
	public void ajouterDepartements(Departement dept) {

		em.persist(dept);
		
	}
	
}
