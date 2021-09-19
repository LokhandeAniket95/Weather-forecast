package com.example.weatherForecast.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "visibility" })
public class WeatherForecastForCurrentDay {

	private Coord coord;
	private List<Weather> weather = null;
	private String base;
	private MainCurrentDay main;
	private Integer visibility;
	private Wind wind;
	private Clouds clouds;
	private Integer dt;
	private SysForCurrerntDay sys;
	private Integer timezone;
	private Integer id;
	private String name;
	private Integer cod;
	private String date;
	public Coord getCoord() {
		return coord;
	}
	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public MainCurrentDay getMain() {
		return main;
	}
	public void setMain(MainCurrentDay main) {
		this.main = main;
	}
	public Integer getVisibility() {
		return visibility;
	}
	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Clouds getClouds() {
		return clouds;
	}
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	public Integer getDt() {
		return dt;
	}
	public void setDt(Integer dt) {
		this.dt = dt;
	}
	public SysForCurrerntDay getSys() {
		return sys;
	}
	public void setSys(SysForCurrerntDay sys) {
		this.sys = sys;
	}
	public Integer getTimezone() {
		return timezone;
	}
	public void setTimezone(Integer timezone) {
		this.timezone = timezone;
	}
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
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
