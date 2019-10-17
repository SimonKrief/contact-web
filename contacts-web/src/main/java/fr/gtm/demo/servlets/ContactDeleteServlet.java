package fr.gtm.demo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.demo.ContactServices;
import fr.gtm.demo.entities.Contact;

@WebServlet("/ContactDeleteServlet")
public class ContactDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ContactDeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ContactServices service = (ContactServices) getServletContext().getAttribute(Constantes.CONTACT_SERVICE);
//		String cp =request.getParameter("cp");

		String page = "";
 		String id = request.getParameter("id");  		
 		service.deleteContactById(id);
 		
		List<Contact> contacts = service.getAllContacts();
		request.setAttribute("contacts", contacts);
		page = "/show-contacts.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	
			throws ServletException, IOException {
		doGet(request, response);
	}

}
