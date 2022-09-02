package com.yotproov.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forecast")
public class ForecastController {

    @GetMapping
    public ResponseEntity<String> getForecast() {
        return new ResponseEntity<>("tere!", HttpStatus.ACCEPTED);
    }
}
