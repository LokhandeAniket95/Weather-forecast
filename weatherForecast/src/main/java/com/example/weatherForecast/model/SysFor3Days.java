package com.example.weatherForecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "pod" })
public class SysFor3Days {
	
	private String pod;

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}
	
}
