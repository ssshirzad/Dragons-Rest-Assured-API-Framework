package tek.api.sqa.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tek.api.sqa.base.APITestConfig;
import tek.api.utility.EndPoints;

public class AddPrimaryAccountPractice extends APITestConfig{
	@Test
	public void addPrimaryAccount() {
		Map<String, String> requestBody = new HashMap<>();
		String token = getValidToken();
		requestBody.put("email", "Yahya12@gmail.com");
		requestBody.put("firstName", "Yahya");
		requestBody.put("lastName", "Dawood");
		requestBody.put("title", "Mr.");
		requestBody.put("gender", "MALE");
		requestBody.put("maritalStatus", "MARRIED");
		requestBody.put("employmentStatus", "Working");
		requestBody.put("dateOfBirth", "2000-12-12");
		RequestSpecification request = RestAssured.given().body(requestBody);
		request.header("Authorization", "Bearer "+token);
		request.contentType(ContentType.JSON);
		Response response = request.when().post(EndPoints.ADD_PRIMARY_ACCOUNT.getValue());
		Assert.assertEquals(response.statusCode(), 201);
	
		
		
	}

}
