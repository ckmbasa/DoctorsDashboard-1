/*
 ** Created by Jessie Emmanuel Adante
 ** Created on 4/24/14
 ** This class retrieves the patient's personal profile
*/

package com.example.model;

public class PatientProfile 
{
	private int patient_id;
	private String patient_first_name;
	private String patient_middle_name;
	private String patient_last_name;
	private String date_of_birth;
	private String sex_of_patient;
	private String patient_street;
	private String patient_city;
	private String patient_province;
	private int patient_zipcode;
	
	public PatientProfile()
	{
		patient_id = 0;
		patient_first_name = "";
		patient_middle_name = "";
		patient_last_name = "";
		date_of_birth = "";
		sex_of_patient = "";
		patient_street = "";
		patient_city = "";
		patient_province = "";
		patient_zipcode = 0;
	}
	
	public PatientProfile(int patientid, String patientfirstname, String patientmiddlename,
			String patientlastname, String dateofbirth, String sexofpatient, String street,
			String city, String province, int zipcode)
	{
		patient_id = patientid;
		patient_first_name = patientfirstname;
		patient_middle_name = patientmiddlename;
		patient_last_name = patientlastname;
		date_of_birth = dateofbirth;
		sex_of_patient = sexofpatient;
		patient_street = street;
		patient_city = city;
		patient_province = province;
		patient_zipcode = zipcode;
	}
	
	public void setPatientId(int patientid)
	{
		patient_id = patientid;
	}
	
	public void setPatientFirstName(String patientfirstname)
	{
		patient_first_name = patientfirstname;
	}
	
	public void setPatientMiddleName(String patientmiddlename)
	{
		patient_middle_name = patientmiddlename;
	}
	
	public void setPatientLastName(String patientlastname)
	{
		patient_last_name = patientlastname;
	}
	
	public void setDateOfBirth(String dateofbirth)
	{
		date_of_birth = dateofbirth;
	}
	
	public void setSexOfPatient(String sexofpatient)
	{
		sex_of_patient = sexofpatient;
	}
	
	public void setPatientStreet(String street)
	{
		patient_street = street;
	}
	
	public void setPatientCity(String city)
	{
		patient_city = city;
	}
	
	public void setPatientProvince(String province)
	{
		patient_province = province;
	}
	
	public void setPatientZipcode(int zipcode)
	{
		patient_zipcode = zipcode;
	}
	
	public int getPatinetId()
	{
		return patient_id;
	}
	
	public String getPatientFirstName()
	{
		return patient_first_name;
	}
	
	public String getPatientMiddleName()
	{
		return patient_middle_name;
	}
	
	public String getPatientLastName()
	{
		return patient_last_name;
	}
	
	public String getDateOfBirth()
	{
		return date_of_birth;
	}
	
	public String getSexOfPatient()
	{
		return sex_of_patient;
	}
	
	public String getPatientStreet()
	{
		return patient_street;
	}
	
	public String getPatientCity()
	{
		return patient_city;
	}
	
	public String getPatientProvince()
	{
		return patient_province;
	}
	
	public int getPAtientZipcode()
	{
		return patient_zipcode;
	}
	
	public String toStringPatientName()
	{
		return patient_last_name + ", " + patient_first_name + " " + patient_middle_name;
	}
	
	public String toStringPatientAddress()
	{
		return patient_street + ", " + patient_city + " " + patient_province + " " + patient_zipcode;
	}

}
