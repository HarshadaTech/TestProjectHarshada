package RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import static org.apache.http.HttpStatus.*;
import static io.restassured.http.ContentType.JSON;

import org.testng.annotations.Test;



public class Restassuredmethods1
{

//@Test
void GetUssers()

{
 given()
 
 .when()
 .get("https://api.restful-api.dev/objects")
 
 .then()
 .statusCode(200)
 .log().all();
 


}


//CreateMethod

@Test
void CreateUsers()


{
	Map<String,Object> data = new HashMap<>();
	data.put("year",2025);
	data.put("price",100000);
	data.put("CPU model","Intel i10");
	data.put("Hard disk size","2TB");
	
	Map<String,Object> mainmap= new HashMap<>();
	mainmap.put("name","Harshada");
	mainmap.put("data",data);
	
   given()
   .contentType("application/json")
   .body(mainmap)
   
   .when()
   .post("https://api.restful-api.dev/objects")
   
   
   .then()
   .statusCode(200)
   .log().all()
   .body("data.year",equalTo(2025));
   
   

	
}
}

