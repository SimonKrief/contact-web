package fr.gtm.demo;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import fr.gtm.demo.dao.ContactDAO;



public class ContactServices {
	private ContactDAO dao;

	public ContactServices(EntityManagerFactory emf) {
		dao= new ContactDAO(emf);
	}
	
	public List<String> getAllContacts(){
		return dao.getAllContacts();
	}

}
