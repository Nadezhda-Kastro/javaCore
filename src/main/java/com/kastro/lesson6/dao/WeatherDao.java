package com.kastro.lesson6.dao;

import com.kastro.lesson6.weatherdto.Forecast;
import com.kastro.lesson6.weatherdto.ForecastInfo;
import com.kastro.lesson6.weatherdto.Temperature;
import com.kastro.lesson6.weatherdto.TemperatureInfo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WeatherDao {

    private static final String DB_NAME = "jdbc:sqlite:C:\\SQLite\\lesson8";
    private static final String SAVE_STATEMENT = "INSERT INTO weather " +
            "(date, dayPhrase, dayPrecipitation, nightPhrase, nightPrecipitation, minimum, maximum)" +
            " VALUES(?, ?, ?, ?, ?, ?, ?);";
    private static final String READ_STATEMENT = "SELECT * FROM weather";

    public void save(List<Forecast> forecasts) {
        try (Connection connection = DriverManager.getConnection(DB_NAME)) {
            PreparedStatement saveStatement = connection.prepareStatement(SAVE_STATEMENT);
            for (Forecast forecast : forecasts) {
                ForecastInfo day = forecast.getDay();
                ForecastInfo night = forecast.getNight();
                TemperatureInfo minimum = forecast.getTemperature().getMinimum();
                TemperatureInfo maximum = forecast.getTemperature().getMaximum();

                saveStatement.setString(1, forecast.getDate().toString());
                saveStatement.setString(2, day.getPhrase());
                saveStatement.setString(3, String.valueOf(day.getHasPrecipitation()));
                saveStatement.setString(4, night.getPhrase());
                saveStatement.setString(5, String.valueOf(night.getHasPrecipitation()));
                saveStatement.setDouble(6, minimum.getValue());
                saveStatement.setDouble(7, maximum.getValue());
                saveStatement.addBatch();
            }
            saveStatement.executeBatch();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public List<Forecast> read() {
        List<Forecast> forecasts = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_NAME)) {
            PreparedStatement readStatement = connection.prepareStatement(READ_STATEMENT);
            ResultSet resultSet = readStatement.executeQuery();
            while (resultSet.next()) {
                Forecast forecast = new Forecast();
                Temperature temperature = new Temperature();
                TemperatureInfo minimum = new TemperatureInfo();
                TemperatureInfo maximum = new TemperatureInfo();
                temperature.setMinimum(minimum);
                temperature.setMaximum(maximum);
                ForecastInfo day = new ForecastInfo();
                ForecastInfo night = new ForecastInfo();
                forecast.setDay(day);
                forecast.setNight(night);
                forecast.setTemperature(temperature);

                forecast.setDate(Date.valueOf(resultSet.getString("date")));
                day.setPhrase(resultSet.getString("dayPhrase"));
                day.setHasPrecipitation(resultSet.getBoolean("dayPrecipitation"));
                night.setPhrase(resultSet.getString("nightPhrase"));
                night.setHasPrecipitation(resultSet.getBoolean("nightPrecipitation"));
                minimum.setValue(resultSet.getDouble("minimum"));
                minimum.setUnit("C");
                maximum.setValue(resultSet.getDouble("maximum"));
                maximum.setUnit("C");

                forecasts.add(forecast);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return forecasts;
    }
}
