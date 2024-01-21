package io.twentysixty.sa.client.res.s;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import io.twentysixty.sa.client.model.event.ConnectionStateUpdated;

@Path("")
public interface ConnectionEventInterface {

	@POST
	@Path("/connection-state-updated")
	@Produces("application/json")
	@Consumes("application/json")
	public Response connectionStateUpdated(ConnectionStateUpdated event);
}
