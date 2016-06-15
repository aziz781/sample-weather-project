package com.weather.app.service;

import com.weather.app.domain.WeatherData;

/**
 * Created by abdul.aziz on 15/06/2016.
 */
public interface WeatherService {

    WeatherData getCurrentWeather(String city);
}
