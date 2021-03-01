package com.apitesting;


import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class DummyApi {
	
	
	@Test
	public void test_01()
	{
		baseURI="http://localhost:3000/";
		
		given().get("/users").then().statusCode(200).log().all();
	}
	
	@Test
	public void test_02()
	{
		baseURI="http://localhost:3000/";
		
		given().param("subject","Automation").get("/subjects").then().statusCode(200).log().all();
	}
	
	@Test
	public void test_03_post()
	{
		baseURI="http://localhost:3000";
		
		
		JSONObject jsonObject=new JSONObject();
		
		jsonObject.put("firstname","charan");
		jsonObject.put("lastname","Kuppili");
		jsonObject.put("subjectId",2);
		jsonObject.put("id",4);
		
		
		given().header("content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(jsonObject.toJSONString()).when().post("/users").then().statusCode(201).log().all();
		
	}
	
	@Test
	public void test_04_patch()
	{
		baseURI="http://localhost:3000";
		
		
		JSONObject jsonObject=new JSONObject();
		
		jsonObject.put("lastname","Challa");
	
		
		
		given().header("content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(jsonObject.toJSONString()).when().patch("/users/3").then().statusCode(200).log().all();
		
	}

}
