package mocking;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import assertions.BaseClassAssert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateCR extends BaseClassAssert {
	
	@Test(dependsOnMethods="chaining.CreateCR.createanCR")
	public void updateCR() {
			//Form the request
			RequestSpecification input = RestAssured.given().contentType("application/json")
					.when()
					.body("{\r\n"
					+ "    \"short_description\": \"LAN cable Replacement - updated for Put CR \"\r\n"
					+ "}");
			//send the request
			Response response = input.put("change_request/"+sys_id);
			System.out.println("The system id is"+sys_id);
			
			//response.prettyPrint();
			System.out.println("The response for CR update is " +response.getStatusCode());
			//response.then().assertThat().statusCode(Matchers.equalTo(200));
			
}
}