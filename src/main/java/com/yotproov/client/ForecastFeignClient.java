package com.yotproov.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import generated.Forecasts;
import generated.Observations;

@FeignClient(name = "forecast", url = "https://www.ilmateenistus.ee/ilma_andmed/xml", configuration = ForecastFeignConfig.class)
public interface ForecastFeignClient {
    @GetMapping(value = "/forecast.php?lang=eng")
    Forecasts getForecast();

    @GetMapping(value = "/observations.php")
    Observations getObservations();
}
