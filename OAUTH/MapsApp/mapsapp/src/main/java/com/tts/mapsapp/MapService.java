package com.tts.mapsapp;

import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.stream.Location;

@Service
public class MapService {
    @Value("${api_key}")
    private String apiKey;


        public void addCoordinates(Location location) {
            String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" +
                    location.getCity() + "," + location.getState() + "&key=" + apiKey;
            RestTemplate restTemplate = new RestTemplate();
            GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
            Location coordinates = response.getResults().get(0).getGeometry().getLocation();
            Location.setLat(coordinates.getLat());
            Location.setLng(coordinates.getLng());

            }
        }