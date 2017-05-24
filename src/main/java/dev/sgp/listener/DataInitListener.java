package dev.sgp.listener;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;


@WebListener
public class DataInitListener implements ServletContextListener {
	
	@Inject private DepartementService dptService;
	
	@Inject private CollaborateurService collabService;
	
    public DataInitListener() {
    	
    }

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
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
		
		/*
		 * Initialiser liste des collaborateurs ICI :
		 */
        ZonedDateTime dateHeureCreation = ZonedDateTime.now();
        
        
        
        
        
        
        Stream.of( new Collaborateur("1", "ee", "ss", LocalDate.parse("1993-06-25"), "14", "121212121212121", "ee.ss@societe.com","img.png" ,dateHeureCreation , true, dpt1),
                new Collaborateur("2", "est", "rr", LocalDate.parse("1993-06-25"), "14", "121212121212121", "ee.ss@societe.com","img.png" ,dateHeureCreation , true, dpt2),
                new Collaborateur("3", "pmp", "cdr", LocalDate.parse("1993-06-25"), "14", "121212121212121", "ee.ss@societe.com","img.png" ,dateHeureCreation , true, dpt3),
                new Collaborateur("4", "sar", "vif", LocalDate.parse("1993-06-25"), "14", "121212121212121", "ee.ss@societe.com","img.png" ,dateHeureCreation , true, dpt4),
                new Collaborateur("5", "pop", "youpi", LocalDate.parse("1993-06-25"), "14", "121212121212121", "ee.ss@societe.com","img.png" ,dateHeureCreation , true, dpt1)
                
        ).forEach(collab -> collabService.sauvegarderCollaborateur(collab));
     
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
}
