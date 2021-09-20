package com.example.weatherForecast.servieImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.weatherForecast.Exception.WeatherException;
import com.example.weatherForecast.constant.WeatherForecastConstant;
import com.example.weatherForecast.model.WeatherForecastFor3Days;
import com.example.weatherForecast.model.WeatherForecastForCurrentDay;
import com.example.weatherForecast.service.WeatherForecastService;
import com.example.weatherForecast.utils.Utils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherForecastServiceImpl implements WeatherForecastService{

	@Value("${weather.forcast.api.id}")
	public String appid;

	public ResponseEntity<WeatherForecastFor3Days> getWeatherForecastFor3DaysByCity(String cityName) throws JsonParseException, JsonMappingException, IOException {
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		ObjectMapper objectMapper = new ObjectMapper();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<WeatherForecastFor3Days> response = null;
		ResponseEntity<String> responseEntity = null;
		String url = "http://api.openweathermap.org/data/2.5/forecast";
		Map<String, String> urlParams = new HashMap<>();
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url)
				.queryParam(WeatherForecastConstant.CITY_NAME, cityName)
				.queryParam(WeatherForecastConstant.DAYS, 3)
				.queryParam(WeatherForecastConstant.API_ID, appid);
		UriComponents appendSearObjectBuilder = UriComponentsBuilder.fromUri(uriBuilder.buildAndExpand(urlParams).toUri()).build();
		UriComponentsBuilder uri= UriComponentsBuilder.fromUriString(appendSearObjectBuilder.toUriString());
		HttpEntity entity = new HttpEntity(headers);
		try{
			responseEntity = template.exchange(uri.build().encode().toUri(), HttpMethod.GET, entity, String.class);
			if(responseEntity.getStatusCode().equals(HttpStatus.OK)) {
				WeatherForecastFor3Days weatherForecast = objectMapper.readValue(responseEntity.getBody(), WeatherForecastFor3Days.class);
				weatherForecast.getList().forEach(climate -> {
					climate.getMain().setTemp(Utils.convertKelvinToCelsius(climate.getMain().getTemp()));
					climate.getMain().setTemp_min(Utils.convertKelvinToCelsius(climate.getMain().getTemp_min()));
					climate.getMain().setTemp_max(Utils.convertKelvinToCelsius(climate.getMain().getTemp_max()));
					climate.setDate(Utils.unixEpochToDate(climate.getDt().toString()).toString());
				});
				weatherForecast.getCity().setSunrise(Utils.convertKelvinToCelsius(weatherForecast.getCity().getSunrise().floatValue()));
				weatherForecast.getCity().setSunset(Utils.convertKelvinToCelsius(weatherForecast.getCity().getSunset().floatValue()));
				response = new ResponseEntity<>(weatherForecast, headers, HttpStatus.OK);
			}
		}catch(HttpClientErrorException e) {
			throw new WeatherException("city not found");
		}
		return response;
	}

	public ResponseEntity<WeatherForecastForCurrentDay> getWeatherForecastForCurrentDaysByCity(String cityName) throws JsonParseException, JsonMappingException, IOException {
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		ObjectMapper objectMapper = new ObjectMapper();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<WeatherForecastForCurrentDay> response = null;
		ResponseEntity<String> responseEntity = null;
		String url = "https://api.openweathermap.org/data/2.5/weather";
		Map<String, String> urlParams = new HashMap<>();
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url)
				.queryParam(WeatherForecastConstant.CITY_NAME, cityName)
				.queryParam(WeatherForecastConstant.API_ID, appid);
		UriComponents appendSearObjectBuilder = UriComponentsBuilder.fromUri(uriBuilder.buildAndExpand(urlParams).toUri()).build();
		UriComponentsBuilder uri= UriComponentsBuilder.fromUriString(appendSearObjectBuilder.toUriString());
		HttpEntity entity = new HttpEntity(headers);
		try{
			responseEntity = template.exchange(uri.build().encode().toUri(), HttpMethod.GET, entity, String.class);
			if(responseEntity.getStatusCode().equals(HttpStatus.OK)) {
				WeatherForecastForCurrentDay weatherForecast = objectMapper.readValue(responseEntity.getBody(), WeatherForecastForCurrentDay.class);
				weatherForecast.getMain().setTemp(Utils.convertKelvinToCelsius(weatherForecast.getMain().getTemp()));
				weatherForecast.getMain().setTemp_min(Utils.convertKelvinToCelsius(weatherForecast.getMain().getTemp_min()));
				weatherForecast.getMain().setTemp_max(Utils.convertKelvinToCelsius(weatherForecast.getMain().getTemp_max()));
				weatherForecast.setDate(Utils.unixEpochToDate(weatherForecast.getDt().toString()).toString());
				weatherForecast.getSys().setSunrise(Utils.convertKelvinToCelsius(weatherForecast.getSys().getSunrise().floatValue()));
				weatherForecast.getSys().setSunset(Utils.convertKelvinToCelsius(weatherForecast.getSys().getSunset().floatValue()));
				response = new ResponseEntity<>(weatherForecast, headers, HttpStatus.OK);
			}
		}catch(HttpClientErrorException e) {
			throw new WeatherException("city not found");
		}
		return response;
	}
}
