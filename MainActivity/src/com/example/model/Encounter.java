/*
 ** Created by Christian Joseph Dalisay
 ** Created on 05/02/14
 ** Edited by Jessie Emmanuel Adante - 05/07/14
 ** Edited by Jose Martin Ipong - 05/07/14
 ** Encounter model class 
 */
package com.example.model;

public class Encounter {
	private int 	encounter_id;
	private int 	pid;
	private String 	type_patient;
	private String 	message_complaint;
	private String 	date_encountered;
	private String 	date_released;
	
	public Encounter(){
		encounter_id 		= 0;
		pid 				= 0;
		type_patient 		= "";
		message_complaint 	= "";
		date_encountered 	= "";
		date_released 		= "";
	}
	
	public Encounter(int eid, String typepatient, String messagecomplaint, String dateencountered, String datereleased, int patientid)
	{
		encounter_id = eid;
		type_patient = typepatient;
		message_complaint = messagecomplaint;
		date_encountered = dateencountered;
		date_released = datereleased;
		pid = patientid;
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
	
	public String toString()
	{
		return date_encountered + " " + type_patient + " " + message_complaint;
	}

}
