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
import fr.gtm.contacts_web.entities.Civilite;
import fr.gtm.contacts_web.entities.Contact;
import fr.gtm.contacts_web.services.ContactServices;

/**
 * Servlet implementation class AjouterAdresseServlet
 */
@WebServlet("/AjouterAdresseServlet")
public class AjouterAdresseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterAdresseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactServices service=(ContactServices) getServletContext().getAttribute(Constantes.CONTACT_SERVICE);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Writer out =response.getWriter();
		long contactID=Long.valueOf(request.getParameter("contactID"));
		Contact contact=service.getContactById(contactID);
		String rue=request.getParameter("rue");
		String ville=request.getParameter("ville");
		String codePostal=request.getParameter("codePostal");
		String pays=request.getParameter("pays");
		Adresse adresse=new Adresse(rue, codePostal, ville, pays);
		service.addAdresse(contact, adresse);
		String message="Félicitations, l'adresse a été créé et ajoutée à la liste d'adresse de ce contact";
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
