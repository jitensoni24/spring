package com.dtech.sauth.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.dtech.sauth.api.entity.User;

@org.springframework.stereotype.Repository
public class Repository<T> {

	@PersistenceContext
	EntityManager em;
	
	public void create(T entity) {
		em.merge(entity);
	}

	public List<User> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);
        TypedQuery<User> allQuery = em.createQuery(all);
        return allQuery.getResultList();
	}

	public User get(String username) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> where = cq.select(rootEntry).where(cb.equal(rootEntry.get("username"), username));
		User user = em.createQuery(where).getSingleResult();
		
		System.out.println(user.getUsername());
		
		return user;
	}
}
