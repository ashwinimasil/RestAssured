package w3.Day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import assertions.BaseClassAssert;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetCRwithQuerypaths extends BaseClassAssert {
	@Test
	public void getCRWithQPS() {
		/*Response response = RestAssured.given().queryParams("sysparm_fields", "sys_id,assigned_to,short_description,description")
		.queryParams("sysparm_limit","3")
		.get("change_request");
		response.prettyPrint();*/
		
		Map<String, String> map = new HashMap<String, String>();
map.put("sysparm_fields", "sys_id,assigned_to,short_description,description");
map.put("sysparm_limit","5");

Response response = RestAssured.given().queryParams(map).get("change_request");
response.prettyPrint();
		
		
		
		
	}

}
