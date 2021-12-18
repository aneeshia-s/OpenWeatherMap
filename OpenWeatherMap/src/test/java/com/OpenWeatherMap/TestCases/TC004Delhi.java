package com.OpenWeatherMap.TestCases;

import org.testng.annotations.Test;

public class TC004Delhi extends BaseClass{

	@Test
	public void WeatherNewYork()
	{
		BaseClass b = new BaseClass();	
		String url = b.getUrl(2650225,"hi");//Get URI of ID 2650225 
		String weatherData = b.getWeatherData(url);
		b.writeToFile(weatherData);//Write to a Web page
	}

}
