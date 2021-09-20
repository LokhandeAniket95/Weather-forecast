package com.example.weatherForecast.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import com.example.weatherForecast.model.WeatherForecastFor3Days;
import com.example.weatherForecast.model.WeatherForecastForCurrentDay;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface WeatherForecastService {
	
	public ResponseEntity<WeatherForecastFor3Days> getWeatherForecastFor3DaysByCity(String cityName) throws JsonParseException, JsonMappingException, IOException;

	public ResponseEntity<WeatherForecastForCurrentDay> getWeatherForecastForCurrentDaysByCity(String cityName) throws JsonParseException, JsonMappingException, IOException;
}
