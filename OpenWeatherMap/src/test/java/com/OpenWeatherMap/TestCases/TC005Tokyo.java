package com.OpenWeatherMap.TestCases;

import org.testng.annotations.Test;

public class TC005Tokyo extends BaseClass{

	@Test
	public void WeatherNewYork()
	{
		BaseClass b = new BaseClass();	
		String url = b.getUrl(1850147,"ja");//Get URI of ID 1850147 
		String weatherData = b.getWeatherData(url);
		b.writeToFile(weatherData);//Write to a Web page
	}

}
