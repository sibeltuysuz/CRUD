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

import com.setek.crud.dao.IlDao;
import com.setek.crud.model.Il;



@Path("ils")
public class IlService {

	@EJB
	IlDao ilDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIls() {
		List<Il> ils = ilDao.findAll();
		if (ils == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).entity(ils).build();
	}

	@GET
	@Path("{ilId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIlById(@PathParam("ilId") int ilId) {
		Il il = ilDao.find(ilId);
		if (il == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).entity(il).build();
	}

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addIl(Il il) {
		try {
			ilDao.persist(il);
			return Response.status(Response.Status.OK).entity(il).build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
	}

}