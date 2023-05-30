package tek.api.sqa.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.HashMap;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tek.api.sqa.base.APITestConfig;
import tek.api.utility.EndPoints;

public class SecurityTestPractice extends APITestConfig{
	
	@Test
	public void tokenWithValidDataTest() {
		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("username", "supervisor");
		requestBody.put("password", "tek_supervisor");
		RequestSpecification request = RestAssured.given().body(requestBody);
		request.contentType(ContentType.JSON);
		Response response = request.when().post(EndPoints.TOKEN_GENERATION.getValue());
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		String GeneratedToken = response.jsonPath().get("token");
		Assert.assertNotNull(GeneratedToken);
			
	}
	@Test(dataProvider = "invalidTokenData")
	public void tokenWithInvalidDataTest(String username, String password, String expectedErrorMessage) {
		
		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("username", username);
		requestBody.put("password", password);
		RequestSpecification request = RestAssured.given().body(requestBody);
		request.contentType(ContentType.JSON);
		Response response = request.when().post(EndPoints.TOKEN_GENERATION.getValue());
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 400);
		String errorMessage = response.jsonPath().get("errorMessage");
		Assert.assertEquals(errorMessage, expectedErrorMessage);
	
	}
	@DataProvider(name = "invalidTokenData")
	private Object[][] invalidTokenData(){
		Object[][] data = {
				{"WrongUser", "tek_supervisor", "User not found"},
				{"supervisor", "WrongPassword", "Password Not Matched"}
		};
		return data;
		}
	}
	


