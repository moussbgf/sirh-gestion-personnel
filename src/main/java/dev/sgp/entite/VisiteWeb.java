package dev.sgp.entite;

import java.util.UUID;

public class VisiteWeb {
	
	private Integer id;
	private String chemin;
	private Integer tempsExecution;
	
	static int idGenerator = 0;
	
	public VisiteWeb() {
		super();
		
		this.id = idGenerator++;
	
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getChemin() {
		return chemin;
	}
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	public Integer getTempsExecution() {
		return tempsExecution;
	}
	public void setTempsExecution(Integer tempsExecution) {
		this.tempsExecution = tempsExecution;
	}
	
}