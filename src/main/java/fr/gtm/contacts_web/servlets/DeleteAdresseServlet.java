package fr.gtm.contacts_web.servlets;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.contacts_web.entities.Adresse;
import fr.gtm.contacts_web.entities.Contact;
import fr.gtm.contacts_web.services.ContactServices;

/**
 * Servlet implementation class DeleteAdresseServlet
 */
@WebServlet("/DeleteAdresseServlet")
public class DeleteAdresseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactServices service=(ContactServices) getServletContext().getAttribute(Constantes.CONTACT_SERVICE);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Writer out =response.getWriter();
		long contactID=Long.valueOf(request.getParameter("contactID"));
		long adresseID=Long.valueOf(request.getParameter("id"));
		Contact contact=service.getContactById(contactID);
		Adresse adresse=service.getAdresseById(adresseID);
		service.deleteAdresse(contact, adresse);
		String message="Félicitations, l'adresse a été supprimée de la liste d'adresse de "+contact.getPrenom()+" "+contact.getNom();
		request.setAttribute("message", message);
		String page;
		page="/index.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
