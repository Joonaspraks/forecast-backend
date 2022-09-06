package com.yotproov.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import generated.Forecasts;
import generated.Observations;

@Service
public class ForecastClient {
    RestTemplate template = new RestTemplate();

    public Forecasts getForecast() {
        return template.getForObject("https://www.ilmateenistus.ee/ilma_andmed/xml/forecast.php?lang=eng",
                Forecasts.class);
    }

    public Observations getObservations() {
        return template.getForObject("https://www.ilmateenistus.ee/ilma_andmed/xml/observations.php",
                Observations.class);
    }
}
