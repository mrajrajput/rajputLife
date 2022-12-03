package com.rajputLife.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "FamilyMember")
public class FamilyMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkFamilyMemberId", nullable = false)
    private int pkFamilyMemberId;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fkPersonId")
//    public Person person;

    @Column(name = "type", nullable = true)
    public String type; //Father, mother, sister, brother.

    @Column(name="fullName", nullable = true)
    public String fullName;

    @Column(name="gotra", nullable = true)
    public String gotra;

    @Column(name="village", nullable = true)
    public String village;

    @Column(name="isMarried", nullable = true)
    public boolean isMarried;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fkPersonId")
	private Person person;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGotra() {
		return gotra;
	}

	public void setGotra(String gotra) {
		this.gotra = gotra;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	

//we will below fields nullable even though they are coming from dropdown.

//    @Column(name="marriageDate", nullable = true)
//    public Calendar marriageDate;
//
//    @Column(name="isDivorced", nullable = true)
//    public boolean isDivorce;
//
//    @Column(name="divorcedDate", nullable = true)
//    public Calendar divorcedDate;



}
