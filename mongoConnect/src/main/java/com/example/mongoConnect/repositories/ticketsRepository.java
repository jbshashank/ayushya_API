package com.example.mongoConnect.repositories;

import com.example.mongoConnect.models.tickets;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ticketsRepository extends MongoRepository<tickets, String>{
	tickets findBy_id(ObjectId _id);
}
