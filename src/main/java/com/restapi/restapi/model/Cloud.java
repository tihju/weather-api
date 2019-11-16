package com.restapi.restapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape=JsonFormat.Shape.ARRAY)
public class Cloud {
	private String all;

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}
	
}
