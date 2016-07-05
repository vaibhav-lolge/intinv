package com.inventory.model;

public class User {
	
	

	private String id;	
	private String name;
	private String password;
	private String identifier;
	private int role;
	private int active;
	
	public User(){
		super();
	}
	
	
	
	public User(String name, String id, String password, String identifier, int role, int active){
		super();
		this.name = name;
		this.id = id;
		this.password= password;
		this.identifier=identifier;
		this.role= role;
		this.active=active;
	}
	
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}