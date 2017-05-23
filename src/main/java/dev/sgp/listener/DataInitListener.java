package dev.sgp.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dev.sgp.entite.Departement;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;


@WebListener
public class DataInitListener implements HttpSessionListener {
	
	private DepartementService dptService = Constantes.DEPT_SERVICE;
	
    public DataInitListener() {
    	
    }


    public void sessionCreated(HttpSessionEvent event)  { 
//    	Integer compteur = (Integer) event.getSession().getServletContext().getAttribute("compteur");
//
//    	event.getSession().getServletContext().setAttribute("compteur", compteur + 1);
//
//    	System.out.println("Nombre de sessions ouvertes = " + (compteur + 1));
    	

    	
    	Departement dpt1 = new Departement();
		Departement dpt2 = new Departement();
		Departement dpt3 = new Departement();
		Departement dpt4 = new Departement();
		
		dpt1.setId(1);
		dpt1.setNom("Comptabilité");
		
		dpt2.setId(2);
		dpt2.setNom("Ressources Humaines");
		
		dpt3.setId(3);
		dpt3.setNom("Informatique");
		
		dpt4.setId(4);
		dpt4.setNom("Administratif");
		
		dptService.ajouterDepartements(dpt1);
		dptService.ajouterDepartements(dpt2);
		dptService.ajouterDepartements(dpt3);
		dptService.ajouterDepartements(dpt4);
    	
    }


    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	
    }
	
}
