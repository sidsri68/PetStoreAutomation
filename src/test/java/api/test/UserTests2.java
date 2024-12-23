package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {


	//user faker to get the data and pass to pojo class 
	
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setupData()
	{
	   faker = new Faker();
	   userPayload = new User();
	
	   userPayload.setId(faker.idNumber().hashCode());
	   userPayload.setUsername(faker.name().username());
	   userPayload.setFirstName(faker.name().firstName());
	   userPayload.setLastName(faker.name().lastName());
	   userPayload.setEmail(faker.internet().safeEmailAddress());
	   userPayload.setPassword(faker.internet().password(5,10));
	   userPayload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority=1)
	
	public void testPostUser()
	{
		Response response = UserEndPoints2.createUser(userPayload); //import package from restassured only.
		response.then().log().all();
		
		//to get the status code use Assert method.
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		 Response response = UserEndPoints2.readUser(this.userPayload.getUsername());
	       
		 response.then().log().all();
		 
		 Assert.assertEquals(response.statusCode(),200);
	}
	
	@Test(priority=3)
	public void testUpdateUserByName()
	{
		 //update data using payload
		 userPayload.setFirstName(faker.name().firstName());
		 userPayload.setLastName(faker.name().lastName());
		 userPayload.setEmail(faker.internet().safeEmailAddress());
		 
		 
		 Response response = UserEndPoints2.UpdateUser(this.userPayload.getUsername(), userPayload);
		 response.then().log().all();
		 
		 //assertion can also be written like
		// response.then().log().body().statusCode(200);
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
		 
		 //Checking data after update
		 
		 Response resp = UserEndPoints.readUser(this.userPayload.getUsername());
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
		
	}
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		 Response response = UserEndPoints2.deleteUser(this.userPayload.getUsername());
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
	}
}
