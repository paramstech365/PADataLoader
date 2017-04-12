package com;

import java.util.ArrayList;
import java.util.List;

import com.dao.ProgramDAO;
import com.model.Program;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.parser.HtmlParser;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		MongoClientURI uri = new MongoClientURI(Constants.STG_URI);
		ProgramDAO programDao = new ProgramDAO(uri);
		try{
			HtmlParser parser = new HtmlParser();
			List<Program> programList = parser.getProgramList();
			programDao.saveProgram(programList);
			programDao.closeConnection();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			programDao.closeConnection();
		}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
