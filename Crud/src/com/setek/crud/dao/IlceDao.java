package com.setek.crud.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.setek.crud.model.Ilce;


@Stateless
public class IlceDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Ilce ilce) {
		entityManager.persist(ilce);
	}

	public Ilce merge(Ilce ilce) {
		return entityManager.merge(ilce);
	}

	public void remove(Ilce ilce) {
		entityManager.remove(ilce);
	}

	public Ilce find(int id) {
		return entityManager.find(Ilce.class, id);
	}

	public List<Ilce> findAll() {
		return entityManager.createQuery("FROM Ilce", Ilce.class)
				.getResultList();
	}

}
