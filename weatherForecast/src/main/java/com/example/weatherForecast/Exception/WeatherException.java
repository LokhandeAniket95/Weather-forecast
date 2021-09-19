package com.example.weatherForecast.Exception;

public class WeatherException extends RuntimeException {

	private String message;
	
	public WeatherException(String message) {
        super(message);
        this.message = message;
    }
	public WeatherException() {
    }
}
