package com.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.model.Program;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class ProgramDAO {
	
	private MongoClient mongo;
	private DB db ;
	
	public ProgramDAO(String dbName){
		try{
			mongo = new MongoClient("localhost", 27017);
			db = mongo.getDB(dbName);
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
	
	public void deleteProgramById(Program pro ){
		
		DBCollection col = db.getCollection("programs");
		BasicDBObject query=new BasicDBObject("_id",new ObjectId(pro.getId()));
		WriteResult result = col.remove(query);
		System.out.println("Deleted--"+result.getN());
		
		
	}
	
	public List<Program> getProgramsByBatchId(String batchId ){
		
		List<Program> programList = new ArrayList<>();
		DBCollection col = db.getCollection("programs");
		DBObject query = BasicDBObjectBuilder.start().add("batchId", batchId).get();
		DBCursor results = col.find(query);
		for (DBObject result : results) {
		    // do something with each result
			Program pro = Program.createProgram(result);
			programList.add(pro);
		}
		return programList;
	}
	
	public void closeConnection(){
		
		mongo.close();
		
	}
}
