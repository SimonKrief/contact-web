package fr.gtm.contacts_web.servlets;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.jboss.logging.Logger;

import fr.gtm.contacts_web.services.ContactServices;

@WebListener
public class ApplicationListener implements ServletContextListener {
	private static final Logger LOG = Logger.getLogger("contacts");

	public void contextDestroyed(ServletContextEvent sce) {
		EntityManagerFactory emf = (EntityManagerFactory) sce.getServletContext().getAttribute(Constantes.EMF);
		emf.close();
		LOG.info(">>> EMF closed");
		LOG.info(">>> application retirée");
	}

	public void contextInitialized(ServletContextEvent sce) {
		LOG.info(">>> application anihilée");
		// le "contacts" doit être le nom ds le persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contacts");
		LOG.info(">>>EMF: " + emf);
		// récupère le contexte de l'application (toutes les servlets)
		ServletContext application = sce.getServletContext();
		application.setAttribute(Constantes.EMF, emf);
		ContactServices service = new ContactServices(emf);
		LOG.info(">>> service: " + service);
		application.setAttribute(Constantes.CONTACT_SERVICE, service);

	}

}
