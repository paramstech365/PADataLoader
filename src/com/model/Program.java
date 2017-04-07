package com.model;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class Program {
	
	private String state;
	private String collegeName;
	private String detailsUrl;
	
	public static DBObject createDBObject(Program program) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("state", program.getState());
		docBuilder.append("collegeName", program.getCollegeName());
		docBuilder.append("detailsUrl", program.getDetailsUrl());
		return docBuilder.get();
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getDetailsUrl() {
		return detailsUrl;
	}
	public void setDetailsUrl(String detailsUrl) {
		this.detailsUrl = detailsUrl;
	}
	
}
