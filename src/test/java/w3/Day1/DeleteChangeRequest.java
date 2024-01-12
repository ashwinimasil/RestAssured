package w3.Day1;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import assertions.BaseClassAssert;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteChangeRequest extends BaseClassAssert{

	@Test(dependsOnMethods="chaining.UpdateChangeRequest.createCR")
	public void deleteCR() {
			
			Response response = RestAssured.delete("change_request/efec939447367150564d1c34836d437d");
			int statusCode = response.getStatusCode();
			System.out.println("The status code is" +statusCode);
			response.then().assertThat().statusCode(Matchers.equalTo(400));
			
}
}