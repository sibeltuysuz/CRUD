package com.setek.crud.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.setek.crud.model.Il;


@Stateless
public class IlDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Il il) {
		entityManager.persist(il);
	}

	public Il merge(Il il) {
		return entityManager.merge(il);
	}

	public void remove(Il il) {
		entityManager.remove(il);
	}

	public Il find(int id) {
		return entityManager.find(Il.class, id);
	}

	public List<Il> findAll() {
		return entityManager.createQuery("FROM Il", Il.class)
				.getResultList();
	}

}
