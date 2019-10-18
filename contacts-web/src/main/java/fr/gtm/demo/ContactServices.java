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
	
	public void deleteContactById(String id) {
		dao.deleteContactById(id);
		
	}
	
//	public void deleteContact(Contact contact) {
//		dao.delete(contact);
//	}
	
	public void create(Contact contact) {
		dao.create(contact);
	}
	

	
//	public void updateContactById(String id) {
//		dao.updateContactById(id);
//	}
	
	public Contact getContactById(String id) {
		long identifiant = Long.parseLong(id);
		return dao.getContactById(identifiant);
	}
	
	public void update(Contact contact) {
	dao.update(contact);
}
	
	
}
