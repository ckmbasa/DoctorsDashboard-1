/*
 ** Created by Jessie Emmanuel Adante

 ** Created on 4/24/14
 ** This class retrieves the doctor's name, username and password
 */

package com.example.model;

public class DoctorProfile 
{
	private String personnel_number;
	private String location_number;
	private String doctor_username;
	private String doctor_password;
	private String doctor_first_name;
	private String doctor_middle_name;
	private String doctor_last_name;
	
	public DoctorProfile()
	{
		personnel_number = "";
		location_number = "";
		doctor_username = "";
		doctor_password = "";
		doctor_first_name = "";
		doctor_middle_name = "";
		doctor_last_name = "";
	}
	
	public DoctorProfile(String personnelnumber, String locationnumber, String doctorname, String doctorpassword, String doctorfirstname, 
			String doctormiddlename, String doctorlastname)
	{
		personnel_number = personnelnumber;
		location_number = locationnumber;
		doctor_username = doctorname;
		doctor_password = doctorpassword;
		doctor_first_name = doctorfirstname;
		doctor_middle_name = doctormiddlename;
		doctor_last_name = doctorlastname;
	}
	//temporary constructor
	public DoctorProfile(String username, String password, String firstname, String lastname){
		doctor_username = username;
		doctor_password = password;
		doctor_first_name = firstname;
		doctor_last_name = lastname;
	}
	//temporary constructor
	public DoctorProfile(String personnelnumber, String firstname, String lastname){
		personnel_number = personnelnumber;
		doctor_first_name = firstname;
		doctor_last_name = lastname;
	}
	
	//temporary constructor
	public DoctorProfile(String username, String password){
		doctor_username = username;
		doctor_password = password;
	}
	
	public void setPersonnelNumber(String personnelnumber)
	{
		personnel_number = personnelnumber;
	}
	
	public void setLocationNumber(String locationnumber)
	{
		location_number = locationnumber;
	}
	
	public void setDoctorUsername(String doctorusername)
	{
		doctor_username = doctorusername;
	}
	
	public void setDoctorPassword(String doctorpassword)
	{
		doctor_password = doctorpassword;
	}
	
	public void setDoctorFirstName(String doctorfirstname)
	{
		doctor_first_name = doctorfirstname;
	}
	
	public void setDoctorLastName(String doctorlastname)
	{
		doctor_last_name = doctorlastname;
	}
	
	public void setDoctorMiddleName(String doctormiddlename)
	{
		doctor_middle_name = doctormiddlename;
	}
	
	public String getPersonnelNumber()
	{
		return personnel_number;
	}
	
	public String getLocationNumber()
	{
		return location_number;
	}
	
	public String getDoctorUsername()
	{
		return doctor_username;
	}
	
	public String getDoctorPassword()
	{
		return doctor_password;
	}
	
	public String getDoctorFirstName()
	{
		return doctor_first_name;
	}
	
	public String getDoctorMiddleName()
	{
		return doctor_middle_name;
	}
	
	public String getDoctorLastName()
	{
		return doctor_last_name;
	}
	
	public String toStringDoctorName()
	{
		return doctor_last_name + ", " + doctor_first_name + " " + doctor_middle_name;
	}
		
}
