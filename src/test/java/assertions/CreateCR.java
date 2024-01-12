package assertions;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class CreateCR extends BaseClassAssert{
	@Test 
public void createanCR() {
		
		//Form Basic body
		RequestSpecification input = RestAssured.given().contentType("application/json").when().body("{\r\n"
				+ "    \"short_description\": \"IE not working\"\r\n"
				+ "}");
		Response response = input.post("change_request");
		
		response.prettyPrint();
		
		int statusCode =  response.getStatusCode();
		System.out.println(statusCode);
		sys_id = response.jsonPath().get("result.sys_id");
		System.out.println(sys_id);
		response.then().assertThat().statusCode(Matchers.equalTo(201));
		response.then().assertThat().body("result.number",Matchers.containsString("CHG"));
		
	
		
}
	
}
