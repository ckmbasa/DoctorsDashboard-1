/*
 ** Created by Alvin Jay Cosare
 ** Created on 05/7/14
 ** Registration model class 
 */

package com.example.model;

public class Registration{

	private String license_nr;
	private String username;
	private String password;
	private String client_id;
	private String server_id;
	private String token;
	
	public Registration() {
		super();

		//initialize variable values
		this.license_nr	= null;
		this.username 	= null;
		this.password 	= null;
		this.client_id	= null;

	}
	
	//Setter Methods	
	
	public void setLicenseNumber(String license_nr) {
		System.out.println("license_nr set");
		this.license_nr = license_nr;	
		System.out.println(this.license_nr);
	}

	public void setUsername(String license_nr) {
		this.username = username;	
	}

	public void setPassword(String license_nr) {
		this.password = password;	
	}

	public void setClientId(String license_nr) {
		this.client_id = client_id;	
	}


//Getter Methods	
	
	public String getLicenseNumber(){
		return license_nr;	
	}

	public String getUsername(){
		return username;	
	}

	public String getPassword(){
		return password;	
	}

	public String getClientId(){
		return client_id;	
	}


	
}
