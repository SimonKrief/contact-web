package fr.gtm.demo;

import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.gtm.demo.servlets.Constantes;



@WebListener
public class ApplicationListener implements ServletContextListener {
	private static final Logger LOG =Logger.getLogger("contacts");

    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	EntityManagerFactory emf = (EntityManagerFactory) sce.getServletContext().getAttribute(Constantes.EMF);
    	emf.close();
    	LOG.info(">>> EMF fermé");
    	LOG.info(">>> Application détruite");

    }
    @Override
    public void contextInitialized(ServletContextEvent sce)  { 
    	LOG.info(">>> application demarée");
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contacts");
    	LOG.info(">>> EMF" +emf);
    	ServletContext  application = sce.getServletContext();
    	application.setAttribute(Constantes.EMF, emf);
    	ContactServices service = new ContactServices(emf);
    	LOG.info(">>> service"+service);
    	application.setAttribute(Constantes.CONTACT_SERVICE, service);

    	
    }
	
}
