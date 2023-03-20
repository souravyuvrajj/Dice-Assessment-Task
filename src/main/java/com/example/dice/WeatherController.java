package com.example.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/dice/weather")
public class WeatherController {

    @Autowired
    private WeatherApiService weatherApiService;

    @GetMapping("/forecast-summary")
    public ResponseEntity<String> getForecastSummaryByLocationName(
            @RequestParam("locationName") String locationName,
            @RequestHeader("clientId") String clientId,
            @RequestHeader("clientSecret") String clientSecret
    ) throws URISyntaxException {
        String response = weatherApiService.getForecastSummaryByLocationName(locationName, clientId, clientSecret);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/hourly-forecast")
    public ResponseEntity<String> getHourlyForecastByLocationName(
            @RequestParam("locationName") String locationName,
            @RequestHeader("clientId") String clientId,
            @RequestHeader("clientSecret") String clientSecret
    ) throws URISyntaxException {
        String response = weatherApiService.getHourlyForecastByLocationName(locationName, clientId, clientSecret);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
