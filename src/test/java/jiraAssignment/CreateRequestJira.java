package jiraAssignment;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateRequestJira extends BaseClassJira{
	@Test
	public void createJiraRequest() {

		//Request body
		RequestSpecification input = RestAssured
				.given()
				.contentType("application/json")
				.when()
				.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"project\": {\r\n"
				+ "            \"key\": \"RES\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \"create issue in Ashwini_Jira project\",\r\n"
				+ "        \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
				+ "        \"issuetype\": {\r\n"
				+ "            \"name\": \"Bug\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}");		
		Response response = input.post("issue/");
		
		response.prettyPrint();

		
		  int statusCode = response.statusCode(); 
		  KEY = response.jsonPath().get("key");
		  System.out.println("The status code for creating an issue in Jira"+statusCode); 
		  System.out.println("The project key is"+KEY);
		 
		response.then().assertThat().statusCode(201);
		response.then().assertThat().body("key",Matchers.containsString("RES"));

	}

}

