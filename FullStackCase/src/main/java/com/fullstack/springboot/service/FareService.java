package com.fullstack.springboot.service;

import java.util.concurrent.Future;

import com.fullstack.springboot.model.FareResponse;


/**
 * Created by Sourabh Suman on 06/12/2017.
 */
public interface FareService {

    public Future<FareResponse> findFare(String origin, String destination);
}
