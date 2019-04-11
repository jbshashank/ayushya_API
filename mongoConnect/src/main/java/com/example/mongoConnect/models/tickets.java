package com.example.mongoConnect.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class tickets {
	
	@Id
	public String _id;
	public String ticketCategory;
	public String customerName;
	public String customerEmail;
	public String customerPhone;
	public String serialNumber;
	public String product;
	public String problemDiscription;
	public String customerAddress;
	public String warrenty;
	public String brand;
	public String locationLat;
	public String locationLon;
	public String ticketStatus;
	
	public tickets() {
		
	}

	public tickets(String _id, String ticketCategory, String customerName, String customerEmail, String customerPhone,
			String serialNumber, String product, String problemDiscription, String customerAddress, String warrenty,
			String brand, String locationLat, String locationLon, String ticketStatus) {
		super();
		this._id = _id;
		this.ticketCategory = ticketCategory;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.serialNumber = serialNumber;
		this.product = product;
		this.problemDiscription = problemDiscription;
		this.customerAddress = customerAddress;
		this.warrenty = warrenty;
		this.brand = brand;
		this.locationLat = locationLat;
		this.locationLon = locationLon;
		this.ticketStatus = ticketStatus;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getTicketCategory() {
		return ticketCategory;
	}

	public void setTicketCategory(String ticketCategory) {
		this.ticketCategory = ticketCategory;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProblemDiscription() {
		return problemDiscription;
	}

	public void setProblemDiscription(String problemDiscription) {
		this.problemDiscription = problemDiscription;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getWarrenty() {
		return warrenty;
	}

	public void setWarrenty(String warrenty) {
		this.warrenty = warrenty;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getLocationLat() {
		return locationLat;
	}

	public void setLocationLat(String locationLat) {
		this.locationLat = locationLat;
	}

	public String getLocationLon() {
		return locationLon;
	}

	public void setLocationLon(String locationLon) {
		this.locationLon = locationLon;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	
	
	
}
