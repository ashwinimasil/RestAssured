package w3.Day1;

import java.io.File;

import org.testng.annotations.Test;

import assertions.BaseClassAssert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateCRwithFilebody extends BaseClassAssert {
	
	@Test
	public void createCRWithFileBody() {
		File file = new File("./src/test/resources/Week3.RestAssured/Datafile.json");
		RequestSpecification input = RestAssured
		.given()
		.contentType("application/json")
		.when()
		.body(file);
		
		Response response = input.post("change_request");
		response.prettyPrint();
		
	}

}
