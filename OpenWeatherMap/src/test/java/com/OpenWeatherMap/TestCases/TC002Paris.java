package com.OpenWeatherMap.TestCases;

import org.testng.annotations.Test;

public class TC002Paris extends BaseClass{

	@Test
	public void WeatherParis()
	{
		BaseClass b = new BaseClass();	
		String url = b.getUrl(2988507,"fr");//Get URI of ID 2988507 
		String weatherData = b.getWeatherData(url);
		b.writeToFile(weatherData);//Write to a Web page
	}

}
