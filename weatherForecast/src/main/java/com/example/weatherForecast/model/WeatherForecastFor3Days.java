package com.example.weatherForecast.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "cod","message","cnt" })
public class WeatherForecastFor3Days {

	private String cod;
	private Integer message;
	private Integer cnt;
	private List<Climate> list = null;
	private City city;
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public Integer getMessage() {
		return message;
	}
	public void setMessage(Integer message) {
		this.message = message;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	public List<Climate> getList() {
		return list;
	}
	public void setList(List<Climate> list) {
		this.list = list;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
}
