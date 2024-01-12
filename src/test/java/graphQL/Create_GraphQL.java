package graphQL;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Create_GraphQL extends Base_GraphQL {
	@Test
	public void createQuery() {
		RequestSpecification input = RestAssured.given().contentType("application/json").when().body("{\r\n"
				+ "  \"query\": \"query{\\tviewer{ login name followers{ totalCount } repositories{ totalCount } }}\"\r\n"
				+ "}");
		Response response = input.post();
		response.prettyPrint();
		int statusCode = response.statusCode();
		System.out.println("StatusCode is"+statusCode);
	}
}
