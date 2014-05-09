/*
 ** Created by Jessie Emmanuel Adante
 ** Created on 4/24/14
 ** This class retrieves the department details
 */

package com.example.model;

public class Department 
{
	private int department_number;
	private int department_id;
	private String department_name;
	
	public Department()
	{
		department_number = 0;
		department_id = 0;
		department_name = "";
	}
	
	public Department(int departmentnumber, int departmentid, String departmentname)
	{
		department_number = departmentnumber;
		department_id = departmentid;
		department_name = departmentname;
	}
	
	public void setDepartmentNumber(int departmentnumber)
	{
		department_number = departmentnumber;
	}
	
	public void setDepartmentId(int departmentid)
	{
		department_id = departmentid;
	}
	
	public void setDepartmentName(String departmentname)
	{
		department_name = departmentname;
	}
	
	public int getDepartmentNumber()
	{
		return department_number;
	}
	
	public int getDepartmentId()
	{
		return department_id;
	}
	
	public String getDepartmentName()
	{
		return department_name;
	}
}
