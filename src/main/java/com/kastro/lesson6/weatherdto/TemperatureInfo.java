package com.kastro.lesson6.weatherdto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemperatureInfo {

    @JsonProperty("Value")
    private Double value;

    @JsonProperty("Unit")
    private String unit;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
