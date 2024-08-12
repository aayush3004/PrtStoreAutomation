package api.endpoints;


import org.testng.annotations.Test;

import api.payload.UserPojo;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//UserEndPoints.java
//Created for perform create read update delete request the user API

public class UserEndPoints 
{
	@Test
	public static Response createUser(UserPojo payload)
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				
				.when()
					.post(Routes.post_url);
		
					return response;
				
	}
	
	
	public static Response readUser(String userName)
	{
		Response response=given()
				.pathParam("username",userName)
				
				.when()
					.get(Routes.get_url);
		
					return response;
				
	}
	
	
	public static Response updateUser(String userName, UserPojo payload)
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username",userName)
				.body(payload)
				
				.when()
					.put(Routes.update_url);
		
					return response;
				
	}
	
	public static Response deleteUser(String userName)
	{
		Response response=given()
				.pathParam("username",userName)
				
				.when()
					.put(Routes.delete_url);
					return response;
				
	}
	

}




