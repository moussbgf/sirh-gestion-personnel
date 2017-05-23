package dev.sgp.util;

import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.service.VisitesWebService;

public interface Constantes {
	CollaborateurService COLLAB_SERVICE = new CollaborateurService();
	DepartementService DEPT_SERVICE = new DepartementService();
	VisitesWebService VISITE_SERVICE = new VisitesWebService();
}
