package chaining;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseClass {
	public static String sys_id;
	@BeforeClass
	public void baseclassCR() {
				
			//URI
			RestAssured.baseURI="https://dev129263.service-now.com/api/now/table";
			
			//Authorization
			RestAssured.authentication = RestAssured.basic("admin", "yeBq9Su/WC$3");
	}

}
