package io.twentysixty.sa.client.res.s;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.twentysixty.sa.client.model.event.ConnectionStateUpdated;
import io.twentysixty.sa.client.model.event.Event;
import io.twentysixty.sa.client.model.message.BaseMessage;

@Path("")
public interface ConnectionEventInterface {

	@POST
	@Path("/connection-state-updated")
	@Produces("application/json")
	@Consumes("application/json")
	public void connectionStateUpdated(ConnectionStateUpdated event);
}
