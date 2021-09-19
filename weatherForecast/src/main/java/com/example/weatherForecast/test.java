package com.example.weatherForecast;

import java.util.Date;

public class test {

	public static void main(String[] args) {
		String epochString = "1632052800";
		long epoch = Long.parseLong( epochString );
		Date expiry = new Date( epoch * 1000 );
		System.out.println(expiry);
		
		System.out.println((float) (302.08 - 273.15));
	}

}
