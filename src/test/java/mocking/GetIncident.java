package mocking;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetIncident {
	@Test
	public void getIncident() {
		RestAssured.baseURI="http://localhost/api/now/table/";
		RestAssured.authentication = RestAssured.basic("admin", "yeBq9Su/WC$3");
		Response response = RestAssured.given().get("change_request");
		response.prettyPrint();
	}
}
