package io.twentysixty.sa.client.res.c;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.twentysixty.sa.client.model.credential.CredentialType;
import io.twentysixty.sa.client.model.message.BaseMessage;

@Path("")
public interface CredentialTypeInterface {

	@POST
	@Path("/credential-types")
	@Produces("application/json")
	public void createCredentialType(CredentialType credentialType);
	
	
	@GET
	@Path("/credential-types")
	@Produces("application/json")
	public List<CredentialType> getAllCredentialTypes();
	
	
	
}
