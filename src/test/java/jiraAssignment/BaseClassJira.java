package jiraAssignment;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseClassJira {
	public static String KEY;
	@BeforeClass
	public void baseClassJira() {
		//End point url		
		RestAssured.baseURI="https://ashwinimasil.atlassian.net/rest/api/2/";
		
		//Authentication
		RestAssured.authentication=RestAssured.preemptive().basic("ashwinimasil@gmail.com",
				"ATATT3xFfGF0Bm3EKzVSYVnrIJJVom6VqmQkM_S0XbSWSWAeRKvExDkmR8wu7bxgNBqFPJPy17UMiOinAYrHEYvYX_vA7VQD_m34vcam6l8ygaYm3tO_LMCh2ExfPpbteoBIJmDW86CiSTlRVlTel69DfPw1CuqMzvFSBUs7PuyE6XcrLyKovl8=45A0FE67");
	}

}
