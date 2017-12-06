package apitest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fullstack.springboot.model.Location;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import testutil.HelperMethods;
import testutil.RestUtil;

public class LocationListTest1 {

	private Response res = null; // Response object
	private JsonPath jp = null; // JsonPath object

	@Before
	public void setup() {
		// Test Setup
		RestUtil.setBaseURI("http://localhost:9000/travel"); // Setup Base URI
		RestUtil.setBasePath(""); // Setup Base Path
		RestUtil.path = "airports";
		RestUtil.setContentType(ContentType.JSON); // Setup Content Type
		res = RestUtil.getResponse(); // Get response
		jp = RestUtil.getJsonPath(res); // Get JsonPath
	}

	@Test
	public void T01_StatusCodeTest() {
		HelperMethods.checkStatusIs200(res);
	}

	@Test
	public void T02_LocationCountVerify() {
		assertTrue("Location count is incorrect!", getLocationListCount(res) == 25);
	}

	// Get location count (For use case-2)
	public int getLocationListCount(Response resp) {

		ArrayList<Location> relatedVideoList = jp.get("parent");
		return relatedVideoList.size();
	}

	@After
	public void afterTest() {
		// Reset Values
		RestUtil.resetBaseURI();
		RestUtil.resetBasePath();
	}

}
