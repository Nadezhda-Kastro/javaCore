package com.kastro.lesson6.weatherdto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class Forecast {

    @JsonProperty("Date")
    private Date date;

    @JsonProperty("Temperature")
    private Temperature temperature;

    @JsonProperty("Day")
    private ForecastInfo day;

    @JsonProperty("Night")
    private ForecastInfo night;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public ForecastInfo getDay() {
        return day;
    }

    public void setDay(ForecastInfo day) {
        this.day = day;
    }

    public ForecastInfo getNight() {
        return night;
    }

    public void setNight(ForecastInfo night) {
        this.night = night;
    }
}
