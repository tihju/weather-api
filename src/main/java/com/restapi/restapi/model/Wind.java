package com.restapi.restapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Wind {
	private String speed;
	private String deg;
	
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getDeg() {
		return deg;
	}
	public void setDeg(String deg) {
		this.deg = deg;
	}
}
