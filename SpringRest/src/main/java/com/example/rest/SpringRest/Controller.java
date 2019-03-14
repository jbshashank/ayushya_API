package com.example.rest.SpringRest;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String HelloWorld(@RequestParam(value = "name", defaultValue = "world") String name) {
		MySQLconnection con = new MySQLconnection();
		name = con.FirebaseConn();
		return "<h1>Hello " + name + "!</h1>";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String HelloWorld2(@RequestBody String name) {
		System.out.println(name);
		return "hello " + name + "";
	}
	
	@RequestMapping(value = "/json", method = RequestMethod.POST)
	public String JsonPlayGround(@RequestBody JSONObject sample) {
		sampleTestClass stc = new sampleTestClass();
		String retValue = stc.helloworld(sample);
		return retValue;
	}
	
}
