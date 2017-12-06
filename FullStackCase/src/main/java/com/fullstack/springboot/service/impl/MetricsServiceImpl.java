package com.fullstack.springboot.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.MetricsEndpoint;
import org.springframework.stereotype.Service;

import com.fullstack.springboot.model.Metrics;
import com.fullstack.springboot.service.MetricsService;

/**
 * Created by Sourabh Suman on 06/12/2017.
 */
@Service
public class MetricsServiceImpl implements MetricsService {

	@Autowired
	private MetricsEndpoint metricsEndpoint;

	@Override
	public Metrics getMetrics() {

		Metrics metrics = new Metrics();

		Set<Map.Entry<String, Object>> metricSet = metricsEndpoint.invoke().entrySet();

		metrics.setNumberOfRequests(sum(metricSet, "counter.status."));
		metrics.setNumberOfRequestsOK(sum(metricSet, "counter.status.2"));
		metrics.setNumberOfRequests4xx(sum(metricSet, "counter.status.4"));
		metrics.setNumberOfRequests5xx(sum(metricSet, "counter.status.5"));
		metrics.setMinResponseTime(get(metricSet, "gauge.response.min"));
		metrics.setMaxResponseTime(get(metricSet, "gauge.response.max"));
		metrics.setAverageResponseTime(get(metricSet, "gauge.response.total"));
		if (metrics.getNumberOfRequests() > 0) {
			metrics.setAverageResponseTime(metrics.getAverageResponseTime() / metrics.getNumberOfRequests());
		}

		return metrics;
	}

	private long get(Set<Map.Entry<String, Object>> metricSet, String prefix) {
		List<Map.Entry<String, Object>> list = metricSet.stream().filter(byPrefix(prefix)).collect(Collectors.toList());
		if (!list.isEmpty()) {
			return toLong(list.get(0));
		}
		return 0;
	}

	private int sum(Set<Map.Entry<String, Object>> metricSet, String prefix) {
		return metricSet.stream().filter(byPrefix(prefix)).mapToInt(value -> toInt(value)).sum();
	}

	private static Predicate<Map.Entry<String, Object>> byPrefix(String prefix) {
		return e -> e.getKey().startsWith(prefix);
	}

	private static int toInt(Map.Entry<String, Object> entry) {
		return Integer.parseInt(entry.getValue().toString());
	}

	private static long toLong(Map.Entry<String, Object> entry) {
		return (long) Double.parseDouble(entry.getValue().toString());
	}
}