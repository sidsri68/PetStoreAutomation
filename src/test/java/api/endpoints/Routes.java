package api.endpoints;

/*               --------------------BaseURL->   
 Swagger URI --> https://petstore.swagger.io
                       <--------------base url---><endpoint>
 Create user(Post) --> https://petstore.swagger.io/v2/user
 Get User(Get): https://petstore.swagger.io/v2/user/{username}
 Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}
 */
public class Routes {

	//user module
   public static String base_url = "https://petstore.swagger.io/v2"; //-- v2 is common & doesn't change so included in base url
   //initally, we have to create username and then pass it to other request
   public static String post_url = base_url+"/user";
   
   public static String get_url = base_url+"/user/{username}";
   public static String update_url = base_url+"/user/{username}";
   public static String delete_url = base_url+"/user/{username}";
   
   //store module
      //here you can create store module urls
   
   //Pet module
      //here you will create pet module url's
   
   
   
}
