package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class GetAndPostExamples {
	//@Test
	public void testGet()
	{
		baseURI="https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[2].first_name",equalTo("Tobias")).
			body("data.first_name",hasItems("Michael","Byrn"));
	}
	@Test
	public void testPost()
	{
		JSONObject request=new JSONObject();
		request.put("name", "Sasi");
		request.put("job", "Driver");
		baseURI="https://reqres.in/api";
		given().
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201)
			.log().all();
	}
}
