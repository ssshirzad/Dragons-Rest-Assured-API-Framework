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

public class AddPhonePractice extends APITestConfig{
	@Test
	public void addPhone() {
		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("id", "8789");
		requestBody.put("phoneNumber", "565-432-5544");
		requestBody.put("phoneExtension", "222");
		requestBody.put("phoneTime", "Morning");
		requestBody.put("phoneType", "Cell");
		RequestSpecification request = RestAssured.given().body(requestBody);
		String token = getValidToken();
		request.header("Authorization", "Bearer "+token);
		request.contentType(ContentType.JSON);
		Response response = request.when().post(EndPoints.ADD_ACCOUNT_PHONE.getValue());
		Assert.assertEquals(response.statusCode(), 201);
	}

}
