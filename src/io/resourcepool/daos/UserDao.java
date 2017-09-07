package io.resourcepool.daos;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.resourcepool.models.User;

@Singleton
public class UserDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(User u) {
		em.persist(u);
	}

	public User findOne(Long id) {
		return em.find(User.class, id);
	}
	
	public Long count() {
		return (Long) em.createQuery("SELECT COUNT(*) FROM User").getSingleResult();
	}
	
	public List<User> findAll() {
		//TODO add the join whith adress and cellphone
		//make sure the table name is composed with a capital letter
		return (List<User>) em.createQuery("FROM User").getResultList();
	}

}
