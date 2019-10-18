package fr.gtm.contacts_web.servlets;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.contacts_web.entities.Adresse;
import fr.gtm.contacts_web.entities.Contact;
import fr.gtm.contacts_web.services.ContactServices;


@WebServlet("/ShowAdressesServlet")
public class ShowAdressesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactServices service=(ContactServices) getServletContext().getAttribute(Constantes.CONTACT_SERVICE);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Writer out =response.getWriter();
		long contactID=Long.valueOf(request.getParameter("id"));
		String page;
		//List<Adresse> adresses=service.getAdresses(service.getContactById(id));
		Contact contact=service.getContactById(contactID);
		List<Adresse> adresses=contact.getAdresses();
		request.setAttribute("adresses", adresses);
		request.setAttribute("contactID", contactID);
		page="/show-adresses.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
