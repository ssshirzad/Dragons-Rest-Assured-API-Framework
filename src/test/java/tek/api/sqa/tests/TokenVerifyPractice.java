package tek.api.sqa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tek.api.sqa.base.APITestConfig;
import tek.api.utility.EndPoints;

public class TokenVerifyPractice extends APITestConfig {
	@Test
	public void verifyValidToken() {
		String validToken = getValidToken();
		RequestSpecification request = RestAssured.given();
		request.queryParam("token", validToken);
		request.queryParam("username", "supervisor");
		Response response = request.when().get(EndPoints.TOKEN_VERIFY.getValue());
		Assert.assertEquals(response.getStatusCode(), 200);	
	}
	@Test
	public void InvalidTokenResponseValidation() {
		String InvalidToken = "Token";
		RequestSpecification request = RestAssured.given();
		request.queryParam("token", InvalidToken);
		request.queryParam("username", "supervisor");
		Response response = request.when().get(EndPoints.TOKEN_VERIFY.getValue());
		Assert.assertEquals(response.statusCode(), 400);
		String errorMessage = response.jsonPath().get("errorMessage");
		Assert.assertEquals(errorMessage, "Token Expired or Invalid Token");
	}
	

}
