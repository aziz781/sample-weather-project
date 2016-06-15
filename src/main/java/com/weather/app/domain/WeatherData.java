package com.weather.app.domain;


    public class WeatherData {

        private String currentDate = "";

        private String cityName = "";

        private String weatherDesc = "" ;

        private String fahrenheit = "";

        private String celsius = "";

        private String sunrise = "";

        private String sunset = "";

        public String getCurrentDate() {
            return currentDate;
        }

        public void setCurrentDate(String currentDate) {
            this.currentDate = currentDate;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getWeatherDesc() {
            return weatherDesc;
        }

        public void setWeatherDesc(String weatherDesc) {
            this.weatherDesc = weatherDesc;
        }

        public String getFahrenheit() {
            return fahrenheit;
        }

        public void setFahrenheit(String fahrenheit) {
            this.fahrenheit = fahrenheit;
        }

        public String getCelsius() {
            return celsius;
        }

        public void setCelsius(String celsius) {
            this.celsius = celsius;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }
    }

