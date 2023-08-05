package io.twentysixty.sa.client.res.s;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.twentysixty.sa.client.model.event.MessageReceived;
import io.twentysixty.sa.client.model.event.MessageStateUpdated;
import io.twentysixty.sa.client.model.message.BaseMessage;

@Path("")
public interface MessageEventInterface {

	@POST
	@Path("/message-received")
	@Produces("application/json")
	@Consumes("application/json")
	public void messageReceived(MessageReceived event);
	
	@POST
	@Path("/message-state-updated")
	@Produces("application/json")
	@Consumes("application/json")
	public void messageStateUpdated(MessageStateUpdated event);
	
	
}
