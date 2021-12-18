package com.OpenWeatherMap.TestCases;

import org.testng.annotations.Test;

public class TC001London extends BaseClass
{


	@Test
	public void WeatherLondon()
	{
		BaseClass b = new BaseClass();	
		String url = b.getUrl(2643743,"en");//Get URI of London 
		String weatherData = b.getWeatherData(url);
		b.writeToFile(weatherData);//Write to a Web page
	}
}
