package com;

import java.util.List;

import com.dao.ProgramDAO;
import com.model.Program;
import com.mongodb.MongoClientURI;
import com.parser.HtmlParser;

public class BatchLoader {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClientURI stg_uri = new MongoClientURI(Constants.STG_URI);
		MongoClientURI uri = new MongoClientURI(Constants.PRD_URI);
		ProgramDAO programDaoStg = new ProgramDAO(stg_uri);
		ProgramDAO programDao = new ProgramDAO(uri);
		try{
			
			List<Program> programList = programDaoStg.getProgramsByBatchId(Constants.BATCH_ID);
			for(Program pro :programList){
				programDaoStg.deleteProgramById(pro);
			}
			if(programList.size() > 0)
				programDao.saveProgram(programList);
			programDaoStg.closeConnection();
			programDao.closeConnection();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			programDaoStg.closeConnection();
			programDao.closeConnection();
		}
	}

}
