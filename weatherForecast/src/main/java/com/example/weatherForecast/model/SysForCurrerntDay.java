package com.example.weatherForecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "id","type" })
public class SysForCurrerntDay {

	private Integer type;
	private Integer id;
	private String country;
	private Float sunrise;
	private Float sunset;
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Float getSunrise() {
		return sunrise;
	}
	public void setSunrise(Float sunrise) {
		this.sunrise = sunrise;
	}
	public Float getSunset() {
		return sunset;
	}
	public void setSunset(Float sunset) {
		this.sunset = sunset;
	}
	
}
