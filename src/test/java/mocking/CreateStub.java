package mocking;

import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.client.WireMock;

@Test
public class CreateStub {
	public void createStub() {
		WireMock.stubFor(WireMock.post("/api/now/table/change_request")
		.willReturn(WireMock.aResponse()
		.withStatus(201)
		.withBody("{\r\n"
				+ "    \"short_description\": \"IE not working-- wiremock\"\r\n"
				+ "}")));
		
	}

}
