package com;

import java.util.List;

import com.dao.ProgramDAO;
import com.model.Program;
import com.parser.HtmlParser;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProgramDAO programDao = new ProgramDAO("padata_stg");
		try{
			HtmlParser parser = new HtmlParser();
			List<Program> programList = parser.getProgramList();
			for(Program pro : programList){
				programDao.saveProgram(pro);
			}
			programDao.closeConnection();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			programDao.closeConnection();
		}
	}

}
