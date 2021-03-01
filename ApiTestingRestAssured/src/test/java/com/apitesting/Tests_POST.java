package com.apitesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class Tests_POST {

	@Test
	public void Test_01()
	{
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("name","satyanth");
		map.put("job","developer");
		System.out.println(map);
		
		JSONObject jsonObject=new JSONObject(map);
		System.out.println(jsonObject);
		//System.out.println(jsonObject.toJSONString());
		
		JSONObject request=new JSONObject();
		request.put("name", "revanth");
		request.put("job","developer");
		
		System.out.println(request);
		
		given().header("Content-Type","application/json").contentType(ContentType.JSON).body(request.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
	}
	
	@Test
	public void Test_02()
	{
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("name","satyanth");
		map.put("job","developer");
		System.out.println(map);
		
		JSONObject jsonObject=new JSONObject(map);
		System.out.println(jsonObject);
		//System.out.println(jsonObject.toJSONString());
		
		given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).get("https://reqres.in/api/users/2").then().statusCode(200).log().all();
		
		JSONObject request=new JSONObject();
		request.put("name", "revanth");
		request.put("job","developer");
		
		System.out.println(request);
		
		given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	}
	
	@Test
	public void Test_03()
	{
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("name","satyanth");
		map.put("job","developer");
		System.out.println(map);
		
		JSONObject jsonObject=new JSONObject(map);
		System.out.println(jsonObject);
		//System.out.println(jsonObject.toJSONString());
		
		given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).get("https://reqres.in/api/users/2").then().statusCode(200).log().all();
		
		JSONObject request=new JSONObject();
		request.put("name", "revanth");
		request.put("job","developer");
		
		System.out.println(request);
		
		given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	}
	
	@Test
	public void Test_04()
	{
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("name","satyanth");
		map.put("job","developer");
		System.out.println(map);
		
		JSONObject jsonObject=new JSONObject(map);
		System.out.println(jsonObject);
		//System.out.println(jsonObject.toJSONString());
		
		given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).get("https://reqres.in/api/users/2").then().statusCode(200).log().all();
		
		JSONObject request=new JSONObject();
		request.put("name", "revanth");
		request.put("job","developer");
		
		System.out.println(request);
		
		when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	}
	
}
