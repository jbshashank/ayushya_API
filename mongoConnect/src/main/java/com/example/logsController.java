package com.example.mongoConnect;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;


@RestController
@RequestMapping("/logs")
public class logsController {

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String joke(@PathVariable("id") String id, @RequestBody JSONObject logDetails) {
		MongoClient client = new MongoClient("localhost", 27017);
		DB dbs = client.getDB("ayushya");
		try {
			DBCollection collection = dbs.createCollection("EngineerLogs", new BasicDBObject());
		}catch(Exception e){
			System.out.println("collection exists");
		}
		DateFormat dtf = new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		Date date = new Date();
		String dateStr = dtf.format(date);
		DBCollection logsCollection = dbs.getCollection("EngineerLogs");
		BasicDBObject newObject = new BasicDBObject();
		long logsCount = logsCollection.count();
		newObject.put("_id", "log_" + Long.toString(logsCount++));
		newObject.put("type", "Logging Module");
		newObject.put("updated", dateStr);
		BasicDBObject detailsObject = new BasicDBObject();
		detailsObject.put("Action", logDetails.get("Action"));
		detailsObject.put("Result", logDetails.get("Result"));
		detailsObject.put("Initiator", logDetails.get("Initiator"));
		detailsObject.put("Responder", logDetails.get("Responder"));
		newObject.put("Details", detailsObject);
		logsCollection.insert(newObject);
		String resp = "Data Inserted";
		return resp;
	}

}
