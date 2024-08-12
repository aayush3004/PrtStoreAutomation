package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


import api.endpoints.UserEndPoints2;
import api.payload.UserPojo;
import io.restassured.response.Response;

public class UserTestCases2 
{
	
	Faker faker;
	UserPojo userPayload;
	
	public Logger logger; // for logs
	
	//before class this method is run it before the all classes, so we can create faker data. 
	
	@BeforeClass
	public void setUpData()
	{
		faker=new Faker();
		userPayload =new UserPojo();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//log
		logger=LogManager.getLogger(this.getClass());
		
	}
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("*****Creating User*****");
		Response response=UserEndPoints2.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("*****User is Created*****");
	}
	
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		logger.info("*****Read user info*****");
		Response response=UserEndPoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("*****user info displayed*****");
	}
	
	@Test(priority=3)
	public void testUpdateUserByName()
	{
		logger.info("*****updating user*****");
		//Update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=UserEndPoints2.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().body();
	
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("*****user is updated*****");
		
		//clicking data after update
		Response responseAfterUpdate=UserEndPoints2.readUser(this.userPayload.getUsername());	
		Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
		
		
	}
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		logger.info("*****deleting user*****");
		Response response=UserEndPoints2.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),415);
		logger.info("*****user is deleted*****");
	}

}





