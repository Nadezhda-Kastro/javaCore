package com.kastro.lesson6;
//С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге (или любом другом городе)
// на период времени, пересекающийся со следующим занятием (например, выборка погода на следующие 5 дней - подойдет)
//  Бесплатный тарифный план предполагает получение погоды не более чем на 5 дней вперед
//  (этого достаточно для выполнения д/з).
//294021

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kastro.lesson6.dao.WeatherDao;
import com.kastro.lesson6.weatherdto.Forecast;
import com.kastro.lesson6.weatherdto.ForecastInfo;
import com.kastro.lesson6.weatherdto.TemperatureInfo;
import com.kastro.lesson6.weatherdto.WeatherResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.List;

public class Main {

    private static final String WEATHER_API_KEY = "tQRQnpPZkJRAzipG5AW3VG1cu2TYBXZs";
    private static final String WEATHER_MESSAGE = "%s: Днем %s. Осадки %s ожидаются.\nВечером %s. Осадки %s ожидаются.\nТемпература ожидается от %s%s до %s%s.";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    public static void main(String[] args) {
        withDb();
//        withoutDb();
    }

    public static void withoutDb() {
        WeatherResponse weatherResponse = requestWeather();
        if (weatherResponse == null) {
            System.out.println("Сервис погоды не отвечает");
            return;
        }
        printWeather(weatherResponse.getForecasts());
    }

    public static void withDb() {
        WeatherResponse weatherResponse = requestWeather();
        if (weatherResponse == null) {
            System.out.println("Сервис погоды не отвечает");
            return;
        }
        WeatherDao weatherDao = new WeatherDao();
        weatherDao.save(weatherResponse.getForecasts());
        printWeather(weatherDao.read());
    }

    private static WeatherResponse requestWeather() {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            String url = String.format("https://dataservice.accuweather.com/forecasts/v1/daily/5day/294021?apikey=%s&language=ru-ru&metric=true",
                    WEATHER_API_KEY);

            HttpGet getWeatherRequest = new HttpGet(url);
            getWeatherRequest.addHeader("accept", "application/json");

            CloseableHttpResponse weatherResult = client.execute(getWeatherRequest);
            return OBJECT_MAPPER.readValue(weatherResult.getEntity().getContent(), WeatherResponse.class);
        } catch (IOException e) {
            System.out.println("Ошибка вызова сервиса погоды");
            e.printStackTrace();
        }
        return null;
    }

    private static void printWeather(Forecast forecast) {
        ForecastInfo day = forecast.getDay();
        String dayPrecipitation = day.getHasPrecipitation() ? "" : "не";
        ForecastInfo night = forecast.getNight();
        String nightPrecipitation = night.getHasPrecipitation() ? "" : "не";
        TemperatureInfo minimum = forecast.getTemperature().getMinimum();
        TemperatureInfo maximum = forecast.getTemperature().getMaximum();
        System.out.println(String.format(WEATHER_MESSAGE, forecast.getDate(), day.getPhrase(), dayPrecipitation,
                night.getPhrase(), nightPrecipitation, minimum.getValue(), minimum.getUnit(),
                maximum.getValue(), maximum.getUnit()));
    }

    private static void printWeather(List<Forecast> forecasts) {
        for (Forecast forecast : forecasts) {
            printWeather(forecast);
        }
    }
}
