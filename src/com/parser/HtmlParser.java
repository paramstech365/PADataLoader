package com.parser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import com.model.Program;

public class HtmlParser {

	public List<Program> getProgramList() {
		// TODO Auto-generated method stub
		
		String url = "http://directory.paeaonline.org/";
		List<Program> programList = new ArrayList<>();
		try{
			Document doc = Jsoup.connect(url).get();
			Elements links = doc.select("table");
			FileOutputStream fileOut = new FileOutputStream("programList.xls");
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet worksheet = workbook.createSheet("Programs");
			int rowNum = 0;
			for (Element table : links) {
		         for (Element row : table.select("tr")) {
		             Elements tds = row.select("td");
		             if (tds.size() > 2) {
		            	 Program header = new Program();
		            	 header.setCollegeName(tds.get(0).text());
		            	 header.setState(tds.get(1).text());
		            	
		                 System.out.println(tds.get(0).text() + ":" + tds.get(1).text());
		                 Elements el = tds.get(0).getElementsByTag("a");
		                 System.out.println("http://directory.paeaonline.org"+el.attr("href"));
		                 header.setDetailsUrl("http://directory.paeaonline.org"+el.attr("href"));
		                 programList.add(header);
		                 
		                 HSSFRow row1 = worksheet.createRow(rowNum++);
		                 HSSFCell cellA1 = row1.createCell((short) 0);
		     			cellA1.setCellValue(header.getCollegeName());
		     			HSSFCell cellb1 = row1.createCell((short) 1);
		     			cellb1.setCellValue(header.getState());
		     			HSSFCell cellc1 = row1.createCell((short) 2);
		     			cellc1.setCellValue(header.getDetailsUrl());
		                 
		                 /*Document detailsDoc = Jsoup.connect(header.getDetailsUrl()).get();
		                 for (Element tab : detailsDoc.select("table")) {
		    		         for (Element tabRow : tab.select("tr")) {
		    		             Elements tabDat = tabRow.select("td");
		    		             if (tabDat.size() > 0) {
		    		            	 
		    		            	 System.out.println(tabDat.get(0).text() );
		    		            	 
		    		             }
		    		             
		    		         }
		                 }*/
		               //  break;
		                 
		             }
		         }
		     }
			
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			
		}
		catch(IOException io){
			System.out.println(io.getMessage());
		}
		return programList;
	}

}
