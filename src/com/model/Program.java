package com.model;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class Program {
	
	private String id;
	private String batchId;
	
	private String state;
	private String collegeName;
	private String detailsUrl;
	
	/* Accreditation Status*/
	private String accrediationStatus;
	private String accrediationDate;
	
	
	/* Websites & Social Media*/
	private String website;
	
	/* Class & Degree Information*/
	private String degreesOffered;
	private String bachelorsDegreeCriteria;
	private String classDates;
	private String classDuration;
	private String classCapacity;
	private String campus;
	private String onCampusHousing;
	private String partTimeOption;
	private String distanceAndonlineLearning;
	private String acceptTransferStatus;
	private String seatDeposit;
	
	
	/*International Applicants*/
	private String internationalStudents;
	private String additionalInfo;
	
	/*Application Deadline*/
	private String caspaParticipant;
	private String applicationDeadLine;
	private String deadLineType;
	
	
	/*Curriculum & Coursework Focus*/
	private String curriculumDesign;
	private String courseDesign;
	
	/*Contact Information*/
	private String mail;
	private String phone;
	private String email;
	
	/*Tuition*/
	private String resident;
	private String nonResident;
	
	/*Standardized Exams*/
	private String gre;
	private String tofl;
	
	/*Health Care Experience*/
	private String healthCareExperience;
	
	/*Minimum GPA*/
	private String overAllGpa;
	private String preRequisiteGpa;
	private String scienceGpa;
	private String scienceGpaMethod;
	
	
	/*Recommendation Letters*/
	private String recommendationLettersRequired;
	private String anyOneSpecific;
	
	
	/*Supplemental Application*/
	private String supplementalAppRequired;
	
	
	
	
	
	
	
	
	public static DBObject createDBObject(Program program) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		if(program.getId() != null)
			docBuilder.append("_id", new ObjectId(program.getId()));
		docBuilder.append("batchId", program.getBatchId());
		
		docBuilder.append("state", program.getState());
		docBuilder.append("collegeName", program.getCollegeName());
		docBuilder.append("detailsUrl", program.getDetailsUrl());
		
		docBuilder.append("accrediationStatus", program.getAccrediationStatus());
		docBuilder.append("accrediationDate", program.getAccrediationDate());
		
		docBuilder.append("website", program.getWebsite());
		
		docBuilder.append("degreesOffered", program.getDegreesOffered());
		docBuilder.append("bachelorsDegreeCriteria", program.getBachelorsDegreeCriteria());
		docBuilder.append("classDates", program.getClassDates());
		docBuilder.append("classDuration", program.getClassDuration());
		docBuilder.append("classCapacity", program.getClassCapacity());
		docBuilder.append("campus", program.getCampus());
		docBuilder.append("onCampusHousing", program.getOnCampusHousing());
		docBuilder.append("partTimeOption", program.getPartTimeOption());
		docBuilder.append("distanceAndonlineLearning", program.getDistanceAndonlineLearning());
		docBuilder.append("acceptTransferStatus", program.getAcceptTransferStatus());
		docBuilder.append("seatDeposit", program.getSeatDeposit());
		
		docBuilder.append("internationalStudents", program.getInternationalStudents());
		docBuilder.append("additionalInfo", program.getAdditionalInfo());
		
		docBuilder.append("caspaParticipant", program.getCaspaParticipant());
		docBuilder.append("applicationDeadLine", program.getApplicationDeadLine());
		docBuilder.append("deadLineType", program.getDeadLineType());
		
		docBuilder.append("curriculumDesign", program.getCurriculumDesign());
		docBuilder.append("courseDesign", program.getCourseDesign());
		
		docBuilder.append("mail", program.getMail());
		docBuilder.append("phone", program.getPhone());
		docBuilder.append("email", program.getEmail());
		
		docBuilder.append("resident", program.getResident());
		docBuilder.append("nonResident", program.getNonResident());
		
		docBuilder.append("gre", program.getGre());
		docBuilder.append("tofl", program.getTofl());
		
		docBuilder.append("healthCareExperience", program.getHealthCareExperience());
		
		docBuilder.append("overAllGpa", program.getOverAllGpa());
		docBuilder.append("preRequisiteGpa", program.getPreRequisiteGpa());
		docBuilder.append("scienceGpa", program.getScienceGpa());
		docBuilder.append("scienceGpaMethod", program.getScienceGpaMethod());
		
		docBuilder.append("recommendationLettersRequired", program.getRecommendationLettersRequired());
		docBuilder.append("anyOneSpecific", program.getAnyOneSpecific());
		
		docBuilder.append("supplementalAppRequired", program.getSupplementalAppRequired());
		
		
		return docBuilder.get();
	}
	
	public static Program createProgram(DBObject dbObj) {
		
		Program program = new Program();
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		program.setBatchId((String)dbObj.get("batchId"));
		program.setId(dbObj.get("_id").toString());
		
		program.setState((String)dbObj.get("state"));
		program.setCollegeName((String)dbObj.get("collegeName"));
		program.setDetailsUrl((String)dbObj.get("detailsUrl"));
		
		program.setAccrediationStatus((String)dbObj.get("accrediationStatus"));
		program.setAccrediationDate((String)dbObj.get("accrediationDate"));
		
		program.setWebsite((String)dbObj.get("website"));
		
		program.setDegreesOffered((String)dbObj.get("degreesOffered"));
		program.setBachelorsDegreeCriteria((String)dbObj.get("bachelorsDegreeCriteria"));
		program.setClassDates((String)dbObj.get("classDates"));
		program.setClassDuration((String)dbObj.get("classDuration"));
		program.setClassCapacity((String)dbObj.get("classCapacity"));
		program.setCampus((String)dbObj.get("campus"));
		program.setOnCampusHousing((String)dbObj.get("onCampusHousing"));
		program.setPartTimeOption((String)dbObj.get("partTimeOption"));
		program.setDistanceAndonlineLearning((String)dbObj.get("distanceAndonlineLearning"));
		program.setAcceptTransferStatus((String)dbObj.get("acceptTransferStatus"));
		program.setSeatDeposit((String)dbObj.get("seatDeposit"));
		
		program.setInternationalStudents((String)dbObj.get("internationalStudents"));
		program.setAdditionalInfo((String)dbObj.get("additionalInfo"));
		
		program.setCaspaParticipant((String)dbObj.get("caspaParticipant"));
		program.setApplicationDeadLine((String)dbObj.get("applicationDeadLine"));
		program.setDeadLineType((String)dbObj.get("deadLineType"));
		
		program.setCurriculumDesign((String)dbObj.get("curriculumDesign"));
		program.setCourseDesign((String)dbObj.get("courseDesign"));
		
		program.setEmail((String)dbObj.get("mail"));
		program.setPhone((String)dbObj.get("phone"));
		program.setEmail((String)dbObj.get("email"));
		
		program.setResident((String)dbObj.get("resident"));
		program.setNonResident((String)dbObj.get("nonResident"));
		
		program.setGre((String)dbObj.get("gre"));
		program.setTofl((String)dbObj.get("tofl"));
		
		program.setHealthCareExperience((String)dbObj.get("healthCareExperience"));
		
		program.setOverAllGpa((String)dbObj.get("overAllGpa"));
		program.setPreRequisiteGpa((String)dbObj.get("preRequisiteGpa"));
		program.setScienceGpa((String)dbObj.get("scienceGpa"));
		program.setScienceGpaMethod((String)dbObj.get("scienceGpaMethod"));
		
		program.setRecommendationLettersRequired((String)dbObj.get("recommendationLettersRequired"));
		program.setAnyOneSpecific((String)dbObj.get("anyOneSpecific"));
		
		program.setSupplementalAppRequired((String)dbObj.get("supplementalAppRequired"));
		
		
		return program;
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

	public String getAccrediationStatus() {
		return accrediationStatus;
	}

	public void setAccrediationStatus(String accrediationStatus) {
		this.accrediationStatus = accrediationStatus;
	}

	public String getAccrediationDate() {
		return accrediationDate;
	}

	public void setAccrediationDate(String accrediationDate) {
		this.accrediationDate = accrediationDate;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDegreesOffered() {
		return degreesOffered;
	}

	public void setDegreesOffered(String degreesOffered) {
		this.degreesOffered = degreesOffered;
	}

	public String getBachelorsDegreeCriteria() {
		return bachelorsDegreeCriteria;
	}

	public void setBachelorsDegreeCriteria(String bachelorsDegreeCriteria) {
		this.bachelorsDegreeCriteria = bachelorsDegreeCriteria;
	}

	public String getClassDates() {
		return classDates;
	}

	public void setClassDates(String classDates) {
		this.classDates = classDates;
	}

	public String getClassDuration() {
		return classDuration;
	}

	public void setClassDuration(String classDuration) {
		this.classDuration = classDuration;
	}

	public String getClassCapacity() {
		return classCapacity;
	}

	public void setClassCapacity(String classCapacity) {
		this.classCapacity = classCapacity;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getOnCampusHousing() {
		return onCampusHousing;
	}

	public void setOnCampusHousing(String onCampusHousing) {
		this.onCampusHousing = onCampusHousing;
	}

	public String getPartTimeOption() {
		return partTimeOption;
	}

	public void setPartTimeOption(String partTimeOption) {
		this.partTimeOption = partTimeOption;
	}

	public String getDistanceAndonlineLearning() {
		return distanceAndonlineLearning;
	}

	public void setDistanceAndonlineLearning(String distanceAndonlineLearning) {
		this.distanceAndonlineLearning = distanceAndonlineLearning;
	}

	public String getAcceptTransferStatus() {
		return acceptTransferStatus;
	}

	public void setAcceptTransferStatus(String acceptTransferStatus) {
		this.acceptTransferStatus = acceptTransferStatus;
	}

	public String getSeatDeposit() {
		return seatDeposit;
	}

	public void setSeatDeposit(String seatDeposit) {
		this.seatDeposit = seatDeposit;
	}

	public String getInternationalStudents() {
		return internationalStudents;
	}

	public void setInternationalStudents(String internationalStudents) {
		this.internationalStudents = internationalStudents;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getCaspaParticipant() {
		return caspaParticipant;
	}

	public void setCaspaParticipant(String caspaParticipant) {
		this.caspaParticipant = caspaParticipant;
	}

	public String getApplicationDeadLine() {
		return applicationDeadLine;
	}

	public void setApplicationDeadLine(String applicationDeadLine) {
		this.applicationDeadLine = applicationDeadLine;
	}

	public String getDeadLineType() {
		return deadLineType;
	}

	public void setDeadLineType(String deadLineType) {
		this.deadLineType = deadLineType;
	}

	public String getCurriculumDesign() {
		return curriculumDesign;
	}

	public void setCurriculumDesign(String curriculumDesign) {
		this.curriculumDesign = curriculumDesign;
	}

	public String getCourseDesign() {
		return courseDesign;
	}

	public void setCourseDesign(String courseDesign) {
		this.courseDesign = courseDesign;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResident() {
		return resident;
	}

	public void setResident(String resident) {
		this.resident = resident;
	}

	public String getNonResident() {
		return nonResident;
	}

	public void setNonResident(String nonResident) {
		this.nonResident = nonResident;
	}

	public String getGre() {
		return gre;
	}

	public void setGre(String gre) {
		this.gre = gre;
	}

	public String getTofl() {
		return tofl;
	}

	public void setTofl(String tofl) {
		this.tofl = tofl;
	}

	public String getHealthCareExperience() {
		return healthCareExperience;
	}

	public void setHealthCareExperience(String healthCareExperience) {
		this.healthCareExperience = healthCareExperience;
	}

	public String getOverAllGpa() {
		return overAllGpa;
	}

	public void setOverAllGpa(String overAllGpa) {
		this.overAllGpa = overAllGpa;
	}

	public String getPreRequisiteGpa() {
		return preRequisiteGpa;
	}

	public void setPreRequisiteGpa(String preRequisiteGpa) {
		this.preRequisiteGpa = preRequisiteGpa;
	}

	public String getScienceGpa() {
		return scienceGpa;
	}

	public void setScienceGpa(String scienceGpa) {
		this.scienceGpa = scienceGpa;
	}

	public String getScienceGpaMethod() {
		return scienceGpaMethod;
	}

	public void setScienceGpaMethod(String scienceGpaMethod) {
		this.scienceGpaMethod = scienceGpaMethod;
	}

	public String getRecommendationLettersRequired() {
		return recommendationLettersRequired;
	}

	public void setRecommendationLettersRequired(String recommendationLettersRequired) {
		this.recommendationLettersRequired = recommendationLettersRequired;
	}

	public String getAnyOneSpecific() {
		return anyOneSpecific;
	}

	public void setAnyOneSpecific(String anyOneSpecific) {
		this.anyOneSpecific = anyOneSpecific;
	}

	public String getSupplementalAppRequired() {
		return supplementalAppRequired;
	}

	public void setSupplementalAppRequired(String supplementalAppRequired) {
		this.supplementalAppRequired = supplementalAppRequired;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
