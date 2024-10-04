package io.twentysixty.sa.client.res.c.v1;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import io.twentysixty.sa.client.model.credential.CredentialType;

@Path("")
public interface CredentialTypeInterface {

	@POST
	@Path("/v1/credential-types")
	@Produces("application/json")
	public void createCredentialType(CredentialType credentialType);
	
	
	@GET
	@Path("/v1/credential-types")
	@Produces("application/json")
	public List<CredentialType> getAllCredentialTypes();
	
	
	
}
