package com.dao;

import java.net.UnknownHostException;

import com.model.Program;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class ProgramDAO {
	
	private MongoClient mongo;
	private DB db ;
	
	public ProgramDAO(){
		try{
			mongo = new MongoClient("localhost", 27017);
			db = mongo.getDB("padata");
		}
		catch(UnknownHostException ex){
			ex.printStackTrace();
		}
	}
	
	public void saveProgram(Program pro ){
		
		DBCollection col = db.getCollection("programs");
		DBObject doc = Program.createDBObject(pro);
		WriteResult result = col.insert(doc);
		System.out.println(result.getUpsertedId());
		System.out.println(result.getN());
		
		
	}
	public void closeConnection(){
		
		mongo.close();
		
	}
}
