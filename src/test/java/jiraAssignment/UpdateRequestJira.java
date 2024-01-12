package jiraAssignment;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateRequestJira extends BaseClassJira {
	@Test(dependsOnMethods="jiraAssignment.CreateRequestJira.createJiraRequest")
	public void updateJiraRequest() {
		RequestSpecification input = RestAssured
				.given()
				.contentType("application/json")
				.when()
				.body("{\\r\\n\"\r\n"
						+ "				+ \"    \\\"fields\\\": {\\r\\n\"\r\n"
						+ "				+ \"        \\\"project\\\": {\\r\\n\"\r\n"
						+ "				+ \"            \\\"key\\\": \\\"RES\\\"\\r\\n\"\r\n"
						+ "				+ \"        },\\r\\n\"\r\n"
						+ "				+ \"        \\\"summary\\\": \\\"create issue in Ashwini_Jira project\\\",\\r\\n\"\r\n"
						+ "				+ \"        \\\"description\\\": \\\"Creating of an issue using project keys and issue type names using the REST API\\\",\\r\\n\"\r\n"
						+ "				+ \"        \\\"issuetype\\\": {\\r\\n\"\r\n"
						+ "				+ \"            \\\"name\\\": \\\"Bug\\\"\\r\\n\"\r\n"
						+ "				+ \"        }\\r\\n\"\r\n"
						+ "				+ \"    }\\r\\n\"\r\n"
						+ "				+ \"}");
		Response response = input.put("issue/"+KEY);
		System.out.println(KEY);
		System.out.println("The response for Jira update is " +response.getStatusCode());
		response.then().assertThat().statusCode(400);
		//response.then().assertThat().body("key", Matchers.containsString("RES"));

		
		
		
		
	}

}
