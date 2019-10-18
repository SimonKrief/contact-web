package fr.gtm.contacts_web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.contacts_web.entities.Contact;
import fr.gtm.contacts_web.services.ContactServices;

/**
 * Servlet implementation class ModifyContactServlet
 */
@WebServlet("/ModifyContactServlet")
public class ModifyContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	response.getWriter().append("Served at: ").append(request.getContextPath());
	ContactServices service = (ContactServices) getServletContext().getAttribute(Constantes.CONTACT_SERVICE);
	long id = Long.valueOf(request.getParameter("id"));
	Contact contact= service.getContactById(id);
	request.setAttribute("contact", contact);
	String page;
	page = "/edit-contact.jsp";
	RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
	rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
