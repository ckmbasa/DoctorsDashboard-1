/*
 ** Created by Jessie Emmanuel Adante
 ** Created on 4/24/14
 ** This class retrieves the service info
 */

package com.example.model;

public class ServiceRequest 
{
	private int service_code;
	private int request_number;
	private int service_quantity;
	
	public ServiceRequest()
	{
		service_code = 0;
		request_number = 0;
		service_quantity = 0;
	}
	
	public ServiceRequest(int servicecode, int requestnumber, int servicequantity)
	{
		service_code = servicecode;
		request_number = requestnumber;
		service_quantity = servicequantity;
	}
	
	public void setServiceCode(int servicecode)
	{
		service_code = servicecode;
	}
	
	public void setRequestNumber(int requestnumber)
	{
		request_number = requestnumber;
	}
	
	public void setServiceQuantity(int servicequantity)
	{
		service_quantity = servicequantity;
	}
	
	public int getServiceCode()
	{
		return service_code;
	}
	
	public int getRequestNumber()
	{
		return request_number;
	}
	
	public int getServiceQuantity()
	{
		return service_quantity;
	}
}
