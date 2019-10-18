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

import fr.gtm.contacts_web.entities.Civilite;
import fr.gtm.contacts_web.entities.Contact;
import fr.gtm.contacts_web.services.ContactServices;


@WebServlet("/CreerContactServlet")
public class CreerContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactServices service=(ContactServices) getServletContext().getAttribute(Constantes.CONTACT_SERVICE);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Writer out =response.getWriter();
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		Civilite civilite= Civilite.valueOf(request.getParameter("civilite"));
		Contact contact=new Contact(civilite, nom, prenom);
		service.addContact(contact);
		String message="Félicitations, le contact a été créé";
		request.setAttribute("message", message);
		String page;
		page="/index.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
