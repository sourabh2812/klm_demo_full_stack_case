package com.fullstack.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.springboot.model.Metrics;
import com.fullstack.springboot.service.MetricsService;


/**
 * Created by Sourabh Suman on 06/12/2017.
 */
@CrossOrigin
@RestController
@RequestMapping("/custom-metrics")
public class MetricsController {

    @Autowired
    private MetricsService metricsService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Metrics getMetrics() {

        return metricsService.getMetrics();
    }
}
