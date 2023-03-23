package com.example.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class WeatherApiService {
    @Value("${rapidapi.BASE_URL}")
    private String BASE_URL;

    @Value("${rapidapi.RAPID_API_HOST}")
    private String RAPID_API_HOST;

    @Autowired
    private RestTemplate restTemplate;

    public String getForecastSummaryByLocationName(String locationName, String clientId, String clientSecret) throws URISyntaxException {
        HttpHeaders headers = getHttpHeaders();

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, new URI(BASE_URL + "forecast/" + locationName + "/hourly"));

        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);

        return responseEntity.getBody();
    }

    public String getHourlyForecastByLocationName(String locationName, String clientId, String clientSecret) throws URISyntaxException {
        HttpHeaders headers = getHttpHeaders();

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, new URI(BASE_URL + "forecast/" + locationName + "/hourly"));

        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);

        return responseEntity.getBody();
    }

    private HttpHeaders getHttpHeaders() {
        String apiKey = ApiKeyContextHolder.getApiKey();
        String applicationId = ApiKeyContextHolder.getApplicationID();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Application-ID", applicationId);
        headers.set("x-rapidapi-host", RAPID_API_HOST);
        headers.set("x-rapidapi-key", apiKey);
        return headers;
    }
}
