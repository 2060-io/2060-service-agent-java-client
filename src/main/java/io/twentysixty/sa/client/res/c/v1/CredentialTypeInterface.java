package io.twentysixty.sa.client.res.c.v1;

import io.twentysixty.sa.client.model.credential.CredentialType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import java.util.List;

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
