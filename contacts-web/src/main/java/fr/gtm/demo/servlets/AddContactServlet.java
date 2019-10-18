package fr.gtm.demo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.demo.entities.Civilite;
import fr.gtm.demo.entities.Contact;
import fr.gtm.demo.ContactServices;

/**
 * Servlet implementation class AjouterContactServlet
 */
@WebServlet("/AjouterContactServlet")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ContactServices service = (ContactServices) getServletContext().getAttribute(Constantes.CONTACT_SERVICE);
		String page ="";
		String civilite = request.getParameter("civilite");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		
		if(civilite==null || civilite.isEmpty() || nom==null || nom.isEmpty() || prenom==null || prenom.isEmpty()) {
			page = "/ContactServlet";
		} else {
			Contact contact = new Contact();
			contact.setCivilite(Civilite.valueOf(civilite));
			contact.setNom(nom);
			contact.setPrenom(prenom);
			service.create(contact);
			page = "/ContactServlet";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}