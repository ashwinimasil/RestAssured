package schemaValidation;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class CreateCR extends Cookie{
	
	@Test 
public void createanCR() {
		
		RequestSpecification input = RestAssured.given().contentType("application/json").when().body("{\r\n"
				+ "    \"short_description\": \"IE not working -- wiremock\"\r\n"
				+ "}");
		Response response = input.post("change_request");
		File schema = new File("./src/test/resources/Schema.json");
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schema));
		
		response.prettyPrint();
		
}
	
}
