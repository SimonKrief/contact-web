package fr.gtm.contacts_web.dao;


import javax.persistence.EntityManagerFactory;

import fr.gtm.contacts_web.entities.Adresse;

public class AdresseDAO extends AbstractDAO<Adresse, Long>{

	public AdresseDAO(EntityManagerFactory emf) {
		super(emf, Adresse.class);
	}

}
