package com.setek.crud.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.setek.crud.dao.IlDao;
import com.setek.crud.dao.IlceDao;
import com.setek.crud.model.Il;
import com.setek.crud.model.Ilce;



@ManagedBean
@ViewScoped
public class IlceController {

	private Ilce ilce;
	private List<Ilce> ilces;
	private List<Il> ils;

	@EJB
	private IlceDao ilceDao;

	@EJB
	private IlDao ilDao;

	@PostConstruct
	private void init() {
		ilce = new Ilce();
		ilces = ilceDao.findAll();
		ils = ilDao.findAll();
	}

	public void kaydet() {
		ilceDao.persist(ilce);
		
		// refresh
		init();
	}

	public Ilce getIlce() {
		return ilce;
	}

	public void setIlce(Ilce ilce) {
		this.ilce = ilce;
	}

	public List<Ilce> getIlces() {
		return ilces;
	}

	public void setIlces(List<Ilce> ilces) {
		this.ilces = ilces;
	}

	public List<Il> getIls() {
		return ils;
	}

	public void setIls(List<Il> ils) {
		this.ils = ils;
	}

}