package w3.Day1;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import assertions.BaseClassAssert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateChangeRequest extends BaseClassAssert {
	
	@Test(dependsOnMethods="chaining.CreateChangeRequest.createCR")
	public void updateCR() {
						
			RequestSpecification input = RestAssured
					.given()
					.contentType("application/json")
					.when()
					.body("{\r\n"
					+ "    \"short_description\": \"LAN cable Replacement - updated for Put CR \"\r\n"
					+ "}");
			Response response = input.put("change_request/efec939447367150564d1c34836d437d");
			response.prettyPrint();
			System.out.println("The response for CR update is " +response.getStatusCode());
			response.then().assertThat().statusCode(Matchers.equalTo(201));
}
}