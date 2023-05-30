package tek.api.sqa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tek.api.sqa.base.APITestConfig;
import tek.api.utility.EndPoints;

public class DeleteAccountPractice extends APITestConfig {
	@Test
	public void deleteAccount() {
		String token = getValidToken();
		RequestSpecification request = RestAssured.given();
		request.queryParam("primaryPersonId", 8788);
		request.header("Authorization", "Bearer " + token);
		Response response = request.when().delete(EndPoints.DELETE.getValue());
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 200);

	}

}
