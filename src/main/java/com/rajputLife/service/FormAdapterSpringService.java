package com.rajputLife.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajputLife.entity.Person;
import com.rajputLife.model.http.response.PersonDTO;
import com.rajputLife.repository.PersonRepository;

//@Service
@RestController
public class FormAdapterSpringService {
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private PersonRepository personRepository;
	
	
	@PostMapping(value = "/form")
	public ResponseEntity<Object> savePersonal(PersonDTO personDTO) {
		Person person = personRepository.save(modelMapper.map(personDTO, Person.class));
		return ResponseEntity.ok().body(modelMapper.map(person, PersonDTO.class));
	}
	
	@PostMapping(value = "/test")
	public ResponseEntity<Object> savePersonal() {
		 PersonDTO dto = new PersonDTO();
		dto.setHighestEducation("fdf");
		Person person = personRepository.save(modelMapper.map(dto, Person.class));
		return ResponseEntity.ok().body(modelMapper.map(person, PersonDTO.class));
	}
	
	
	
}
