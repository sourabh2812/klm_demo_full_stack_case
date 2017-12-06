package com.fullstack.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;

/**
 * Created by Sourabh Suman on 06/12/2017.
 */
@JsonSerializableSchema
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metrics {

	private int numberOfRequests;
	private int numberOfRequestsOK;
	private int numberOfRequests4xx;
	private int numberOfRequests5xx;
	private long averageResponseTime;
	private long minResponseTime;
	private long maxResponseTime;

	public int getNumberOfRequests() {
		return numberOfRequests;
	}

	public void setNumberOfRequests(int numberOfRequests) {
		this.numberOfRequests = numberOfRequests;
	}

	public int getNumberOfRequestsOK() {
		return numberOfRequestsOK;
	}

	public void setNumberOfRequestsOK(int numberOfRequestsOK) {
		this.numberOfRequestsOK = numberOfRequestsOK;
	}

	public int getNumberOfRequests4xx() {
		return numberOfRequests4xx;
	}

	public void setNumberOfRequests4xx(int numberOfRequests4xx) {
		this.numberOfRequests4xx = numberOfRequests4xx;
	}

	public int getNumberOfRequests5xx() {
		return numberOfRequests5xx;
	}

	public void setNumberOfRequests5xx(int numberOfRequests5xx) {
		this.numberOfRequests5xx = numberOfRequests5xx;
	}

	public long getAverageResponseTime() {
		return averageResponseTime;
	}

	public void setAverageResponseTime(long averageResponseTime) {
		this.averageResponseTime = averageResponseTime;
	}

	public long getMinResponseTime() {
		return minResponseTime;
	}

	public void setMinResponseTime(long minResponseTime) {
		this.minResponseTime = minResponseTime;
	}

	public long getMaxResponseTime() {
		return maxResponseTime;
	}

	public void setMaxResponseTime(long maxResponseTime) {
		this.maxResponseTime = maxResponseTime;
	}

	@Override
	public String toString() {
		return "Metrics{" + "numberOfRequests=" + numberOfRequests + ", numberOfRequestsOK=" + numberOfRequestsOK
				+ ", numberOfRequests4xx=" + numberOfRequests4xx + ", numberOfRequests5xx=" + numberOfRequests5xx
				+ ", averageResponseTime=" + averageResponseTime + ", minResponseTime=" + minResponseTime
				+ ", maxResponseTime=" + maxResponseTime + '}';
	}
}
