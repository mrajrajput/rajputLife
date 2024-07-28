package com.rajputLife.controller;

import java.time.Duration;
import java.time.Instant;

import org.modelmapper.ModelMapper;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.rajputLife.entity.Person;
import com.rajputLife.model.http.response.PersonDTO;
import com.rajputLife.service.FormAdapterSpringService;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Scope(value = "session")
@Component(value = "profileFormController")
@ELBeanName(value = "profileFormController")
@Join(path = "/form", to = "/form.jsf")
//@Controller <-- not needed, we will call RestController from here.
public class ProfileFormController {

	@Autowired
	FormAdapterSpringService service;
	
	public PersonDTO personDTO;
	
	public ProfileFormController() {
		personDTO = new PersonDTO();
	}
	

	public void savePersonal() {
		Instant start = Instant.now();
		
		PersonDTO dto = (PersonDTO) service.savePersonal(this.personDTO).getBody();

		long timeElapsed = Duration.between(start, Instant.now()).toNanos();
		System.out.println(timeElapsed+" "+dto.getHighestEducation());
	}
	
	public PersonDTO getPersonDTO() {
		return personDTO;
	}

	public void setPersonDTO(PersonDTO personDTO) {
		this.personDTO = personDTO;
	}
	
//	public static void main(String[] args) {
//	    ModelMapper modelMapper =  new ModelMapper();
//	    PersonDTO dto = new PersonDTO();
//	    dto.setHighestEducation("fdf");
//		Person person =  modelMapper.map(dto, Person.class);
//		System.out.println(person.getHighestEducation());
//
//	}

}
