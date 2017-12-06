package com.fullstack.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.springboot.model.Location;
import com.fullstack.springboot.model.LocationSearchResult;
import com.fullstack.springboot.service.AirportService;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Sourabh Suman on 06/12/2017.
 */
@CrossOrigin
@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @Value("${klm.api.timeout}")
    private long timeout;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Location> findAirport(
            @RequestParam(value = "term", required = false, defaultValue = "") String searchString)
            throws ExecutionException, InterruptedException, IOException, TimeoutException {

        Future<LocationSearchResult> locationResponseFuture = airportService.findAirport(searchString);
        LocationSearchResult locationSearchResult = locationResponseFuture.get(timeout, TimeUnit.SECONDS);

        if (locationSearchResult == null) {
            return null;
        }

        List<Location> locations = locationSearchResult.getLocations();

        return locations;
    }
}
