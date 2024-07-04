package com.example.services.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.Person;
import com.example.services.service.PersonService;

@RestController
@RequestMapping("/ser")
public class ServiceController {
	
	@Autowired
	private PersonService pso;
	
	@GetMapping
	public ResponseEntity<List<Person>> getallMovies() {
		return new ResponseEntity<List<Person>>(pso.allPersons(), HttpStatus.OK);
		
	}
	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<Person>> getPersonById(@PathVariable String id){
		return new ResponseEntity<Optional<Person>>(pso.searchById(id), HttpStatus.OK);
	}
	@GetMapping("/loc/{location}")
	public ResponseEntity<List<Person>> getPersonByLocation(@PathVariable String location){
		return new ResponseEntity<List<Person>>(pso.searchByLocation(location), HttpStatus.OK);
	}
	@GetMapping("/persons/skill")
	public ResponseEntity<List<Person>> getPersonBySkill(@RequestParam String skill){
		List<Person> persons = pso.searchBySkill(skill);
		if(persons.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(persons);
	}
	@GetMapping("/persons/any-skill")
    public ResponseEntity<List<Person>> getPersonsByAnySkill(@RequestParam String skill1, @RequestParam String skill2) {
        List<Person> persons = pso.getAnyPersonBySkills(skill1, skill2);
        if (persons.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(persons);
	}
	@GetMapping("/humans/skill")
    public ResponseEntity<List<Person>> getPersonsByAllSkill(@RequestParam String skill1, @RequestParam String skill2) {
        List<Person> persons = pso.getAllPersonsBySkills(skill1, skill2);
        if (persons.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(persons);
	}
}
