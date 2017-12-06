package com.fullstack.springboot.service;

import java.io.IOException;
import java.util.concurrent.Future;

import com.fullstack.springboot.model.Location;
import com.fullstack.springboot.model.LocationSearchResult;

/**
 * Created by Sourabh Suman on 06/12/2017.
 */
public interface AirportService {

	public Future<Location> findAirportByCode(String code);

	public Future<LocationSearchResult> findAirport(String searchString) throws IOException;
}
