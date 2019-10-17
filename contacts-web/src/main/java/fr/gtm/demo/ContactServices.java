package fr.gtm.demo;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import fr.gtm.demo.dao.ContactDAO;
import fr.gtm.demo.entities.Contact;



public class ContactServices {
	private ContactDAO dao;

	public ContactServices(EntityManagerFactory emf) {
		dao= new ContactDAO(emf);
	}
	
	public List<Contact> getAllContacts(){
		return dao.getAllContacts();
	}

}
