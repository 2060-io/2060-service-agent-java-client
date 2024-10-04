package io.twentysixty.sa.client.I18n;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;

import org.eclipse.microprofile.config.ConfigProvider;

public class InternationalizationService {

	private String defaultLanguage = "en";
	private List<String> messages = new ArrayList<>();
	private String rootFiles = "META-INF/resources/Messages";

	Map<UUID, ResourceBundle> bundles = new HashMap<>();

	public String get(String messageName, UUID connection, String language, ClassLoader classLoader) {
		String retval = messageName;
		ResourceBundle currentBundle;

		if (!bundles.containsKey(connection)) {
			if (language != null && !language.isEmpty()) {
				try {
					currentBundle = ResourceBundle.getBundle(getRootFiles(), new Locale(language), classLoader);
				} catch (Exception e) {
					currentBundle = ResourceBundle.getBundle(getRootFiles(), new Locale(getDefaultLanguage()));
				}
			} else {
				currentBundle = ResourceBundle.getBundle(getRootFiles(), new Locale(getDefaultLanguage()));
			}

			bundles.put(connection, currentBundle);
		} else {
			currentBundle = bundles.get(connection);
		}

		try {
			retval = currentBundle.getString(messageName);
		} catch (Exception e) {

		}

		try {
			if (getMessages().contains(messageName))
				return this.getConfigValue(retval);
		} catch (Exception e) {
		}

		return retval;
	}

	private String getConfigValue(String key) {
		return ConfigProvider.getConfig().getValue(key, String.class);
	}

	public String getDefaultLanguage() {
		return defaultLanguage;
	}

	public void setDefaultLanguage(String defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public String getRootFiles() {
		return rootFiles;
	}

	public void setRootFiles(String rootFiles) {
		this.rootFiles = rootFiles;
	}

}
