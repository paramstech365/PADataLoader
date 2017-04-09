package com;

import java.util.List;

import com.dao.ProgramDAO;
import com.model.Program;
import com.parser.HtmlParser;

public class BatchLoader {
	
	private static final String BATCH_ID = "0cddd974-1205-4ee5-9377-a0a1177dc720";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProgramDAO programDaoStg = new ProgramDAO("padata_stg");
		ProgramDAO programDao = new ProgramDAO("padata");
		try{
			
			List<Program> programList = programDaoStg.getProgramsByBatchId(BATCH_ID);
			for(Program pro : programList){
				programDao.deleteProgramById(pro);
				programDao.saveProgram(pro);
			}
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
