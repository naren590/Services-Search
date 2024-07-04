package com.example.services.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.services.Person;

@Repository
public interface ServiceRepo extends MongoRepository<Person, String>{
	
	Optional<Person> findById(String id);
	
	List<Person> findByLocation(String location);
	
	List<Person> findBySkillsContaining(String skill);
	
	// Query to find persons having either of the two skills
	@Query("{ 'skills': { $in: [?0, ?1] } }")
	List<Person> findBySkillsContainingAny(String skill1, String skill2);
	
	// Query to find persons having both skills
	@Query("{ 'skills': { $all: [?0, ?1] } }")
	List<Person> findBySkillsContainingAll(String skill1, String skill2);
}
