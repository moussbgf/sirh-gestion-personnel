package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import static java.util.stream.Collectors.*;
import dev.sgp.entite.VisiteLog;
import dev.sgp.entite.VisiteWeb;

public class VisitesWebService {
	
	List<VisiteWeb> listeVisites = new ArrayList<>();
	
	public VisitesWebService() {
		super();
		
		//this.listeDepartements = listeDepartements;
	}
	
	public List<VisiteWeb> listerVisites() {
		
		return listeVisites;

	}
	
	public void ajouterVisite(VisiteWeb visite) {
		listeVisites.add(visite);
	}
	
	public List<VisiteLog> construireStatistiques() {
		List<VisiteLog> listVisitesLog = new ArrayList<>();
		
		Map<String, List<VisiteWeb>> cheminListeVisites = listeVisites.stream().collect(groupingBy(VisiteWeb::getChemin));
		
		cheminListeVisites.forEach((chemin, listeVisites) -> {
			listVisitesLog.add(construireVisiteLog(chemin, listeVisites));
		});
		
		return listVisitesLog;
	}
	
	
	public VisiteLog construireVisiteLog(String chemin, List<VisiteWeb> listeVisites) {
		LongSummaryStatistics stats = listeVisites.stream().collect(
				summarizingLong(VisiteWeb::getTempsExecution));
		return new VisiteLog(chemin, stats.getCount(), stats.getMin(), stats.getMax(), stats.getAverage());
	}
	
}
