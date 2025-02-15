package com.restapi.restapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {
	private String id;
	@JsonProperty("main")
	private String main;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("icon")
	private String icon;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	} 

}
