package io.resourcepool.daos;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.resourcepool.models.User;
import io.resourcepool.models.Cellphone;

@Singleton
public class CellphoneDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Cellphone u) {
		em.persist(u);
	}

	public Cellphone findOne(Long id) {
		return em.find(Cellphone.class, id);
	}
	
	public List<Cellphone> findAll() {
		return em.createQuery("SELECT id, firstName, lastName FROM User").getResultList();
	}

}
