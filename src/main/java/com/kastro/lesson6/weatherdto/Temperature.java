package com.kastro.lesson6.weatherdto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {

    @JsonProperty("Minimum")
    private TemperatureInfo minimum;

    @JsonProperty("Maximum")
    private TemperatureInfo maximum;

    public TemperatureInfo getMinimum() {
        return minimum;
    }

    public void setMinimum(TemperatureInfo minimum) {
        this.minimum = minimum;
    }

    public TemperatureInfo getMaximum() {
        return maximum;
    }

    public void setMaximum(TemperatureInfo maximum) {
        this.maximum = maximum;
    }
}
