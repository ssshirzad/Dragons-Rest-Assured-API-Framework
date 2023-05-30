package tek.api.sqa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import tek.api.sqa.base.APITestConfig;
import tek.api.utility.EndPoints;

public class GetAccountTestPractice extends APITestConfig{
	@Test
	public void getAccountwithExistingId() {
		String validToken = getValidToken();
		RequestSpecification request = RestAssured.given();
		request.queryParam("primaryPersonId", 7621);
		request.header("Authorization", "Bearer " + validToken);
		Response response = request.when().get(EndPoints.GET_ACCOUNT.getValue());
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		int primaryPersonId = response.jsonPath().get("primaryPerson.id");
		Assert.assertEquals(primaryPersonId, 7621);
		
	}

}
