package com.weather.app.service;

import com.weather.app.domain.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import net.aksingh.owmjapis.AbstractWeather;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by abdul.aziz on 15/06/2016.
 */
@Service
public class OpenWeatherService implements WeatherService{

	@Value("${open.weather.map.api.key}")
	private  String API_KEY;

	private static final Logger log = LoggerFactory.getLogger(OpenWeatherService.class);

	@Override
	public WeatherData getCurrentWeather(String city) {

		try{

			OpenWeatherMap owm = new OpenWeatherMap(API_KEY);

			CurrentWeather cwd = owm.currentWeatherByCityName(city);

			return mapCurrentWeatherData(cwd);

		}catch (Exception exp)
		{
			log.error("Error in WeatherService : "+exp.getLocalizedMessage());
		}

		return new WeatherData();
	}

	private WeatherData mapCurrentWeatherData(CurrentWeather cwd)
	{
		WeatherData data = new WeatherData();
		AbstractWeather.Weather weather = cwd.getWeatherInstance(0);
		CurrentWeather.Sys sys = cwd.getSysInstance();

		// city
		data.setCityName(cwd.getCityName());
		// today date
		data.setCurrentDate(getDateStr(cwd.getDateTime(),cwd.getCityName()));
		// weather desc
		data.setWeatherDesc(weather.getWeatherDescription());
		// max./min. temperature
		data.setFahrenheit(cwd.getMainInstance().getMaxTemperature()
					+ "/" + cwd.getMainInstance().getMinTemperature() + "\'F");

		data.setCelsius(convertFahrenheitToCelsius(cwd.getMainInstance().getMaxTemperature())
				+ "/" + convertFahrenheitToCelsius(cwd.getMainInstance().getMinTemperature()) + "\'C");

		// sun rise
		data.setSunrise(getTimeStr(sys.getSunriseTime(),cwd.getCityName()));
		// sun set
		data.setSunset(getTimeStr(sys.getSunsetTime(),cwd.getCityName()));
		return data;
	}

	private  String getTimeStr(Date date,String city)
	{
		Instant instant = date.toInstant();
		ZonedDateTime zdt = instant.atZone(getZoneId(city));
		LocalTime localTime = zdt.toLocalTime();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
		String timeStr = localTime.format(formatter);
		return timeStr;
	}

	private  String getDateStr(Date date,String city)
	{
		Instant instant = date.toInstant();
		ZonedDateTime zdt = instant.atZone(getZoneId(city));
		LocalDate localDate = zdt.toLocalDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dateStr = localDate.format(formatter);
		return dateStr;
	}

	private String convertFahrenheitToCelsius(final float fahrenheitValue)
	{
		float celsiusValue =  ((fahrenheitValue - 32)*5)/9;
		return String.format("%.2f", celsiusValue);
	}

	private ZoneId getZoneId(final String city)
	{
		if("London".equals(city))
			return ZoneId.of("Europe/London");
		else if("Hong Kong".equals(city))
			return ZoneId.of("Asia/Hong_Kong");
		else
			return ZoneId.systemDefault();

	}
}