package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.TypeCollabEvt;

@ApplicationScoped
public class ActiviteService {
	
	@Inject
	public ActiviteService() {
		super();
		// TODO Auto-generated constructor stub
	}


	List<CollabEvt> listActivite = new ArrayList<CollabEvt>();
	
	public void recevoirEvenementCollab(@Observes CollabEvt evt) {
		
		if(evt.getType() == TypeCollabEvt.CREATION_COLLAB) {
			listActivite.add(evt);
		}
		
	}
	
	
	public List<CollabEvt> listerActivitesCollab() {
		
		return listActivite;

	}
}
