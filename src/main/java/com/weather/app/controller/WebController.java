package com.weather.app.controller;

import com.weather.app.domain.WeatherData;
import com.weather.app.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by abdul.aziz on 15/06/2016.
 */
@Controller
public class WebController {


	@Autowired
	WeatherService openWeatherService;

	@RequestMapping(value="/web", method= RequestMethod.GET)
	public String home(Model model) {

		WeatherData curentWeather = openWeatherService.getCurrentWeather("London");
		model.addAttribute("weatherData", curentWeather);

		return "view-weather";
	}

	@RequestMapping(value="/web", method= RequestMethod.POST)
	public String findCityData(@ModelAttribute WeatherData weatherData, Model model) {

		WeatherData curentWeather = openWeatherService.getCurrentWeather(weatherData.getCityName());
		model.addAttribute("weatherData", curentWeather);
		return "view-weather";
	}

}