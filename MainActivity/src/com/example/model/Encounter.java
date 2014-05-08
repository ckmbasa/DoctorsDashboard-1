/*
 ** Created by Christian Joseph Dalisay
 ** Created on 04/30/14
 ** Encounter model class 
 */

package com.example.model;

public class Encounter extends Patient{

	private int 	encounter_id;
	private int 	pid;
	private String 	type_patient;
	private String 	message_complaint;
	private String 	date_encountered;
	private String 	date_released;
	
	public Encounter(Patient rPatient) {
		super();
		// TODO Auto-generated constructor stub
		//Encounters within patients
		this.encounter_id 		= (Integer) null;
		this.pid 				= (Integer) null;
		this.type_patient 		= null;
		this.message_complaint 	= null;
		this.date_encountered 	= null;
		this.date_released 		= null;
	}
	
	public Encounter(){
		this.encounter_id 		= (Integer) null;
		this.pid 				= (Integer) null;
		this.type_patient 		= null;
		this.message_complaint 	= null;
		this.date_encountered 	= null;
		this.date_released 		= null;
	}

	//Setter Methods	
	
	public void setEncounter(Encounter rEncounter) {
		setEncounterId(rEncounter.encounter_id);
		setPid(rEncounter.pid);
		setTypePatient(rEncounter.type_patient);
		setMessageComplaint(rEncounter.message_complaint);
		setDateEncountered(rEncounter.date_encountered);
		setDateReleased(rEncounter.date_released);
	}
	
	public void setEncounterId(int rEncounter_id) {
		this.encounter_id = rEncounter_id;
	}
	
	public void setPid(int rPid) {
		this.pid = rPid;
	}
	
	public void setTypePatient(String rType_Patient) {
		this.type_patient = rType_Patient;
	}
	
	public void setMessageComplaint(String rMessage_Complaint) {
		this.message_complaint = rMessage_Complaint;
	}
	
	public void setDateEncountered(String rDate_Encountered) {
		this.date_encountered = rDate_Encountered;
	}
	
	public void setDateReleased(String rDate_Released) {
		this.date_released = rDate_Released;
	}
	
	//Getter Methods
	
	public Encounter getEncounter() {
		return this;
	}
	
	public int getEncounterId() {
		return this.encounter_id;
	}
	
	public int getPid() {
		return this.pid;
	}
	
	public String getTypePatient() {
		return this.type_patient;
	}
	
	public String getMessageComplaint() {
		return this.message_complaint;
	}
	
	public String getDateEncountered() {
		return this.date_encountered;
	}
	
	public String getDateReleased() {
		return this.date_released;
	}
}
