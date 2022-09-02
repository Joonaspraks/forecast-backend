package com.yotproov.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yotproov.model.Forecast;

@Service
public class ForecastClient {
    RestTemplate template = new RestTemplate();

    public ResponseEntity<Forecast> getForecast() {
        return template.getForEntity("https://www.ilmateenistus.ee/ilma_andmed/xml/forecast.php?lang=eng",
                Forecast.class);
    }
}
