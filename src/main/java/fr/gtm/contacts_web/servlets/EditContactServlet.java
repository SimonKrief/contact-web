package fr.gtm.contacts_web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.contacts_web.entities.Civilite;
import fr.gtm.contacts_web.entities.Contact;
import fr.gtm.contacts_web.services.ContactServices;

/**
 * Servlet implementation class EditContactServlet
 */
@WebServlet("/EditContactServlet")
public class EditContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactServices service = (ContactServices) getServletContext().getAttribute(Constantes.CONTACT_SERVICE);
		//Contact contact=request.getParameter("contact");
		String newNom=request.getParameter("nom");
		String newPrenom=request.getParameter("prenom");
		Civilite civilite= Civilite.valueOf(request.getParameter("civilite"));		
		long id = Long.parseLong(request.getParameter("id"));
		Contact contact=service.getContactById(id);
		
		contact.setNom(newNom);
		contact.setPrenom(newPrenom);
		contact.setCivilite(civilite);
		service.modifyContact(contact);
		String message="Félicitations, le contact a été modifié";
		request.setAttribute("message", message);
		String page;
		page="/index.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(page);
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
