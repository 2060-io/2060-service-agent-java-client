package io.twentysixty.sa.client.res.c;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.twentysixty.sa.client.model.message.BaseMessage;

@Path("")
public interface MessageInterface {

	@POST
	@Path("/message")
	@Produces("application/json")
	public void sendMessage(BaseMessage message);
}
