package tek.api.sqa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tek.api.sqa.base.APITestConfig;
import tek.api.utility.EndPoints;

public class GetAllAccountPractice extends APITestConfig {
	@Test
	public void getAllAccount() {
		String token = getValidToken();
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token);
		request.contentType(ContentType.JSON);
		Response response = request.when().get(EndPoints.GET_ALL_ACCOUNTS.getValue());
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 200);
		
		
		
	}

}
