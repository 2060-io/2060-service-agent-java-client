package io.twentysixty.sa.client.res.c;

import java.util.List;

import io.twentysixty.sa.client.model.credential.CredentialType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

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
