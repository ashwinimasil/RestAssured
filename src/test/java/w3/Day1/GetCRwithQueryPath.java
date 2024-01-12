package w3.Day1;

import org.testng.annotations.Test;

import assertions.BaseClassAssert;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetCRwithQueryPath extends BaseClassAssert{
	@Test
	public void getCRwithQuerypath() {
	Response response = RestAssured.given()
			.queryParam("sys_parmfields", "sys_id,assigned_to,short_description,description").get("change_request");	
	response.prettyPrint();
	}

}
