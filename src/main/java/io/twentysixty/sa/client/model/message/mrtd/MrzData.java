package io.twentysixty.sa.client.model.message.mrtd;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.twentysixty.sa.client.enums.Mrz;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
public class MrzData implements Serializable {

	private static final long serialVersionUID = -5234275638176689315L;

	private Object raw;
	private ParsedData parsed;

	public String getRaw() {
		if (raw instanceof List) {
			return String.join(",", (List<String>) raw);
		} else if (raw instanceof String) {
			return (String) raw;
		}
		return null;
	}

	@Getter
	@Setter
	@ToString
	public static class ParsedData {
		private Mrz.Format format;
		private Map<Mrz.FieldName, String> fields;
		private boolean valid;
	}
}
