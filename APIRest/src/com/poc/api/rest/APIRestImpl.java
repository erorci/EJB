package com.poc.api.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.poc.GuestbookEntry;
import com.poc.GuestbookEntryEJBLocal;
import com.poc.GuestbookEntryOracleEJB;
import com.poc.GuestbookEntryOracleEJBLocal;

@Path("/api")
@RequestScoped
public class APIRestImpl {
	
	@EJB
	GuestbookEntryEJBLocal ejb;	
	
	@EJB
	GuestbookEntryOracleEJBLocal oracle;
	
	@GET	
	@Path("/ping/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 		String output = "Jersey say : OK " + msg + "\nEJB Sql Server: " + ejb.toString()
 		 + "\nEJB Oracle: " + oracle.toString();
 		return Response.status(200).entity(output).build();
 
	}
	
	@GET	
	@Path("/listarSql")
	public List<GuestbookEntry> listar() {		
		List<GuestbookEntry> list = ejb.findEntries();
		return list; 
	}	
	
	@GET	
	@Path("/listarOracle")
	public List<GuestbookEntry> listarOracle() {		
		List<GuestbookEntry> list = oracle.findEntries();
		return list; 
	}
	
	@GET
	@Path("/replicar")
	public Response replicar() {
		return Response.status(200).entity(oracle.replicar()).build();
	}
 
}
