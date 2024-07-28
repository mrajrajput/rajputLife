package com.rajputLife.model.http.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PersonDTO {
	
	public PersonDTO(){
		familyMembersDTO = new ArrayList<>();
	}

	private int pkPersonId;
	public String firstName;
	public String lastName;
	public String dob; //Put calendar here
	public String timeOfBirth; //Put Codes here
	public String placeOfBirth;
	public boolean isManglik;
	public String height; //Put Codes here
	public String weight; //Put Codes here
	public String complexion; //Put Codes here.
	public String highestEducation;
	public int whatYearDegreeReceived;
	public String languagesKnown; //how to make it many?
	public String employmentType; //Service, Business, Agriculture.
	public String salaryOrApproxIncome;
	public String workExperience;

	private ProfileDTO profileDTO;
	private List<FamilyMemberDTO> familyMembersDTO = new ArrayList<>();
	
	
	public int getPkPersonId() {
		return pkPersonId;
	}
	public void setPkPersonId(int pkPersonId) {
		this.pkPersonId = pkPersonId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getTimeOfBirth() {
		return timeOfBirth;
	}
	public void setTimeOfBirth(String timeOfBirth) {
		this.timeOfBirth = timeOfBirth;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	public boolean isManglik() {
		return isManglik;
	}
	public void setManglik(boolean isManglik) {
		this.isManglik = isManglik;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getComplexion() {
		return complexion;
	}
	public void setComplexion(String complexion) {
		this.complexion = complexion;
	}
	public String getHighestEducation() {
		return highestEducation;
	}
	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}
	public int getWhatYearDegreeReceived() {
		return whatYearDegreeReceived;
	}
	public void setWhatYearDegreeReceived(int whatYearDegreeReceived) {
		this.whatYearDegreeReceived = whatYearDegreeReceived;
	}
	public String getLanguagesKnown() {
		return languagesKnown;
	}
	public void setLanguagesKnown(String languagesKnown) {
		this.languagesKnown = languagesKnown;
	}
	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	public String getSalaryOrApproxIncome() {
		return salaryOrApproxIncome;
	}
	public void setSalaryOrApproxIncome(String salaryOrApproxIncome) {
		this.salaryOrApproxIncome = salaryOrApproxIncome;
	}
	public String getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	public ProfileDTO getProfileDTO() {
		return profileDTO;
	}
	public void setProfileDTO(ProfileDTO profileDTO) {
		this.profileDTO = profileDTO;
	}
	public List<FamilyMemberDTO> getFamilyMembersDTO() {
		return familyMembersDTO;
	}
	public void setFamilyMembersDTO(List<FamilyMemberDTO> familyMembersDTO) {
		this.familyMembersDTO = familyMembersDTO;
	}
}
