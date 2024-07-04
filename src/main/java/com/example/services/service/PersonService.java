package com.example.services.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.services.Person;
import com.example.services.repository.ServiceRepo;

@Service
public class PersonService {
	
	@Autowired
	private ServiceRepo repo;
	
	public List<Person> allPersons() {
		System.out.println(repo.findAll());
		return repo.findAll();
	}
	
	public Optional<Person> searchById(String id){
		return repo.findById(id);
	}
	public List<Person> searchByLocation(String location){
		System.out.println(repo.findByLocation(location));
		return repo.findByLocation(location);
	}
	public List<Person> searchBySkill(String skill){
		return repo.findBySkillsContaining(skill);
	}
	
	public List<Person> getAllPersonsBySkills(String skill1, String skill2){
		return repo.findBySkillsContainingAll(skill1, skill2);
	}
	
	public List<Person> getAnyPersonBySkills(String skill1, String skill2){
		return repo.findBySkillsContainingAny(skill1, skill2);
	}
}
