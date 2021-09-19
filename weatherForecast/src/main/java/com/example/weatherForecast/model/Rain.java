package com.example.weatherForecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "3h" })
public class Rain {

	private Float _3h;

	public Float get_3h() {
		return _3h;
	}

	public void set_3h(Float _3h) {
		this._3h = _3h;
	}
	
}
