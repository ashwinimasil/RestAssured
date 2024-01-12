package assertions;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import assertions.BaseClassAssert;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetCRwithQueryPath extends BaseClassAssert{
	@Test(dependsOnMethods="assertions.CreateCR.createanCR")
	public void getCRwithQuerypath() {
	Response response = RestAssured.given()
			.queryParam("sys_parmfields", "sys_id,assigned_to,short_description,description").get("change_request");	
	response.prettyPrint();
	//sys_id = response.jsonPath().get("result.sys_id");
	//System.out.println(sys_id);
	//dynamic assert
	response.then().assertThat().body("result.sys_id",Matchers.hasItem(sys_id));
	response.then().assertThat().body("result.number",Matchers.hasItem("CHG0000063"));
	}

}
