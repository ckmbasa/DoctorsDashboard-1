/*
 *  Created By: Christian Joseph Dalisay
 *  Created On: 05/01/14
 *  Data Class - class contains the table names and its respective column name
 */

package com.example.database;

public class Data {

	/* --------------------------------------------------------------------------
	 * 		TABLE NAME AND COLUMN NAME KEYS 
	 * 	Note: Commented columns are already instantiated on the previous lines.
	 * --------------------------------------------------------------------------
	 */
	
	// Table Name: Doctor
	public static final String TABLE_DOCTOR 	= "doctor";
	public static final String PERSONNEL_ID 	= "personnel_id";
	public static final String DEPT_ID		= "dept_id";
	public static final String DNAME_LAST 	= "name_last";
	public static final String DNAME_FIRST 	= "name_first";
	public static final String DNAME_MIDDLE 	= "name_middle";
	public static final String USERNAME 		= "username";
	public static final String PASSWORD 		= "password";

	// Table Name: Department
	static final String TABLE_DEPARTMENT = "department";
	//public static final String DEPT_ID	= "dept_id";
	public static final String SHORT_DEPT	= "short_dept";
	public static final String DEPT 		= "name_dept";
	
	// Table Name: Patient
	public static final String TABLE_PATIENT = "patient";
	public static final String PID 			= "pid";
	public static final String PNAME_LAST 	= "name_last";
	public static final String PNAME_FIRST 	= "name_first";
	public static final String PNAME_MIDDLE 	= "name_middle";
	public static final String SEX			= "sex";
	public static final String BIRTH 		= "date_birth";
	public static final String STREET 		= "street";
	public static final String CITY 			= "city";
	public static final String PROVINCE 		= "province";
	public static final String ZIPCODE 		= "zipcode";
	
	
	// Table Name: Encounter
	public static final String TABLE_ENCOUNTER = "encounter";
	public static final String ENCOUNTER_ID 	= "encounter_id";
	//public static final String PID 		= "pid";
	public static final String PATIENT 		= "type_patient";
	public static final String COMPLAINT 	= "message_complaint";
	public static final String ENCOUNTERED 	= "date_encountered";
	public static final String RELEASED 		= "date_released";

	
	// Table Name: Referral
	public static final String TABLE_REFERRAL = "referral";
	public static final String REFERRAL_ID 	= "referral_id";
	//public static final String ENCOUNTER_ID = "encounter_id";
	//public static final String DEPT_ID 	= "dept_id";
	public static final String REASON_ID 	= "reason_id";
	public static final String REFERRED 		= "date_referred";
	
	// Table Name: Reason
	public static final String TABLE_REASON 	= "reason";
	//public static final String REASON_ID 	= "reason_id";
	public static final String REASON 		= "name_reason";
	
	// Table Name: Canvass
	public static final String TABLE_CANVASS 	= "canvass";
	public static final String CANVASS_ID 		= "canvass_id";
	//public static final String ENCOUNTER_ID 	= "encounter_id";
	public static final String IMAGE 			= "uri_image";
	public static final String CANVASS 		= "type_canvass";
	public static final String UPLOADED 		= "date_uploaded";

	
	// Table Name: LabRequest
	public static final String TABLE_LAB_REQUEST = "lab_request";
	public static final String REQUEST_ID 		= "request_id";
	//public static final String ENCOUNTER_ID 	= "encounter_id;"
	public static final String REQUESTED 		= "date_requested";
	
	// Table Name: LabService
	public static final String TABLE_LAB_SERVICE = "lab_service";
	public static final String SERVICE_ID 	= "service_id";
	public static final String SECTION	 	= "section_name";
	public static final String SERVICE 	= "service_name";
	
	// Table Name: Service_Request
	public static final String TABLE_SERVICE_REQUEST = "service_request";
	//public static final String REQUEST_ID 	= "request_id";
	//public static final String SERVICE_ID 	= "service_id";
	public static final String QUANTITY 		= "quantity";
	
	// Table Name: LabResult
	public static final String TABLE_LAB_RESULT = "lab_result";
	public static final String RESULT_ID 	= "result_id";
	//public static final String REQUEST_ID 	= "request_id";
	public static final String TEST 			= "name_test";
	public static final String RECEIVED 		= "date_received";
	public static final String HL7 			= "message_hl7";
	public static final String PATHO 		= "name_patho";
	
	// Table Name: Soap
	public static final String TABLE_SOAP = "soap";
	public static final String SOAP_ID 	= "soap_id";
	public static final String SOAP_S 	= "msg_s";
	public static final String SOAP_O 	= "msg_o";
	public static final String SOAP_A 	= "msg_a";
	public static final String SOAP_P 	= "msg_p";
	public static final String MODIFIED	= "date_modified";

}
