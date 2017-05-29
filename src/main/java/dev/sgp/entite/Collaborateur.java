package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

@Entity
public class Collaborateur {
	
	public Collaborateur() {
		super();
		
		this.actif = true;
		this.photo = "urls de l'image";
		
	}
	
	
	
	public Collaborateur(String matricule, String nom, String prenom, LocalDate dateDeNaissance, String adresse,
			String numSecu, String emailPro, String photo, ZonedDateTime dateHeureCreation, boolean actif, Departement departement, String banque, String bic, String iban ) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		DateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.numSecu = numSecu;
		this.emailPro = emailPro;
		this.photo = photo;
		this.dateHeureCreation = dateHeureCreation;
		this.actif = actif;
		this.departement = departement;
		this.banque = banque;
		this.bic = bic;
		this.iban = iban;
	}



	@Id
	private String matricule;
	
	private String nom;
	
	private String prenom;
	
	private LocalDate DateDeNaissance;
	
	private String adresse;
	
	private String numSecu;
	
	private String emailPro;
	
	private String photo;
	
	private ZonedDateTime dateHeureCreation;
	
	private boolean actif;
	
	private String intitulePoste;
	
	@ManyToOne
	private Departement departement;
	
	
	private String banque;
	
	private String bic;
	
	private String iban;
	
	
	
	
	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}



	public String getBic() {
		return bic;
	}



	public void setBic(String bic) {
		this.bic = bic;
	}



	public String getIban() {
		return iban;
	}



	public void setIban(String iban) {
		this.iban = iban;
	}



	public String getIntitulePoste() {
		return intitulePoste;
	}

	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateDeNaissance() {
		return DateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		DateDeNaissance = dateDeNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumSecu() {
		return numSecu;
	}

	public void setNumSecu(String numSecu) {
		this.numSecu = numSecu;
	}

	public String getEmailPro() {
		return emailPro;
	}

	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}
	
	public String getFormattedDateHeure() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        return this.dateHeureCreation.format(format);
        
    }
	
	
}
