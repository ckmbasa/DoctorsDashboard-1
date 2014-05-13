/*
 *  Created By: Christian Joseph Dalisay
 *  Created On: 05/01/14
 *  Updated On: 05/06/14
 *  Data Class - This class contains variables concerning the table names 
 *  			 and its respective column name, with the table creation
 *  			 statements
 */

package com.example.database;

public class Data {

	/* --------------------------------------------------------------------------
	 * 		TABLE NAME AND COLUMN NAME KEYS 
	 * 	Note: Commented columns are already instantiated on the previous lines.
	 * --------------------------------------------------------------------------
	 */
	
	// Table Name: Client
	public static final String TABLE_CLIENT = "client";
	public static final String ID			= "id";
	public static final String CLIENT_ID	= "client_id";
	
	// Table Name: Doctor
	public static final String TABLE_DOCTOR = "doctor";
	public static final String LICENSE_NO 	= "license_no";
	public static final String PERSONNEL_ID = "personnel_id";
	public static final String DEPT_ID		= "dept_id";
	public static final String NAME_LAST 	= "name_last";
	public static final String NAME_FIRST 	= "name_first";
	public static final String NAME_MIDDLE 	= "name_middle";
	public static final String AUTH 		= "authtoken";
	public static final String ACCESS 		= "accesstoken";
	public static final String LAST_SYNC 	= "date_last_sync";
	public static final String URL 			= "base_url";
	public static final String BIRTH 		= "date_birth";
	public static final String SEX 			= "sex";
	
	// Table Name: Department
	static final String TABLE_DEPARTMENT 	= "department";
	//public static final String DEPT_ID	= "dept_id";
	public static final String ACRONYM 		= "acr_dept";
	public static final String SHORT_DEPT	= "short_dept";
	public static final String DEPT 		= "name_dept";
	
	// Table Name: Patient
	public static final String TABLE_PATIENT = "patient";
	public static final String PID 			= "pid";
	//public static final String NAME_LAST 	= "name_last";
	//public static final String NAME_FIRST = "name_first";
	//public static final String NAME_MIDDLE = "name_middle";
	//public static final String SEX		= "sex";
	//public static final String BIRTH 		= "date_birth";
	public static final String STREET 		= "street";
	public static final String CITY 		= "city";
	public static final String PROVINCE 	= "province";
	public static final String ZIPCODE 		= "zipcode";
	public static final String SMOKE 		= "history_smoking";
	public static final String DRINK 		= "history_drinking";
	
	// Table Name: Encounter
	public static final String TABLE_ENCOUNTER = "encounter";
	public static final String ENCOUNTER_ID = "encounter_id";
	//public static final String PERSONNEL_ID = "personnel_id";
	//public static final String PID 		= "pid";
	public static final String PATIENT 		= "type_patient";
	public static final String COMPLAINT 	= "message_complaint";
	public static final String ENCOUNTERED 	= "date_encountered";
	public static final String RELEASED 	= "date_released";

	
	// Table Name: Referral
	public static final String TABLE_REFERRAL = "referral";
	public static final String REFERRAL_ID 	= "referral_id";
	//public static final String ENCOUNTER_ID = "encounter_id";
	//public static final String DEPT_ID 	= "dept_id";
	public static final String REASON_ID 	= "reason_id";
	public static final String REFERRED 	= "date_referred";
	
	// Table Name: Reason
	public static final String TABLE_REASON = "reason";
	//public static final String REASON_ID 	= "reason_id";
	public static final String REASON 		= "name_reason";
	
	// Table Name: Canvass
	public static final String TABLE_CANVASS 	= "canvass";
	public static final String CANVASS_ID 		= "canvass_id";
	//public static final String ENCOUNTER_ID 	= "encounter_id";
	public static final String IMAGE 			= "uri_image";
	public static final String CANVASS 			= "type_canvass";
	public static final String UPLOADED 		= "date_uploaded";
	public static final String SYNC_CANVASS 	= "sync_canvass";

	// Table Name: LabRequest
	public static final String TABLE_LAB_REQUEST = "lab_request";
	public static final String REQUEST_ID 		= "request_id";
	//public static final String ENCOUNTER_ID 	= "encounter_id;"
	public static final String REQUESTED 		= "date_requested";
	
	// Table Name: LabService
	public static final String TABLE_LAB_SERVICE = "lab_service";
	public static final String SERVICE_ID 	= "service_id";
	public static final String SECTION	 	= "name_section";
	public static final String SERVICE 		= "name_service";
	
