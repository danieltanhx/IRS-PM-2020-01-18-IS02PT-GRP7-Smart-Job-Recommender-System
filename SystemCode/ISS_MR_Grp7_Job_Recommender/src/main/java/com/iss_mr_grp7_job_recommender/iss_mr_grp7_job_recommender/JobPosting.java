package com.iss_mr_grp7_job_recommender.iss_mr_grp7_job_recommender;

import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class was automatically generated by the data modeler tool.
 */

@org.kie.api.definition.type.Label("Job Posting")
public class JobPosting implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	@org.kie.api.definition.type.Label("Company Name")
	private java.lang.String companyName;

	@org.kie.api.definition.type.Label("Job Title")
	private java.lang.String jobTitle;

	@org.kie.api.definition.type.Label("Company Location")
	private java.lang.String companyLocation;

	@org.kie.api.definition.type.Label("Job Requirements")
	private java.lang.String jobRequirements;

	@org.kie.api.definition.type.Label("Employment Type")
	private java.lang.String employmentType;

	@org.kie.api.definition.type.Label("Minimum Salary")
	private java.lang.Integer minSalary;

	@org.kie.api.definition.type.Label("Maximum Salary")
	private java.lang.Integer maxSalary;

	@org.kie.api.definition.type.Label("Seniority Level")
	private java.lang.String seniorityLevel;

	@org.kie.api.definition.type.Label("Job Category")
	private java.lang.String jobCategory;

	@org.kie.api.definition.type.Label("Years of Work Experience Required")
	private java.lang.Integer workExperienceReq;

	@org.kie.api.definition.type.Label("Salary Range")
	private java.lang.String salaryRange;

	@org.kie.api.definition.type.Label("Job Match Score")
	private Float jobMatchScore;

	@org.kie.api.definition.type.Label("Job ID")
	private java.lang.String jobID;

	@org.kie.api.definition.type.Label("Average Salary")
	private java.lang.Integer avgSalary;

	@org.kie.api.definition.type.Label("Travel Time Required")
	private String travelTimeReq;

	@org.kie.api.definition.type.Label("Job Technical Skills Required")
	private java.lang.String jobTechnicalSkills;

	@org.kie.api.definition.type.Label("Job Educational Qualifications")
	private java.lang.String jobQualifications;

	public JobPosting() {
	}

	public java.lang.String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}

	public java.lang.String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(java.lang.String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public java.lang.String getCompanyLocation() {
		return this.companyLocation;
	}

	public void setCompanyLocation(java.lang.String companyLocation) {
		this.companyLocation = companyLocation;
	}

	public java.lang.String getJobRequirements() {
		return this.jobRequirements;
	}

	public void setJobRequirements(java.lang.String jobRequirements) {
		this.jobRequirements = jobRequirements;
	}

	public java.lang.String getEmploymentType() {
		return this.employmentType;
	}

	public void setEmploymentType(java.lang.String employmentType) {
		this.employmentType = employmentType;
	}

	public java.lang.Integer getMinSalary() {
		return this.minSalary;
	}

	public void setMinSalary(java.lang.Integer minSalary) {
		this.minSalary = minSalary;
	}

	public java.lang.Integer getMaxSalary() {
		return this.maxSalary;
	}

	public void setMaxSalary(java.lang.Integer maxSalary) {
		this.maxSalary = maxSalary;
	}

	public java.lang.String getSeniorityLevel() {
		return this.seniorityLevel;
	}

	public void setSeniorityLevel(java.lang.String seniorityLevel) {
		this.seniorityLevel = seniorityLevel;
	}

	public java.lang.String getJobCategory() {
		return this.jobCategory;
	}

	public void setJobCategory(java.lang.String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public java.lang.Integer getWorkExperienceReq() {
		return this.workExperienceReq;
	}

	public void setWorkExperienceReq(java.lang.Integer workExperienceReq) {
		this.workExperienceReq = workExperienceReq;
	}

	public java.lang.String getSalaryRange() {
		return this.salaryRange;
	}

	public void setSalaryRange(java.lang.String salaryRange) {
		this.salaryRange = salaryRange;
	}

	public java.lang.String getJobID() {
		return this.jobID;
	}

	public void setJobID(java.lang.String jobID) {
		this.jobID = jobID;
	}

	public java.lang.Integer getAvgSalary() {
		return this.avgSalary;
	}

	public void setAvgSalary(java.lang.Integer avgSalary) {
		this.avgSalary = avgSalary;
	}

	public java.lang.Float getJobMatchScore() {
		return this.jobMatchScore;
	}

	public void setJobMatchScore(java.lang.Float jobMatchScore) {
		this.jobMatchScore = jobMatchScore;
	}

	public java.lang.String getJobTechnicalSkills() {
		return this.jobTechnicalSkills;
	}

	public void setJobTechnicalSkills(java.lang.String jobTechnicalSkills) {
		this.jobTechnicalSkills = jobTechnicalSkills;
	}

	public java.lang.String getJobQualifications() {
		return this.jobQualifications;
	}

	public void setJobQualifications(java.lang.String jobQualifications) {
		this.jobQualifications = jobQualifications;
	}
	
	
	public java.lang.String getTravelTimeReq() {
		return this.travelTimeReq;
	}

	public void setTravelTimeReq(java.lang.String travelTimeReq) {
		this.travelTimeReq = travelTimeReq;
	}

	public void calculateTravelDurationOffline(int postalCode, String travelMode) {
		JSONParser parser = new JSONParser();
		String path = "/home/iss-user/Desktop/group7/Database/%d.json";
		path = path.format(path, postalCode);
		int duration = 0;

		// Remember to check the path of the stored JSON files
		try (Reader reader = new FileReader(path)) {

			String companyName = this.getCompanyName();

			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			JSONObject entry = (JSONObject) jsonObject.get(companyName);

			if (travelMode == "transit") {
				String durationStr = (String) entry.get("Transit_Time")
						.toString();
				this.setTravelTimeReq(durationStr);

				System.out.println("Added travel distance for location: "
						+ companyName);

			} else {
				String durationStr = (String) entry.get("Drive_Time")
						.toString();
				this.setTravelTimeReq(durationStr);

				System.out.println("Added travel distance for location: "
						+ companyName);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void calculateTravelDuration(int postalCode, String travelMode) {

		String jobDestination = this.getCompanyName();
		jobDestination = jobDestination.replaceAll("[^a-zA-Z]+", "");

		String xPathString = "//value/text()";
		HttpURLConnection conn;
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();

		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.HOUR_OF_DAY, 7);
		calendar.set(Calendar.MINUTE, 30);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		calendar.add(Calendar.DATE, 1);

		while ((Calendar.SATURDAY == calendar.get(calendar.DAY_OF_WEEK))
				|| (Calendar.SUNDAY == calendar.get(calendar.DAY_OF_WEEK)))
			calendar.add(Calendar.DATE, 1);

		long milliseconds = calendar.getTimeInMillis();

		long seconds = milliseconds / 1000;

		try {

			URL url = new URL(
					"https://maps.googleapis.com/maps/api/distancematrix/xml?units=metric&origins="
							+ postalCode + ",Singapore&destinations="
							+ jobDestination + ",Singapore&departure_time="
							+ seconds + "&mode=" + travelMode
							+ "&key=AIzaSyAoI0BGxVsbBXDxsIF2IbRKxktSt8ZbKYY");
			conn = (HttpURLConnection) url.openConnection();
			conn.setInstanceFollowRedirects(true);

			if (conn.getResponseCode() >= 400) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			InputSource inputXml = new InputSource(conn.getInputStream());
			NodeList nodes = (NodeList) xpath.evaluate(xPathString, inputXml,
					XPathConstants.NODESET);

			if (nodes.item(0) == null) {
				System.out
						.println("Error: Unable to calculate travel distance for location: "
								+ jobDestination);
				this.setTravelTimeReq("Unable to calculate travel time");

				conn.disconnect();

			} else {

				String durationStr = nodes.item(0).getTextContent();
				Integer replacedDuration = Integer.parseInt(durationStr);
				String duration = Integer.toString(replacedDuration / 60);
				
				this.setTravelTimeReq(duration);
				System.out.println("Added travel distance for location: "
						+ jobDestination);

				conn.disconnect();
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException ex) {
			System.out.print("XPath Error");
		}

	}

	public JobPosting(java.lang.String companyName, java.lang.String jobTitle,
			java.lang.String companyLocation, java.lang.String jobRequirements,
			java.lang.String employmentType, java.lang.Integer minSalary,
			java.lang.Integer maxSalary, java.lang.String seniorityLevel,
			java.lang.String jobCategory, java.lang.Integer workExperienceReq,
			java.lang.String salaryRange, java.lang.Float jobMatchScore,
			java.lang.String jobID, java.lang.Integer avgSalary,
			java.lang.String travelTimeReq,
			java.lang.String jobTechnicalSkills,
			java.lang.String jobQualifications) {
		this.companyName = companyName;
		this.jobTitle = jobTitle;
		this.companyLocation = companyLocation;
		this.jobRequirements = jobRequirements;
		this.employmentType = employmentType;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.seniorityLevel = seniorityLevel;
		this.jobCategory = jobCategory;
		this.workExperienceReq = workExperienceReq;
		this.salaryRange = salaryRange;
		this.jobMatchScore = jobMatchScore;
		this.jobID = jobID;
		this.avgSalary = avgSalary;
		this.travelTimeReq = travelTimeReq;
		this.jobTechnicalSkills = jobTechnicalSkills;
		this.jobQualifications = jobQualifications;
	}

}