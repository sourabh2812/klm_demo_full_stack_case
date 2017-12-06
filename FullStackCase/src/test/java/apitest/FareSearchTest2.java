package apitest;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import testutil.HelperMethods;
import testutil.RestUtil;

public class FareSearchTest2 {

	private Response res = null; // Response object
	private JsonPath jp = null; // JsonPath object

	@Before
	public void setup() {
		// Test Setup
		RestUtil.setBaseURI("http://localhost:9000/travel"); // Setup Base URI
		RestUtil.setBasePath(""); // Setup Base Path
		RestUtil.path = "fares/AMS/OSL";
		RestUtil.setContentType(ContentType.JSON); // Setup Content Type
		res = RestUtil.getResponse(); // Get response
		jp = RestUtil.getJsonPath(res); // Get JsonPath
	}

	@Test
	public void T01_StatusCodeTest() {
		HelperMethods.checkStatusIs200(res);
	}

	@Test
	public void T02_CheckOriginCode() {

		String origin = jp.get("origin.code");
		assertTrue("Request for origin loc is correct!", origin.equalsIgnoreCase("AMS"));
	}

	@Test
	public void T03_CheckDestinationCode() {
		String dest = jp.get("destination.code");
		assertTrue("Request for destination loc is correct!", dest.equalsIgnoreCase("OSL"));
	}

	@Test
	public void T04_CheckFareForEmpty() {
		Float fare = jp.get("amount");
		assertTrue("Returned fare is not empty/black", fare != 0);
	}

	@After
	public void afterTest() {
		// Reset Values
		RestUtil.resetBaseURI();
		RestUtil.resetBasePath();
	}

}
