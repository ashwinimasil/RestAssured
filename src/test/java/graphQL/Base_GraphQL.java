package graphQL;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;

public class Base_GraphQL {
	@BeforeTest
	public void baseClass() {
		//Baseuri
		RestAssured.baseURI="https://api.github.com/graphql";
		
		//Authentication
		RestAssured.authentication=RestAssured
				.oauth2("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");
		
	}

}
