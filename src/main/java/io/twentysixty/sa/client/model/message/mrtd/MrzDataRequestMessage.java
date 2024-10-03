package io.twentysixty.sa.client.model.message.mrtd;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.twentysixty.sa.client.model.message.BaseMessage;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MrzDataRequestMessage extends BaseMessage {

	private static final long serialVersionUID = -2840211856886673672L;

	public static MrzDataRequestMessage build(UUID connectionId, UUID threadId) {
		MrzDataRequestMessage mrzr = new MrzDataRequestMessage();
		mrzr.setConnectionId(connectionId);
		mrzr.setThreadId(threadId);
		return mrzr;
	}
}
