package com.in28minutes.learning.jpa.jpain10steps.service;
//using this class we can access the user and store the user in database

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;
@Repository
@Transactional
public class UserDAOService {

	@PersistenceContext
	private EntityManager entityManager;
	public long insert(User user) {
		//open transaction
		
		entityManager.persist(user);
		//close the transaction
		return user.getId();
	}
	
	
}
