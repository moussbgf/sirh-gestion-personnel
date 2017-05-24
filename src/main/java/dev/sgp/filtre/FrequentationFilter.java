package dev.sgp.filtre;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisitesWebService;


@WebFilter("/*")
public class FrequentationFilter implements Filter {
	
	@Inject private VisitesWebService visiteService;
	
    public FrequentationFilter() {
    	
    }


	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// place your code here
		VisiteWeb visite = new VisiteWeb();
		
		String path = ((HttpServletRequest) request).getRequestURI();
		
		long before = System.currentTimeMillis();
		// pass the request along the filter chain
		chain.doFilter(request, response);
		long after = System.currentTimeMillis();
		
		
		Integer tempsExecution = (int) (after - before);
		
		visite.setChemin(path);
		visite.setTempsExecution(tempsExecution);
		
		visiteService.ajouterVisite(visite);
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
