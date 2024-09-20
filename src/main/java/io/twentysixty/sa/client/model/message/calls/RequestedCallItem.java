package io.twentysixty.sa.client.model.message.calls;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@ToString
public class RequestedCallItem implements Serializable {

	private static final long serialVersionUID = -2718519112121712736L;

	private String wsUrl;
	private String iceserver;

}
