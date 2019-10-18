package fr.gtm.contacts_web.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import fr.gtm.contacts_web.entities.Adresse;
import fr.gtm.contacts_web.entities.Civilite;
import fr.gtm.contacts_web.entities.Contact;

public class ContactDAO {
	private EntityManagerFactory emf;

	public ContactDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void create(Contact contact) {
		// 1 - récupèrer un EntityManager (connexion)
		EntityManager em = emf.createEntityManager();
		// 2 - démarrer une transaction
		em.getTransaction().begin();
		// 3 - sauvegarder l'entité en base
		em.persist(contact);
		// 4 - valider la transaction
		em.getTransaction().commit();
		// 5 - fermer l'Entitymanager (connexion)
		em.close();
	}

	public Contact getContactById(long id) {
		EntityManager em = emf.createEntityManager();
		Contact contact = em.find(Contact.class, id);
		em.close();
		return contact;
	}

	public Adresse getAdresseById(long id) {
		EntityManager em = emf.createEntityManager();
		Adresse adresse = em.find(Adresse.class, id);
		em.close();
		return adresse;
	}

	public void delete(Contact contact) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// on réattache l'entité avant de la supprimer
		Contact c1 = em.find(Contact.class, contact.getId());
		em.remove(c1);

		em.getTransaction().commit();
		em.close();
	}

	public void update(Contact contact) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(contact);
		em.getTransaction().commit();
		em.close();
	}

	public List<Contact> getContactsByCivilite(Civilite civilite) {
		String sql = "SELECT c FROM Contact c WHERE c.civilite= :foo";
		EntityManager em = emf.createEntityManager();
		List<Contact> contacts = em.createQuery(sql, Contact.class).setParameter("foo", civilite).getResultList();
		em.close();
		return contacts;
	}

	public List<Contact> getContactsByNom(String nom) {
		EntityManager em = emf.createEntityManager();
		List<Contact> contacts = em.createNamedQuery("Contact.getByNom", Contact.class).setParameter("nom", nom + "%")
				.getResultList();
		em.close();
		return contacts;
	}

	public List<Contact> getContactsWithHome() {
		EntityManager em = emf.createEntityManager();
		List<Contact> contacts = em.createNamedQuery("Contact.getByHasAdress", Contact.class).getResultList();
		em.close();
		return contacts;
	}

	public List<Contact> getContacts() {
		EntityManager em = emf.createEntityManager();
		List<Contact> contacts = em.createNamedQuery("Contact.getContacts", Contact.class).getResultList();
		em.close();
		return contacts;
	}

	public List<Adresse> getContactAdresses(Contact contact) {
		EntityManager em = emf.createEntityManager();
		List<Adresse> adresses = em.createNamedQuery("Contact.getAdresses", Adresse.class).getResultList();
		em.close();
		return adresses;
	}

	public Contact addContactAdresse(Contact contact, Adresse adresse) {
		List<Adresse> contactAdresses = contact.getAdresses();
		contactAdresses.add(adresse);
		contact.setAdresse(contactAdresses);
		return contact;
	}

	public Contact deleteContactAdresse(Contact contact, Adresse adresse) {
		List<Adresse> contactAdresses = contact.getAdresses();
		Iterator<Adresse> iterator = contactAdresses.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getId() == adresse.getId()) {
				iterator.remove();
			}
		}
		// ne marche pas direct car remove compare les références des objets (il faut
		// donc redéfinir le .equals ou faire avec l'iterateur comme c'est fait en haut
		// contactAdresses.remove(adresse);
		contact.setAdresse(contactAdresses);
		return contact;
	}

//	public Contact modifyContactAdresse(Contact contact, Adresse newAdresse, long adresseID) {
//		List<Adresse> contactAdresses = contact.getAdresses();
//
//		contactAdresses.add(adresse);
//		contact.setAdresse(contactAdresses);
//		return contact;
//	}
}
