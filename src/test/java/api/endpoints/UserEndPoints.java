package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//to perform CRUD operations
//make methods or variables status so that you can access using classname
public class UserEndPoints {
	
	public static Response createUser(User payload){
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
        .body(payload)
        
        .when()
           .post(Routes.post_url);
		
		return response;
	}
	
	public static Response readUser(String username){
		Response response = given()
		                    .pathParam("Username", username)
        
        .when()
           .get(Routes.get_url);
		
		return response;
	}
     
	public static Response UpdateUser(String username, User payload){
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
