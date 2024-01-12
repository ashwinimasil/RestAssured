package mocking;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateChangeRequest {

	@Test
	public void createCR() {
		RestAssured.baseURI="http://localhost/api/now/table/";
		RestAssured.authentication = RestAssured.basic("admin", "yeBq9Su/WC$3");
		RequestSpecification input = RestAssured.given().contentType("application/json").when().body("{\r\n"
				+ "    \"short_description\": \"IE not working -- wiremock\"\r\n"
				+ "}");
		Response response = input.post("change_request");
		
		response.prettyPrint();
		
	}
}
