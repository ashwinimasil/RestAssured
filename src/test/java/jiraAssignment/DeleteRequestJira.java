package jiraAssignment;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRequestJira extends BaseClassJira {

	@Test(dependsOnMethods="jiraAssignment.CreateRequestJira.createJiraRequest")
	public void deleteJiraRequest() {
		Response response = RestAssured.delete("issue/"+KEY);
		int statusCode = response.getStatusCode();
		System.out.println("The statuscode for DeleteJiraRequest"+statusCode);
		response.then().assertThat().statusCode(Matchers.equalTo(204));
	}
}
