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
	}


	List<CollabEvt> listActivite = new ArrayList<CollabEvt>();
	
	public void recevoirEvenementCollab(@Observes CollabEvt evt) {
			listActivite.add(evt);
		
		
	}
	
	
	public List<CollabEvt> listerActivitesCollab() {
		
		return listActivite;

	}
}
