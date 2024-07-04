package com.example.services;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="list")
public class Person {
	
	@Id
	private String id;
	private String name;
	private String location;
	private List<String> skills;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public Person(String id, String name, String location, List<String> skills) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.skills = skills;
	}
	

}