	// Table Name: Service_Request
	public static final String TABLE_SERVICE_REQUEST = "service_request";
	//public static final String REQUEST_ID = "request_id";
	//public static final String SERVICE_ID = "service_id";
	public static final String QUANTITY 	= "quantity";
	
	// Table Name: LabResult
	public static final String TABLE_LAB_RESULT = "lab_result";
	public static final String RESULT_ID 	= "result_id";
	//public static final String REQUEST_ID = "request_id";
	public static final String TEST 		= "name_test";
	public static final String RECEIVED 	= "date_received";
	public static final String HL7 			= "message_hl7";
	public static final String PATHO 		= "name_patho";
	
	// Table Name: Soap
	public static final String TABLE_SOAP 	= "soap";
	public static final String SOAP_ID 		= "soap_id";
	//public static final String ENCOUNTER_ID = "encounter_id";
	public static final String SOAP 		= "msg_soap";
	public static final String MODIFIED		= "date_modified";
	public static final String SYNC_SOAP	= "sync_soap";
	
	//	-----Table Creation Statements--------------
	 static final String CREATE_TABLE_CLIENT = 
		"CREATE TABLE " + TABLE_CLIENT + " ( " +
		ID + " INTEGER PRIMARY KEY DEFAULT 1 , " +
		CLIENT_ID + " TEXT UNIQUE NOT NULL" + " ) ";
	
	 static final String CREATE_TABLE_DEPARTMENT = 
		"CREATE TABLE " + TABLE_DEPARTMENT + " ( " +
		DEPT_ID 	+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		ACRONYM		+ " NVARCHAR(15), " +
		SHORT_DEPT	+ " NVARCHAR(20) UNIQUE, " 	+
		DEPT 		+ " NVARCHAR(25) UNIQUE NOT NULL " 	+ " ) ";
	
	 static final String CREATE_TABLE_DOCTOR = 
		"CREATE TABLE " + TABLE_DOCTOR + " (" +
		PERSONNEL_ID + " INTEGER PRIMARY KEY NOT NULL , " +
		LICENSE_NO	+ " NVARCHAR(10) UNIQUE NOT NULL, " +
		DEPT_ID		+ " INTEGER NOT NULL, " +
				//"REFERENCES " 	+ TABLE_DEPARTMENT + "(" + DEPT_ID + ")" + ", "	+
		NAME_LAST 	+ " NVARCHAR(20) NOT NULL, " +
		NAME_FIRST 	+ " NVARCHAR(30) NOT NULL, " +
		NAME_MIDDLE + " NVARCHAR(20) , " 		+
		AUTH 		+ " NVARCHAR(45) UNIQUE NOT NULL, " +
		ACCESS 		+ " NVARCHAR(45) UNIQUE NOT NULL, " +
		SEX 		+ " CHAR(1), " +
		BIRTH 		+ " DATE, " +
		URL 		+ " TEXT NOT NULL" 	+	" )";
	
	 static final String CREATE_TABLE_PATIENT = 
		"CREATE TABLE " + TABLE_PATIENT + " ( " +
		PID 		+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		NAME_LAST 	+ " NVARCHAR(20) NOT NULL, " +
		NAME_FIRST	+ " NVARCHAR(30) NOT NULL, " +
		NAME_MIDDLE	+ " NVARCHAR(20), " +
		SEX 		+ " CHAR(1), " 		+
		BIRTH 		+ " DATE, " 		+
		STREET 		+ " NVARCHAR(20), " +
		CITY 		+ " NVARCHAR(20), " +
		PROVINCE 	+ " NVARCHAR(20), " +
		ZIPCODE 	+ " CHAR(4), "		+
		SMOKE 		+ " BOOLEAN DEFAULT 0, "	+
		DRINK 		+ " BOOLEAN DEFAULT 0  "	+	" ) ";
		
	 static final String CREATE_TABLE_ENCOUNTER = 
		"CREATE TABLE " + TABLE_ENCOUNTER + "(" +
		ENCOUNTER_ID	+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		//LICENSE_NO 	+ " NVARCHAR(10) REFERENCES " + TABLE_DOCTOR + "(" + LICENSE_NO + ")" + ", "	+
		PERSONNEL_ID 	+ " INTEGER REFERENCES " + TABLE_DOCTOR + "(" + PERSONNEL_ID + ")" + ", "	+
		PID 		+ " INTEGER NOT NULL REFERENCES " + TABLE_PATIENT + "(" + PID + ")" + ", "	+
		PATIENT 	+ " NVARCHAR(20), " +
		COMPLAINT 	+ " TEXT, " +
		ENCOUNTERED + " DATETIME DEFAULT (DATETIME('now','unixepoch','localtime')) " + ", " + 
		RELEASED + " DATETIME DEFAULT (DATETIME('now','unixepoch','localtime')) " +	")";
	
