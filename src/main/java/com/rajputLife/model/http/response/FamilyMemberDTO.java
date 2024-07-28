package com.rajputLife.model.http.response;

import lombok.*;

@Data
public class FamilyMemberDTO {

    private int pkFamilyMemberId;
    public String type; //Father, mother, sister, brother.
    public String fullName;
    public String gotra;
    public String village;
    public boolean isMarried;

    private PersonDTO personDTO;
}
