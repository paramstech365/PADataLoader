package com.parser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
	
	private HashMap<String, String> configs = new HashMap<>();
	
	private void setConfigs(){
		
		configs.put("Accreditation Status", "accrediationStatus");
		configs.put("Accreditation Date", "accrediationDate");
		
		configs.put("Website", "website");
		
		configs.put("Degrees Offered", "degreesOffered");
		configs.put("Bachelor Degree", "bachelorsDegreeCriteria");
		configs.put("Class Dates", "classDates");
		configs.put("Class Duration", "classDuration");
		configs.put("Class Capacity", "classCapacity");
		configs.put("Campus", "campus");
		configs.put("On-Campus Housing", "onCampusHousing");
		configs.put("Part-Time Option", "partTimeOption");
		configs.put("Distance & Online Learning", "distanceAndonlineLearning");
		configs.put("Accept Transfer Students", "acceptTransferStatus");
		configs.put("Seat Deposit", "seatDeposit");
		
		
		configs.put("International students", "internationalStudents");
		configs.put("Additional information", "additionalInfo");
		
		configs.put("CASPA Participant?", "caspaParticipant");
		configs.put("Application Deadline", "applicationDeadLine");
		configs.put("Deadline Type", "deadLineType");
		
		configs.put("Curriculum Design", "curriculumDesign");
		configs.put("Course Design", "courseDesign");
		
		configs.put("Mail", "mail");
		configs.put("Phone", "phone");
		configs.put("Email", "email");
		
		configs.put("Resident", "resident");
		configs.put("Nonresident", "nonResident");
		
		configs.put("GRE", "gre");
		configs.put("TOEFL", "tofl");
		
		configs.put("Experience", "healthCareExperience");
		
		configs.put("Overall GPA", "overAllGpa");
		configs.put("Prerequisite GPA", "preRequisiteGpa");
		configs.put("Science GPA", "scienceGpa");
		configs.put("Science GPA Method", "scienceGpaMethod");
		
		configs.put("Letters required", "recommendationLettersRequired");
		configs.put("Anyone specific?", "anyOneSpecific");
		
		configs.put("Required", "supplementalAppRequired");
		
	}

	public List<Program> getProgramList() {
		// TODO Auto-generated method stub
		
		setConfigs();
		String url = "http://directory.paeaonline.org/";
		List<Program> programList = new ArrayList<>();
		try{
			Document doc = Jsoup.connect(url).get();
			Elements links = doc.select("table");
			FileOutputStream fileOut = new FileOutputStream("programList.xls");
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet worksheet = workbook.createSheet("Programs");
			int rowNum = 0;
			UUID batchId = UUID.randomUUID();
			for (Element table : links) {
				int col = 0;
		         for (Element row : table.select("tr")) {
		             Elements tds = row.select("td");
		             if (tds.size() > 2) {
		            	 Program header = new Program();
		            	 header.setCollegeName(tds.get(0).text());
		            	 header.setState(tds.get(1).text());
		            	 header.setBatchId(batchId.toString());
		            	
		                 System.out.println(tds.get(0).text() + ":" + tds.get(1).text());
		                 Elements el = tds.get(0).getElementsByTag("a");
		                 System.out.println("http://directory.paeaonline.org"+el.attr("href"));
		                 header.setDetailsUrl("http://directory.paeaonline.org"+el.attr("href"));
		                 programList.add(header);
		                 
		                 HSSFRow row1 = worksheet.createRow(rowNum++);
		                 col = 0;
		                 HSSFCell cellA1 = row1.createCell(col++);
		     			cellA1.setCellValue(header.getCollegeName());
		     			HSSFCell cellb1 = row1.createCell(col++);
		     			cellb1.setCellValue(header.getState());
		     			HSSFCell cellc1 = row1.createCell(col++);
		     			cellc1.setCellValue(header.getDetailsUrl());
		                 
		                 Document detailsDoc = Jsoup.connect(header.getDetailsUrl()).get();
		                 for (Element tab : detailsDoc.select("table")) {
		    		         for (Element tabRow : tab.select("tr")) {
		    		             Elements tabHead = tabRow.select("th");
		    		             if (tabHead.size() > 0) {
		    		            	 Set<String> keySets = configs.keySet();
		    		            	 for(String key : keySets){
		    		            		// System.out.println(tab.toString() + "---"+ tabRow.toString() );
		    		            		 if(tabHead.get(0).text().equalsIgnoreCase(key)){
		    		            			 
		    		            			 Elements tabDat = tabRow.select("td");
		    		            			 Class<?> c = header.getClass();
				    		            	 if(tabDat.size() > 0)
				    		            	 {
				    		            		 Field f = c.getDeclaredField(configs.get(key));
				    		            		 f.setAccessible(true);
				    		            		 f.set(header,tabDat.get(0).text());
				    		            		 HSSFCell cellc4 = row1.createCell(col++);
				    				     		 cellc4.setCellValue(tabDat.get(0).text());
				    		            		 System.out.println(key + "---" +tabDat.get(0).text() );
				    		            	 }
				    		            	 
		    		            		 }
		    		            	 }
		    		            	
		    		             }
		    		             //break;
		    		             
		    		         }
		    		       //  break;
		                 }
		                 break;
		                 
		             }
		         }
		     }
			
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			
		}
		catch(IOException io){
			io.printStackTrace();
		}
		catch(NoSuchFieldException ex){
			ex.printStackTrace();
		}
		catch(IllegalAccessException ex){
			ex.printStackTrace();
		}
		return programList;
	}

}
