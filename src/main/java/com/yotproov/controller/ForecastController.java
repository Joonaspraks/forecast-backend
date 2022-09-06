package com.yotproov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yotproov.client.ForecastClient;
import com.yotproov.client.ForecastFeignClient;
import com.yotproov.xmlConversion.XmlConverter;

import generated.Forecasts;
import generated.Observations;

@RestController
@RequestMapping("/forecast")
@CrossOrigin(origins = "http://localhost:9000")
public class ForecastController {

    @Autowired
    ForecastClient forecastClient;
    @Autowired
    ForecastFeignClient forecastFeignClient;

    @GetMapping()
    public ResponseEntity<Forecasts> getForecast() {
        Forecasts forecasts = forecastFeignClient.getForecast();
        return new ResponseEntity<>(forecasts, HttpStatus.OK);
    }

    @GetMapping(path = "/observations", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Observations> getObservations() {
        Observations observations = forecastFeignClient.getObservations();
        return new ResponseEntity<>(observations, HttpStatus.OK);
    }

    @GetMapping(path = "/unmarshal")
    public ResponseEntity<Forecasts> unmarshal() {
        XmlConverter xmlConverter = new XmlConverter();
        Forecasts forecasts = xmlConverter.unmarshall();
        return new ResponseEntity<>(forecasts, HttpStatus.OK);
    }
}
