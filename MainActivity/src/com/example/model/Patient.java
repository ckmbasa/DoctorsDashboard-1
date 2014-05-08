/*
 ** Created by Christian Joseph Dalisay
 ** Created on 05/02/14
 ** Encounter model class 
 */

package com.example.model;

public class Patient {

	private int pid;
	private String name_last;
	private String name_first;
	private String name_middle;
	
	public Patient() {
		this.pid = (Integer) null;
		this.name_last = null;
		this.name_first = null;
	}
	public void setPatient(Patient rPatient) {
		setPid(rPatient.pid);
		setNameLast(rPatient.name_last);
		setNameFirst(rPatient.name_first);
	}
	
	public void setPid (int pid) {
		this.pid = pid;
	}
	
	public void setNameLast (String name_last) {
		this.name_last = name_last;
	}
	
	public void setNameFirst (String name_first) {
		this.name_first = name_first;
	}
	
	public Patient getPatient() {
		return this;
	}
	
	public int getPid() {
		return this.pid;
	}
	
	public String getNameLast() {
		return this.name_last;
	}
	
	public String getNameFirst() {
		return this.name_first;
	}
	
	
}


