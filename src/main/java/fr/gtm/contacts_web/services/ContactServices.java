package fr.gtm.contacts_web.services;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import fr.gtm.contacts_web.dao.ContactDAO;
import fr.gtm.contacts_web.entities.Adresse;
import fr.gtm.contacts_web.entities.Contact;

public class ContactServices {
private ContactDAO dao;

public ContactServices(EntityManagerFactory emf) {
	dao=new ContactDAO(emf);
}

public List<Contact> getContacts(){
	return dao.getContacts();
}

public Contact getContactById(long id) {
	return dao.getContactById(id);
}

public Adresse getAdresseById(long id) {
	return dao.getAdresseById(id);
}

public void deleteContact(long id) {
	Contact contact =dao.getContactById(id);
	dao.delete(contact);
}

public void addContact(Contact contact){
	dao.create(contact);
}
public void modifyContact(Contact contact) {
	dao.update(contact);
}
public List<Adresse> getAdresses(Contact contact){
	return dao.getContactAdresses(contact);
}

public void addAdresse(Contact contact, Adresse adresse) {
	dao.addContactAdresse(contact, adresse);
	dao.update(contact);
}

public void deleteAdresse(Contact contact, Adresse adresse) {
	dao.deleteContactAdresse(contact, adresse);
	dao.update(contact);
}

}
