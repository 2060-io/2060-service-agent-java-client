package io.twentysixty.sa.client.res.c.v1;

import io.twentysixty.sa.client.model.message.BaseMessage;
import io.twentysixty.sa.client.model.message.IdMessage;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("")
public interface MessageInterface { // cambiar void

	@POST
	@Path("/v1/message")
	@Produces("application/json")
	public IdMessage sendMessage(BaseMessage message);
}
