package io.twentysixty.sa.client.model.message;

import java.io.Serializable;

public class Ciphering  implements Serializable {

    private static final long serialVersionUID = -8660299956191649637L;
	private String algorithm;
    private Parameters parameters;

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Ciphering [algorithm=" + algorithm + ", parameters=" + parameters + "]";
    }

}
