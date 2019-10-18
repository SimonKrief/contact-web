package fr.gtm.contacts_web.servlets;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.contacts_web.services.ContactServices;
import fr.gtm.contacts_web.dao.ContactDAO;
import fr.gtm.contacts_web.entities.Contact;
import fr.gtm.contacts_web.services.ContactServices;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactServices service=(ContactServices) getServletContext().getAttribute(Constantes.CONTACT_SERVICE);
		Writer out =response.getWriter();
		String cp=request.getParameter("cp");
		String page;
		List<Contact> contacts=service.getContacts();
		request.setAttribute("contacts", contacts);
		page="/show-contacts.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
		
//		suppression contact
//		Contact contact=new Contact();
//		contact=contact.getId()
//		String id=request.getParameter("id");
//		service.deleteContact(contact);

		
	}
}
