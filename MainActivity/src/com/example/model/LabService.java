/*
 ** Created by Jessie Emmanuel Adante
 ** Created on 4/24/14
 ** This class retrieves the lab's info
 */

package com.example.model;

public class LabService 
{
	private int service_code;
	private int section_code;
	private String lab_service_name;
	private String lab_section_name;
	
	public LabService()
	{
		service_code = 0;
		section_code = 0;
		lab_service_name = "";
		lab_section_name = "";
	}
	
	public LabService(int servicecode, int sectioncode, String labservicename, String labsectionname)
	{
		service_code = servicecode;
		section_code = sectioncode;
		lab_service_name = labservicename;
		lab_section_name = labsectionname;
	}
	
	public void setServiceCode(int servicecode)
	{
		service_code = servicecode;
	}
	
	public void setSectionCode(int sectioncode)
	{
		section_code = sectioncode;
	}
	
	public void setLabServiceName(String labservicename)
	{
		lab_service_name = labservicename;
	}
	
	public void setLabSectionName(String labsectionname)
	{
		lab_section_name = labsectionname;
	}
	
	public int getServiceCode()
	{
		return service_code;
	}
	
	public int getSectionCode()
	{
		return section_code;
	}
	
	public String getLabServiceName()
	{
		return lab_service_name;
	}
	
	public String getLabSectionName()
	{
		return lab_section_name;
	}
}
