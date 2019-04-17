package com.example.mongoConnect;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongoConnect.models.tickets;
import com.example.mongoConnect.repositories.ticketsRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

@RestController
@RequestMapping("/tickets")
public class ticketsController {
	@Autowired
	private ticketsRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<tickets> getAllTickets(){
		return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<tickets> getTicketById(@PathVariable("id") String id) {
		return repository.findById(id);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public tickets createTicket(@Valid @RequestBody tickets tick) {
		DateFormat dtf = new SimpleDateFormat("dd/MM/yy");
		Date date = new Date();
		String dateStr = dtf.format(date);
		String[] splitDate = dateStr.split("/");
		if(splitDate[0].length() == 1)
			splitDate[0] = "0"+splitDate[0];
		if(splitDate[1].length() == 1)
			splitDate[1] = "0"+splitDate[1];
		long ticketsCount = repository.count();
		String ticketNumber = Long.toString(ticketsCount++);
		if(ticketNumber.length() == 1)
			ticketNumber = "00" + ticketNumber;
		if(ticketNumber.length() == 2)
			ticketNumber = "0" + ticketNumber;
		String tricketNumber = "ATAS"+splitDate[0]+splitDate[1]+splitDate[2] + ticketNumber;
		tick.set_id(tricketNumber);
		repository.save(tick);
		return tick;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyTicket(@PathVariable("id") String id, @Valid @RequestBody tickets tick) {
		tick.set_id(id);
		repository.save(tick);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteTicket(@PathVariable("id") String id) {
		repository.deleteById(id);
		return "DELETED";
	}
	
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.PUT)
	public JSONObject mod(@PathVariable("id") String id, @RequestBody JSONObject tick) {
		MongoClient client = new MongoClient("localhost", 27017);
		DB dbs = client.getDB("ayushya");
		DBCollection collection = dbs.getCollection("tickets");
		BasicDBObject updateObject = new BasicDBObject();
//		System.out.println(tick.customerAddress);
//		System.out.println(tick.customerName);
//		updateObject.append("$set", new BasicDBObject().append("customerAddress", tick.customerAddress));
//		updateObject.append("$set", new BasicDBObject().append("customerName", tick.customerName));
		if(tick.get("customerAddress") != null) {
			updateObject.append("$set", new BasicDBObject().append("customerAddress", tick.get("customerAddress").toString()));
			BasicDBObject old = new BasicDBObject().append("_id", id);
			collection.update(old, updateObject, false, false);
		}
		
		if(tick.get("customerEmail") != null) {
			updateObject.append("$set", new BasicDBObject().append("customerEmail", tick.get("customerEmail").toString()));
			BasicDBObject old = new BasicDBObject().append("_id", id);
			collection.update(old, updateObject, false, false);
		}
			
		
		if(tick.get("customerName") != null) {
			updateObject.append("$set", new BasicDBObject().append("customerName", tick.get("customerName").toString()));
			BasicDBObject old = new BasicDBObject().append("_id", id);
			collection.update(old, updateObject, false, false);
		}
			
		
		if(tick.get("ticketCategory") != null) {
			updateObject.append("$set", new BasicDBObject().append("ticketCategory", tick.get("ticketCategory").toString()));
			BasicDBObject old = new BasicDBObject().append("_id", id);
			collection.update(old, updateObject, false, false);
		}
			
		
		if(tick.get("serialNumber") != null) {
			updateObject.append("$set", new BasicDBObject().append("serialNumber", tick.get("serialNumber").toString()));
			BasicDBObject old = new BasicDBObject().append("_id", id);
			collection.update(old, updateObject, false, false);
		}
			
		
		if(tick.get("product") != null) {
			updateObject.append("$set", new BasicDBObject().append("product", tick.get("product").toString()));
			BasicDBObject old = new BasicDBObject().append("_id", id);
			collection.update(old, updateObject, false, false);
		}
			
		
		if(tick.get("problemDiscription") != null) {
			updateObject.append("$set", new BasicDBObject().append("problemDiscription", tick.get("problemDiscription").toString()));
			BasicDBObject old = new BasicDBObject().append("_id", id);
			collection.update(old, updateObject, false, false);
		}
			
		
		if(tick.get("warrenty") != null) {
			updateObject.append("$set", new BasicDBObject().append("warrenty", tick.get("warrenty").toString()));
			BasicDBObject old = new BasicDBObject().append("_id", id);
			collection.update(old, updateObject, false, false);
		}
			
		
		if(tick.get("brand") != null) {
			updateObject.append("$set", new BasicDBObject().append("brand", tick.get("brand").toString()));
			BasicDBObject old = new BasicDBObject().append("_id", id);
			collection.update(old, updateObject, false, false);
		}
			
		
		if(tick.get("customerPhone") != null) {
			updateObject.append("$set", new BasicDBObject().append("customerPhone", tick.get("customerPhone").toString()));
			BasicDBObject old = new BasicDBObject().append("_id", id);
			collection.update(old, updateObject, false, false);
		}
		
		if(tick.get("locationLat") != null) {
			updateObject.append("$set", new BasicDBObject().append("locationLat", tick.get("locationLat").toString()));
			BasicDBObject old = new BasicDBObject().append("_id", id);
			collection.update(old, updateObject, false, false);
		}
		
		if(tick.get("locationLon") != null) {
			updateObject.append("$set", new BasicDBObject().append("locationLon", tick.get("locationLon").toString()));
			BasicDBObject old = new BasicDBObject().append("_id", id);
			collection.update(old, updateObject, false, false);
		}
		
		if(tick.get("ticketStatus") != null) {
			updateObject.append("$set", new BasicDBObject().append("ticketStatus", tick.get("ticketStatus").toString()));
			BasicDBObject old = new BasicDBObject().append("_id", id);
			collection.update(old, updateObject, false, false);
		}
		
		BasicDBObject old = new BasicDBObject().append("_id", id);
		collection.update(old, updateObject, false, false);
		JSONObject js = new JSONObject();
		js.put("job", "done");
		return js;
	}
}
