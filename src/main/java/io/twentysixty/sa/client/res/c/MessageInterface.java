package io.twentysixty.sa.client.res.c;

import io.twentysixty.sa.client.model.message.BaseMessage;
import io.twentysixty.sa.client.model.message.IdMessage;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

public interface MessageInterface { // cambiar void

  @POST
  @Path("/message")
  @Produces("application/json")
  public IdMessage sendMessage(BaseMessage message);
}
