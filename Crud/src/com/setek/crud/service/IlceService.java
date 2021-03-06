package com.setek.crud.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.setek.crud.dao.IlceDao;
import com.setek.crud.model.Ilce;


@Path("ilces")
public class IlceService {

	@EJB
	IlceDao ilceDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIlces() {
		List<Ilce> ilces = ilceDao.findAll();
		if (ilces == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).entity(ilces).build();
	}

	@GET
	@Path("{ilceId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIlceById(@PathParam("ilceId") int ilceId) {
		Ilce ilce = ilceDao.find(ilceId);
		if (ilce == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).entity(ilce).build();
	}
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addIl(Ilce ilce) {
		try {
			ilceDao.persist(ilce);
			return Response.status(Response.Status.OK).entity(ilce).build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
	}

}