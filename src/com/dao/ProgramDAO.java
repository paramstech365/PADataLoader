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
import com.mongodb.MongoClientURI;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Filters.*;

import org.bson.Document;

public class ProgramDAO {
	
	private MongoClient mongo;
	private MongoDatabase  db ;
	
	public ProgramDAO(MongoClientURI uri){
			
			mongo = new MongoClient(uri);
			db = mongo.getDatabase(uri.getDatabase());
		
	}
	
	public void saveProgram(List<Program> programList ){
		
		MongoCollection<Document> col = db.getCollection("programs");
		List<Document> docList = new ArrayList<>();
		for(Program pro : programList){
			Document doc = Program.createDBObject(pro);
			docList.add(doc);
		}
		col.insertMany(docList); 	 	
	}
	
	public void deleteProgramById(Program pro ){
		
		MongoCollection<Document> col = db.getCollection("programs");
		DeleteResult result = col.deleteOne(eq("_id", new ObjectId(pro.getId())));
		System.out.println("No Of Documents Deleted--"+result.getDeletedCount());
		
		
	}
	
	public List<Program> getProgramsByBatchId(String batchId ){
		
		List<Program> programList = new ArrayList<>();
		MongoCollection<Document> col = db.getCollection("programs");
		MongoCursor<Document> cursor = col.find(eq("batchId",batchId)).iterator();
		try {
		    while (cursor.hasNext()) {
		    	Program pro = Program.createProgram(cursor.next());
		    	programList.add(pro);
		    }
		} finally {
		    cursor.close();
		}
		return programList;
	}
	
	public void closeConnection(){
		
		mongo.close();
		
	}
}
