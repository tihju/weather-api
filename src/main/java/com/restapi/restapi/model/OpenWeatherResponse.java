package com.restapi.restapi.model;

import java.lang.reflect.Array;
import java.util.List;

import org.json.simple.JSONArray;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenWeatherResponse {
	private Coord coord;
//	private JSONArray weather;
	@JsonProperty("weather")
	private List<Weather> weather;
	private String base;
	private Main main;
	private String visibility;
	private Wind wind;
	private Cloud cloud;
	private String dt;
	private Sys sys;
	private String timezone;
	private String id;
	private String name;
	private String cod;
	
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Cloud getCloud() {
		return cloud;
	}
	public void setCloud(Cloud cloud) {
		this.cloud = cloud;
	}
	public Sys getSys() {
		return sys;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	
	
}
