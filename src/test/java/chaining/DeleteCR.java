package chaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import assertions.BaseClassAssert;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteCR extends BaseClassAssert{

	@Test(dependsOnMethods="chaining.UpdateCR.updateCR")
	public void deleteCR() {
			
			Response response = RestAssured.delete("change_request/"+sys_id);
			int statusCode = response.getStatusCode();
			System.out.println("The system id is"+sys_id);
			System.out.println("The status code is" +statusCode);
			response.then().assertThat().statusCode(Matchers.equalTo(204));
			
}
}