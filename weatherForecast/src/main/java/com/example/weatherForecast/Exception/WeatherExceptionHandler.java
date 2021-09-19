package com.example.weatherForecast.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.weatherForecast.model.ErrorResponse;

@ControllerAdvice
public class WeatherExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {WeatherException.class})
    public ResponseEntity<Object> handleCityDoesNotExistsException(WeatherException weatherException) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(weatherException.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity(weatherException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
