package fr.gtm.contacts_web.servlets;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.contacts_web.entities.Contact;
import fr.gtm.contacts_web.services.ContactServices;

/**
 * Servlet implementation class AjouterImageServlet
 */
@WebServlet("/AjouterImageServlet")
public class AjouterImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactServices service=(ContactServices) getServletContext().getAttribute(Constantes.CONTACT_SERVICE);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Writer out =response.getWriter();

		long contactID=Long.valueOf(request.getParameter("id"));
		Contact contact=service.getContactById(contactID);

		String image = request.getParameter("image");
		contact.setImage(image);
		service.modifyContact(contact);

		String message="Félicitations, l'image a été ajoutée";
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
