package api.endpoints;


import org.testng.annotations.Test;

import api.payload.UserPojo;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


//UserEndPoints.java
//Created for perform create read update delete request the user API

public class UserEndPoints2 
{
	//method created for getting url's from properties file
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes"); //load properties file
		return routes;
	}
	
	@Test
	public static Response createUser(UserPojo payload)
	{
		
		String post_url=getURL().getString("post_url");
		
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				
				.when()
					.post(post_url);
					//.post(Routes.post_url);
		
					return response;
				
	}
	
	
	public static Response readUser(String userName)
	{
		String get_url=getURL().getString("get_url");
		
		Response response=given()
				.pathParam("username",userName)
				
				.when()
					.get(get_url);
					//.get(Routes.get_url);
		
					return response;
				
	}
	
	
	public static Response updateUser(String userName, UserPojo payload)
	{
		String update_url=getURL().getString("update_url");
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username",userName)
				.body(payload)
				
				.when()
					.put(update_url);
					//.put(Routes.update_url);
		
					return response;
				
	}
	
	public static Response deleteUser(String userName)
	{
		String delete_url=getURL().getString("delete_url");
		Response response=given()
				.pathParam("username",userName)
				
				.when()
					.put(delete_url);
					return response;
				
	}
	

}




