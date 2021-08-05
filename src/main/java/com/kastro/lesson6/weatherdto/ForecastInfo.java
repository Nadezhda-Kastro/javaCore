package com.kastro.lesson6.weatherdto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForecastInfo {

    @JsonProperty("IconPhrase")
    private String phrase;

    @JsonProperty("HasPrecipitation")
    private Boolean hasPrecipitation;

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public Boolean getHasPrecipitation() {
        return hasPrecipitation;
    }

    public void setHasPrecipitation(Boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }
}
