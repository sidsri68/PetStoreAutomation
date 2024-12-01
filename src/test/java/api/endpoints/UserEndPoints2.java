package api.endpoints;



import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {


	//method created for getting URL's from properties file
	static ResourceBundle getURL()
	{
		//To get the routes from propeties file
		ResourceBundle routes = ResourceBundle.getBundle("routes"); // load properties file
		
		return routes;
	}

//to perform CRUD operations
//make methods or variables status so that you can access using classname
	
	public static Response createUser(User payload){
		
		String post_url = getURL().getString("post_url");//since post_url is in string in routes.properties file, return type would be string
		
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
        .body(payload)
        
        .when()
           .post(Routes.post_url); // it will take post_url from "String post_url" above
		
		return response;
	}
	
	public static Response readUser(String username){
		
		String get_url = getURL().getString("get_url");
				
		Response response = given()
		                    .pathParam("Username", username)
        
        .when()
           .get(Routes.get_url);
		
		return response;
	}
     
	public static Response UpdateUser(String username, User payload){
		
		String update_url = getURL().getString("update.url"); //using routes.properties file, we can get the url
		
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", username)
        .body(payload)
        
        .when()
           .put(Routes.update_url);
		
		return response;
	}
	
	public static Response deleteUser(String username){
		Response response = given()
		                    .pathParam("Username", username)
        
        .when()
           .delete(Routes.delete_url);
		
		return response;
	}
}
