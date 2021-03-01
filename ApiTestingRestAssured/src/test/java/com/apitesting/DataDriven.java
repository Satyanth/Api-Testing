package com.apitesting;


import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDriven {

	
	@DataProvider(name="dataPost")
	public Object[][] dataProvider()
	{
		Object[][] data=new Object[2][4];
		
		data[0][0]="bhargav";
		data[0][1]="krishna";
		data[0][2]=2;
		data[0][3]=4;
		
		data[1][0]="vamsi";
		data[1][1]="bochu";
		data[1][2]=2;
		data[1][3]=5;
		
		return data;
		
//		return new Object[][] 
//		{
//			{"sample","data"},
//			{
//				"damn","crazy"
//			}
//		};
		
	}
	
	//@Parameters({"userid"})-->gets the value from testng.xml
	@Test(dataProvider="dataPost")
	public void test_01(String firstname,String lastname,int subjectid,int id)
	{
		JSONObject jsonObj=new JSONObject();
		
		baseURI="http://localhost:3000";
		
		jsonObj.put("firstname", firstname);
		jsonObj.put("lastname", lastname);
		jsonObj.put("subjectId",subjectid);
		jsonObj.put("id",id);
		
		given().header("content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(jsonObj.toJSONString()).when().post("/users").then().statusCode(201).log().all();
		
	}
}
