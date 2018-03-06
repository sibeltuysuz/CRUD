package com.setek.crud.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.setek.crud.dao.IlDao;
import com.setek.crud.model.Il;


@ManagedBean
@ViewScoped
public class IlController {

	private Il il;

	private List<Il> ils;

	@EJB
	private IlDao ilDao;

	@PostConstruct
	private void init() {
		il = new Il();
		ils = ilDao.findAll();
	}

	public void kaydet() {
		ilDao.persist(il);

		// refresh
		init();
	}

	public void update(Il il) {
		ilDao.merge(il);
	}

	public void remove() {
		ilDao.remove(il);
	}

	public Il getIl() {
		return il;
	}

	public void setIl(Il il) {
		this.il = il;
	}

	public List<Il> getIls() {
		return ils;
	}

	public void setIls(List<Il> ils) {
		this.ils = ils;
	}

	public void onRowEdit(RowEditEvent event) {
		// update
		update(((Il) event.getObject()));
		FacesMessage msg = new FacesMessage("il Edited", ((Il) event.getObject()).getAdi());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(((Il) event.getObject()).getId()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}