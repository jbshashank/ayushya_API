package com.example.rest.SpringRest;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.Lists;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MySQLconnection {
	
	private String test;
	
	public void connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/ayushya", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("SELECT * FROM Customer_Info");
			while(rst.next()) {
				System.out.println(rst.getInt(1));
				System.out.println(rst.getString(2));
				System.out.println(rst.getString(3));
				System.out.println(rst.getString(4));
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public String FirebaseConn() {
		try {
			GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("/Users/ShreyasGS/.config/gcloud/application_default_credentials.json"))
					.createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
			System.out.println("Succeffuly created credentials");
			FirebaseOptions options = new FirebaseOptions.Builder()
				    .setCredentials(GoogleCredentials.getApplicationDefault())
				    .setDatabaseUrl("https://trialchat-40e06.firebaseio.com/")
				    .build();

			FirebaseApp.initializeApp(options);
			
			DatabaseReference rootref = FirebaseDatabase.getInstance().getReference();
			rootref.addListenerForSingleValueEvent(new ValueEventListener() {
				
				public void onDataChange(DataSnapshot snapshot) {
					test = snapshot.child("test").getValue().toString();
					System.out.println(test);
				}
				
				public void onCancelled(DatabaseError error) {
					// TODO Auto-generated method stub
					
				}
			});
			return test;
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "No connection found";
	}

}
