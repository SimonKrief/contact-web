package fr.gtm.contacts_web.services;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import fr.gtm.contacts_web.dao.ContactDAO;
import fr.gtm.contacts_web.entities.Contact;

public class AdresseService {
	private ContactDAO dao;

	public AdresseService(EntityManagerFactory emf) {
		dao=new ContactDAO(emf);
	}

//	public List<Adresse> getAdresses(){
//		return dao.getAdresses();
//	}
}
