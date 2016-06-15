package com.weather.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

/**
 * Created by abdul.aziz on 15/06/2016.
 */
@SpringBootApplication(scanBasePackages = "com.weather.app")
public class WeatherApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(WeatherApplication.class, args);
    }


    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(WeatherApplication.class);
    }
}