	 static final String CREATE_TABLE_REASON = 
		"CREATE TABLE " + TABLE_REASON + "(" +
		REASON_ID 	+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		REASON 		+ " NVARCHAR(20) UNIQUE NOT NULL" 	+	")";
	
	 static final String CREATE_TABLE_REFERRAL = 
		"CREATE TABLE " + TABLE_REFERRAL + "(" +
		REFERRAL_ID 	+ " INTEGER PRIMARY KEY NOT NULL, "	+
		ENCOUNTER_ID 	+ " INTEGER NOT NULL REFERENCES "  + TABLE_ENCOUNTER + "(" + ENCOUNTER_ID + ")" + ", "	+
		DEPT_ID 		+ " INTEGER NOT NULL REFERENCES "  + TABLE_DEPARTMENT + "(" + DEPT_ID + ")" + ", "	+
		REASON_ID 		+ " INTEGER NOT NULL REFERENCES "  + TABLE_REASON + "(" + REASON_ID + ")" + ", "	+
		REFERRED 		+ " DATETIME DEFAULT (DATETIME ('now','unixepoch','localtime')) " + ")";
		
	 static final String CREATE_TABLE_CANVASS = 
		"CREATE TABLE " + TABLE_CANVASS + " ( " +
		CANVASS_ID 	+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		ENCOUNTER_ID + " INTEGER NOT NULL REFERENCES "  + TABLE_ENCOUNTER + "(" + ENCOUNTER_ID + ")" + ", "	+
		IMAGE 		+ " TEXT NOT NULL, " +
		CANVASS 	+ " NVARCHAR(20), " 		+
		UPLOADED 	+ " DATETIME DEFAULT (DATETIME ('now','unixepoch','localtime')), " 	+
		SYNC_CANVASS + " BOOLEAN NOT NULL DEFAULT 0 "+	")";
	
	 static final String CREATE_TABLE_LAB_REQUEST = 
		"CREATE TABLE " + TABLE_LAB_REQUEST + " ( " +
		REQUEST_ID 		+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		ENCOUNTER_ID 	+ " INTEGER NOT NULL REFERENCES " + TABLE_ENCOUNTER + "(" + ENCOUNTER_ID + ")" + ", " +
		REQUESTED 		+ " DATETIME NOT NULL " +	" ) ";
		
	 static final String CREATE_TABLE_LAB_SERVICE =
		"CREATE TABLE " + TABLE_LAB_SERVICE + " ( " +
		SERVICE_ID 	+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		SECTION 	+ " NVARCHAR(20) NOT NULL, " +
		SERVICE 	+ " NVARCHAR(20) NOT NULL UNIQUE " +	")";
			
	 static final String CREATE_TABLE_SERVICE_REQUEST = 
		"CREATE TABLE " + TABLE_SERVICE_REQUEST + "(" +
		SERVICE_ID 	+ " INTEGER NOT NULL REFERENCES " + TABLE_LAB_SERVICE + "(" + SERVICE_ID + ")" + ", " +
		REQUEST_ID 	+ " INTEGER NOT NULL REFERENCES " + TABLE_LAB_REQUEST + "(" + REQUEST_ID + ")" + ", " +
		QUANTITY 	+ " INTEGER NOT NULL DEFAULT 1 " +	")";
	
	 static final String CREATE_TABLE_LAB_RESULT = 
		"CREATE TABLE " + TABLE_LAB_RESULT + "(" +
		RESULT_ID 	+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		REQUEST_ID 	+ " INTEGER NOT NULL REFERENCES " 	+ TABLE_LAB_REQUEST + "(" + REQUEST_ID + ")" + ", "	+
		RECEIVED 	+ " DATETIME NOT NULL, " 	+
		TEST 		+ " NVARCHAR(20) NOT NULL, " +
		HL7 		+ " TEXT NOT NULL, " +
		PATHO 		+ " NVARCHAR(50) NOT NULL " + ")";
	
	 static final String CREATE_TABLE_SOAP = 
		"CREATE TABLE " + TABLE_SOAP + "(" +
		SOAP_ID		+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		ENCOUNTER_ID + " INTEGER NOT NULL REFERENCES " 	+ TABLE_ENCOUNTER + "(" + ENCOUNTER_ID + ")" + ", "	+
		SOAP 		+ " TEXT, " 	+ 
		MODIFIED  	+ " DATETIME DEFAULT (DATETIME ('now','unixepoch','localtime'))," +
		SYNC_SOAP 	+ " BOOLEAN DEFAULT 0" 	+ ")";
}