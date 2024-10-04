package io.twentysixty.sa.client.res.s;

import io.twentysixty.sa.client.model.event.MessageReceived;
import io.twentysixty.sa.client.model.event.MessageStateUpdated;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

public interface MessageEventInterface {

  @POST
  @Path("/message-received")
  @Produces("application/json")
  @Consumes("application/json")
  public Response messageReceived(MessageReceived event);

  @POST
  @Path("/message-state-updated")
  @Produces("application/json")
  @Consumes("application/json")
  public Response messageStateUpdated(MessageStateUpdated event);
}
