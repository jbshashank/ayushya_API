package com.example.rest.SpringRest;

import org.json.simple.JSONObject;

public class sampleTestClass {

	public String helloworld(JSONObject dataObject) {
		return "Hello from sample test page to " + dataObject.get("name");
	}
	
}
