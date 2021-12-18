package com.OpenWeatherMap.TestCases;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.testng.annotations.AfterClass;

import io.restassured.RestAssured;


public class BaseClass
{
	public final String APP_ID="9d50450a48809637b4862bdcb125927d";
	public final String BASE_URL="https://api.openweathermap.org/data/2.5/weather?id=";
	public final String UNIT="metric";
	
	@AfterClass
	public void Baseclass()
	{
	
	}
	
	public String getUrl(int cityid, String lang)
	{
		//Build URL 
		StringBuilder url = new StringBuilder();
		url.append(BASE_URL);
		url.append(cityid);
		url.append("&appid=");
		url.append(APP_ID);
		url.append("&units=");
		url.append(UNIT);
		url.append("&lang=");
		url.append(lang);
		return url.toString();
	}

	public String getWeatherData(String url)
	{
		//Get the necessary data from Weather API response
		float temp = RestAssured.get(url).then().extract().path("main.temp");
		int humidity = RestAssured.get(url).then().extract().path("main.humidity");
		ArrayList<String> descr = RestAssured.get(url).then().extract().path("weather.description");
		float min = RestAssured.get(url).then().extract().path("main.temp_min");
		float max = RestAssured.get(url).then().extract().path("main.temp_max");
		String city = RestAssured.get(url).then().extract().path("name");
		
		StringBuilder weatherdata = new StringBuilder();
		weatherdata.append("");
		weatherdata.append("Weather details of ");
		weatherdata.append(city);
		weatherdata.append("  is:");
		weatherdata.append("<br/>");
		weatherdata.append("Temperature is :  ");
		weatherdata.append(temp);
		weatherdata.append("°C");
		weatherdata.append("<br/>");
		weatherdata.append("Humidity is :");
		weatherdata.append(humidity);
		weatherdata.append("<br/>");
		weatherdata.append("Weather Description is :");
		weatherdata.append(descr);
		weatherdata.append("<br/>");
		weatherdata.append("Minimum Temperature is :");
		weatherdata.append(min);
		weatherdata.append("°C");
		weatherdata.append("<br/>");
		weatherdata.append("Maximum Temperature is :");
		weatherdata.append(max);
		weatherdata.append("°C");
		weatherdata.append("<br/>");
		weatherdata.append("<br/>");
		
		return weatherdata.toString();
	}
	
	
public void writeToFile(String weatherData) {
		
        try {
            //Initializing file and writing to system.
            File statText = new File(System.getProperty("user.dir")+"\\OutputFile\\Report.html");
            FileOutputStream os = new FileOutputStream(statText,true);
            OutputStreamWriter osw = new OutputStreamWriter(os,StandardCharsets.UTF_8);    
            Writer w = new BufferedWriter(osw);
            w.write(weatherData);
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
    }
	
	public void getResponseBody(int cityid, String lang){
		 
		//Fetch response from the URL
		RestAssured.given().queryParam("id",cityid)
		           .queryParam("appid","9d50450a48809637b4862bdcb125927d")
		           .queryParam("units","metric")
		           .queryParam("lang",lang)
		           .when().get("https://api.openweathermap.org/data/2.5/weather").then().log().all();

		}
	
	
}
