package java;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.asynchttpclient.Response;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

public class testRestAssured extends TestBase {
	

	

	@Test
	public void testResponStatus() {
		 io.restassured.response.Response resp =  httprequest.get("people");
		 resp.then().statusCode(200);
	}
	@Test
	public void testHeight() {
		  io.restassured.response.Response resp =  httprequest.get("people");
          JsonPath jsonResponse = resp.jsonPath();

        //  System.out.println(jsonResponse.get("results.height")+"hereeeeee");
          ArrayList<Integer> heightList = jsonResponse.get("results.height");
         // int arr[]=jsonResponse.get("results.height");
          System.out.println(heightList);
             int count=0;
          for (Integer var : heightList) 
          { 
        	
              if (var>=200) {
            	  count++;
              }
          }
          assertTrue(count==10);
        
	}
	@Test
	public void returnedNames() {
		  io.restassured.response.Response resp =  httprequest.get("people");
          JsonPath jsonResponse = resp.jsonPath();

       
          ArrayList<String> names = jsonResponse.get("results.name");
          String[] GivenNames = {"Darth Vader", "Chewbacca", "Roos Tarpals", "Rugor Nass", "Yarael Poof", "Lama Su", "Tuan Wu", "Grievous", "Tarfful", "Tion Medon"};
          System.out.println(names);
             int count=0;
             boolean condition= true;
          for (String var : GivenNames) 
          { 
        	  System.out.println(var);
        	  if (names.contains(var)==false) {
                 condition = false;
                 break;
              }
              }
          assertTrue(condition);
          }
	@Test
	public void peopleChecked() {
		io.restassured.response.Response resp =  httprequest.get("people");
        JsonPath jsonResponse = resp.jsonPath();
        Integer checked = jsonResponse.get("count");
        assertTrue(checked==82);
	}
	
}
