package com.example.weatherForecast.utils;

import java.util.Date;

public class Utils {

	public static Date unixEpochToDate(String unixEpochDate) {
		long epoch = Long.parseLong(unixEpochDate);
		return new Date( epoch * 1000 );
	}

	public static float convertKelvinToCelsius(float kelvin) {
		return (float) (kelvin - 273.15);
	}

}
