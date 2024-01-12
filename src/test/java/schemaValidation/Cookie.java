package schemaValidation;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Cookie {
	
	public static String cookie;
	@BeforeTest
	public void cookie() {
RestAssured.baseURI="https://dev129263.service-now.com/api/now/table/";

RestAssured.authentication = RestAssured.basic("admin", "yeBq9Su/WC$3");
		
		RequestSpecification input = RestAssured.given()
				.queryParam("sysparm_fields", "sys_id,assigned_to,short_description,description")
				.contentType("application/json")
				.cookie("JSESSIONID",cookie)
				.when()
				.body("{\r\n"
						+ "    \"short_description\": \"IE not working\"\r\n"
						+ "}");
		 
		Response response = input.post("change_request");
		cookie = response.getCookie("JSESSIONID");
	response.prettyPrint();
				
	}

}
