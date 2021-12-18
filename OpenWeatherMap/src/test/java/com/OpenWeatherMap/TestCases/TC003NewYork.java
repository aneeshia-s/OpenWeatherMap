package com.OpenWeatherMap.TestCases;

import org.testng.annotations.Test;

public class TC003NewYork extends BaseClass{

	@Test
	public void WeatherNewYork()
	{
		BaseClass b = new BaseClass();	
		String url = b.getUrl(5128581,"en");//Get URI of ID 5128581 
		String weatherData = b.getWeatherData(url);
		b.writeToFile(weatherData);//Write to a Web page
	}

}
