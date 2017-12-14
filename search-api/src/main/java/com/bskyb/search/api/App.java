package com.bskyb.search.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class App {

	@JsonProperty(value = "name")
	@JsonInclude(Include.NON_NULL)
	private String name;

	@JsonProperty(value = "version")
	@JsonInclude(Include.NON_NULL)
	private String version;

	public App() {}

	public App(String name, String version) {
		this.name = name;
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
