package com.rajputLife.model.http.response;

import lombok.Data;

@Data
public class AddressDTO {

    public int pkAddressId;
    public String address1;
    public String address2;
    public String district;
    public String state;
    public String pinOrZipCode;
    public String country;

	private ProfileDTO profileDTO;

}
