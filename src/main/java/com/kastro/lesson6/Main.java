package com.kastro.lesson6;
//С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге (или любом другом городе)
// на период времени, пересекающийся со следующим занятием (например, выборка погода на следующие 5 дней - подойдет)
//  Бесплатный тарифный план предполагает получение погоды не более чем на 5 дней вперед
//  (этого достаточно для выполнения д/з).
//294021

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Main {

    private static final String WEATHER_API_KEY = "tQRQnpPZkJRAzipG5AW3VG1cu2TYBXZs";

    public static void main(String[] args) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            String url = String.format("https://dataservice.accuweather.com/forecasts/v1/daily/5day/294021?apikey=%s",
                    WEATHER_API_KEY);

            HttpGet getWeatherRequest = new HttpGet(url);
            getWeatherRequest.addHeader("accept", "application/json");

            CloseableHttpResponse weatherResult = client.execute(getWeatherRequest);
            System.out.println(EntityUtils.toString(weatherResult.getEntity()));
            weatherResult.close();
        } catch (IOException e) {
            System.out.println("Ошибка вызова сервиса погоды");
            e.printStackTrace();
        }
    }
}
