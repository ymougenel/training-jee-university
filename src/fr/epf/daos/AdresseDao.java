package fr.epf.daos;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epf.models.Adresse;

@Singleton
public class AdresseDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Adresse u) {
		em.persist(u);
	}

	public Adresse findOne(Long id) {
		return em.find(Adresse.class, id);
	}
	
	public List<Adresse> findAll() {
		return em.createQuery("SELECT id, firstName, lastName FROM Adresse").getResultList();
	}

}
