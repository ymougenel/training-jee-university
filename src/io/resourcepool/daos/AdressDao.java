package io.resourcepool.daos;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.resourcepool.models.Adress;

@Singleton
public class AdressDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Adress u) {
		em.persist(u);
	}

	public Adress findOne(Long id) {
		return em.find(Adress.class, id);
	}
	
	public List<Adress> findAll() {
		//make sure the table name is composed with a capital letter
		return em.createQuery("SELECT id, firstName, lastName FROM Adresse").getResultList();
	}

}
