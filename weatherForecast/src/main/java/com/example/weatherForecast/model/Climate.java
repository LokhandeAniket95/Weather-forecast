package com.example.weatherForecast.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "rain","pop","sys","dt_txt" })
public class Climate {

	private Integer dt;
	private MainFor3Days main;
	private List<Weather> weather = null;
	private Clouds clouds;
	private Wind wind;
	private Integer visibility;
	private Float pop;
	private Rain rain;
	private SysFor3Days sys;
	private String dt_txt;
	private String date;
	public Integer getDt() {
		return dt;
	}
	public void setDt(Integer dt) {
		this.dt = dt;
	}
	public MainFor3Days getMain() {
		return main;
	}
	public void setMain(MainFor3Days main) {
		this.main = main;
	}
	public java.util.List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(java.util.List<Weather> weather) {
		this.weather = weather;
	}
	public Clouds getClouds() {
		return clouds;
	}
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Integer getVisibility() {
		return visibility;
	}
	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}
	public Float getPop() {
		return pop;
	}
	public void setPop(Float pop) {
		this.pop = pop;
	}
	public Rain getRain() {
		return rain;
	}
	public void setRain(Rain rain) {
		this.rain = rain;
	}
	public SysFor3Days getSys() {
		return sys;
	}
	public void setSys(SysFor3Days sys) {
		this.sys = sys;
	}
	public String getDt_txt() {
		return dt_txt;
	}
	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
