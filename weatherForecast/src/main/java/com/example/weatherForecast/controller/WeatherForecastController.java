package com.example.weatherForecast.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.weatherForecast.model.WeatherForecastFor3Days;
import com.example.weatherForecast.model.WeatherForecastForCurrentDay;
import com.example.weatherForecast.service.WeatherForecastService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController("/weather")
public class WeatherForecastController {
	
	@Autowired
	WeatherForecastService weatherForecastService;

	@GetMapping("/forecastFor3DaysByCity")
	public ResponseEntity<WeatherForecastFor3Days> getWeatherForecastFor3DaysByCity(@RequestParam String cityName) throws JsonParseException, JsonMappingException, IOException {
		return weatherForecastService.getWeatherForecastFor3DaysByCity(cityName);
	}
	
	@GetMapping("/forecastForCurrentDaysByCity")
	public ResponseEntity<WeatherForecastForCurrentDay> getWeatherForecastForCurrentDaysByCity(@RequestParam String cityName) throws JsonParseException, JsonMappingException, IOException {
		return weatherForecastService.getWeatherForecastForCurrentDaysByCity(cityName);
	}
}
