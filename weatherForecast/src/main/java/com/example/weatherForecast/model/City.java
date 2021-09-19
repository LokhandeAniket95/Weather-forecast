package com.example.weatherForecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "id","population","timezone" })
public class City {
	private Integer id;
	private String name;
	private Coord coord;
	private String country;
	private Integer population;
	private Integer timezone;
	private Float sunrise;
	private Float sunset;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Coord getCoord() {
		return coord;
	}
	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public Integer getTimezone() {
		return timezone;
	}
	public void setTimezone(Integer timezone) {
		this.timezone = timezone;
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
