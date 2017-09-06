package fr.epf.daos;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epf.models.User;

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
	
	public List<User> findAll() {
		return em.createQuery("SELECT id, firstName, lastName FROM User").getResultList();
	}

}
