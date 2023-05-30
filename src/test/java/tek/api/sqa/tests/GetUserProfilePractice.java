package tek.api.sqa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tek.api.sqa.base.APITestConfig;
import tek.api.utility.EndPoints;

public class GetUserProfilePractice extends APITestConfig {
	@Test
	public void getUserProfile() {
		String token = getValidToken();
		RequestSpecification request = RestAssured.given();
		request.queryParam("username", "supervisor");
		request.queryParam("password", "tek_supervisor");
		request.header("Authorization", "Bearer "+token);
		Response response = request.when().get(EndPoints.GET_USER_PROFILE.getValue());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
