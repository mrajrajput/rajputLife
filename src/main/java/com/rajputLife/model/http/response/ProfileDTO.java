package com.rajputLife.model.http.response;

import lombok.Data;

import java.util.Calendar;

@Data
public class ProfileDTO {

	public int pkProfileId;
	public boolean isBride;
	public String preference;
	public String mobileNumber;
	public String bloodGroup;
	public String historyOfDisease;
	public boolean isDivorcee;
	public Calendar divorcedDate;
	public Calendar marriageDate;

	private AddressDTO addressDTO;
	private PersonDTO personDTO;

}
