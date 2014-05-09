/*
 ** Created by Jessie Emmanuel Adante
 ** Created on 4/24/14
 ** This class retrieves the laboratory request number and encounter
 */

package com.example.model;

public class LabRequest 
{
	private int request_number;
	private int encounter_number;
	
	public LabRequest()
	{
		request_number = 0;
		encounter_number = 0;
	}
	
	public LabRequest(int requestnumber, int encounternumber)
	{
		request_number = requestnumber;
		encounter_number = encounternumber;
	}
	
	public void setRequestNumber(int requestnumber)
	{
		request_number = requestnumber;
	}
	
	public void setEncounterNumber(int encounternumber)
	{
		encounter_number = encounternumber;
	}
	
	public int getRequestNumber()
	{
		return request_number;
	}
	
	public int getEncounterNumber()
	{
		return encounter_number;
	}
	

}
