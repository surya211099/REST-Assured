package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestsOnLocalAPI {
	//@Test
	public void post()
	{
		JSONObject request=new JSONObject();
		request.put("firstName", "VishwaVignesh");
		request.put("LastName","M");
		request.put("subjectId", 3);
		
		baseURI="http://localhost:3000";
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString()).
		when()
			.post("/users").
		then()
			.statusCode(201);
	}
	//@Test
	public void put()
	{
		JSONObject request=new JSONObject();
		request.put("firstName", "VishwaVignesh");
		request.put("LastName","Kohli");
		request.put("subjectId", 3);
		
		baseURI="http://localhost:3000";
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString()).
		when()
			.put("/users/4").
		then()
			.statusCode(200);
	}
	@Test
	public void testDelete()
	{
		baseURI="http://localhost:3000";
		
		when().
			delete("/users/4").
		then().
			statusCode(200)
			.log().all();
	}

}
