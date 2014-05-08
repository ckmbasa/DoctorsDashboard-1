/*
 ** Created by Jessie Emmanuel Adante
 *** Created on 4/29/14
 ** Edited by Jose Martin Ipong - 4/29/14
 ** Edited by Christian Joseph Dalisay - 4/30/14
 
 ** DatabaseHandler - handles the CRUD Operations, 
 *					  and auxiliary database functions/queries
 */

package com.example.database;


import java.util.ArrayList;

import com.example.model.DoctorProfile;
import com.example.model.Encounter;
import com.example.model.Patient;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.example.database.Data;

public class DatabaseAdapter extends Data{
	
	
	public  SQLiteDatabase db;
	private DatabaseHandler dbHandler;
	
	private static final int 	DATABASE_VERSION	= 1;
	private static final String DATABASE_NAME 		= "localhost";
	//
	public  DatabaseAdapter(Context context) 
	{
		
		try {
			dbHandler = new DatabaseHandler(context, DATABASE_NAME, null, DATABASE_VERSION);
			Log.d("DatabaseHandler", "Database Created");
		} catch (Exception e) {
			Log.d("DatabaseHandler Exception", Log.getStackTraceString(e));
		}
	}
	
	public  DatabaseAdapter open() throws SQLException 
	{
		db = dbHandler.getWritableDatabase();
		return this;
	}
	
	public void close() 
	{
		db.close();
	}
	
	public  SQLiteDatabase getDatabaseInstance()
	{
		return db;
	}
	

	//		-----Table Creation Statements--------------
	
	 static final String CREATE_TABLE_DEPARTMENT = 
		"CREATE TABLE " + TABLE_DEPARTMENT + " ( " +
		DEPT_ID 	+ " INTEGER PRIMARY KEY NOT NULL, " +
		SHORT_DEPT	+ " VARCHAR(50) UNIQUE, " 	+
		DEPT 		+ " VARCHAR(50) UNIQUE  " 	+ " ) ";
	
	 static final String CREATE_TABLE_DOCTOR = 
		"CREATE TABLE " + TABLE_DOCTOR + " (" +
		PERSONNEL_ID 	+ " INTEGER PRIMARY KEY NOT NULL, "	+
		DEPT_ID			+ " INTEGER NOT NULL REFERENCES " 	+ TABLE_DEPARTMENT + "(" + DEPT_ID + ")" + ", "	+
		DNAME_LAST 		+ " VARCHAR(50), " 	+
		DNAME_FIRST 	+ " VARCHAR(50), " 	+
		DNAME_MIDDLE 	+ " VARCHAR(50), " 	+
		USERNAME 		+ " VARCHAR(50) UNIQUE, " 	+
		PASSWORD 		+ " VARCHAR(50)" 	+ 	" )";
	
	 static final String CREATE_TABLE_PATIENT = 
		"CREATE TABLE " + TABLE_PATIENT + " ( " +
		PID 			+ " INTEGER PRIMARY KEY NOT NULL, " +
		PNAME_LAST 		+ " VARCHAR(50), " 	+
		PNAME_FIRST		+ " VARCHAR(50), " 	+
		PNAME_MIDDLE	+ " VARCHAR(50), " 	+
		SEX 			+ " VARCHAR(50), " 	+
		BIRTH 			+ " DATETIME, " 	+
		STREET 			+ " VARCHAR(50), " 	+
		CITY 			+ " VARCHAR(50), " 	+
		PROVINCE 		+ " VARCHAR(50), " 	+
		ZIPCODE 		+ " VARCHAR(50)"	+	" ) ";
		
	 static final String CREATE_TABLE_ENCOUNTER = 
		"CREATE TABLE " + TABLE_ENCOUNTER + "(" +
		ENCOUNTER_ID	+ " INTEGER PRIMARY KEY NOT NULL, " +
		PID 			+ " INTEGER NOT NULL REFERENCES " + TABLE_PATIENT + "(" + PID + ")" + ", "	+
		PATIENT 		+ " VARCHAR(50), " 	+
		COMPLAINT 		+ " VARCHAR(50), " 	+
		ENCOUNTERED 	+ " DATETIME, " 	+
		RELEASED	 	+ " DATETIME "		+
		")";
	
	 static final String CREATE_TABLE_REASON = 
		"CREATE TABLE " + TABLE_REASON + "(" +
		REASON_ID 	+ " INTEGER PRIMARY KEY NOT NULL, " +
		REASON 		+ " VARCHAR(50) NOT NULL UNIQUE" 	+
		")";
	
	 static final String CREATE_TABLE_REFERRAL = 
		"CREATE TABLE " + TABLE_REFERRAL + "(" +
		REFERRAL_ID 	+ " INTEGER PRIMARY KEY NOT NULL, "	+
		ENCOUNTER_ID 	+ " INTEGER NOT NULL REFERENCES "  + TABLE_ENCOUNTER + "(" + ENCOUNTER_ID + ")" + ", "	+
		DEPT_ID 		+ " INTEGER NOT NULL REFERENCES "  + TABLE_DEPARTMENT + "(" + DEPT_ID + ")" + ", "	+
		REASON_ID 		+ " INTEGER NOT NULL REFERENCES "  + TABLE_REASON + "(" + REASON_ID + ")" + ", "	+
		REFERRED 		+ " DATETIME " 	+	")";
		
	 static final String CREATE_TABLE_CANVASS = 
		"CREATE TABLE " + TABLE_CANVASS + " ( " +
		CANVASS_ID 	+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		IMAGE 		+ " VARCHAR(50) NOT NULL, " +
		CANVASS 	+ " VARCHAR(50), " 			+
		UPLOADED 	+ " DATETIME " 	+	")";
	
	 static final String CREATE_TABLE_LAB_REQUEST = 
		"CREATE TABLE " + TABLE_LAB_REQUEST + " ( " +
		REQUEST_ID 		+ " INTEGER PRIMARY KEY NOT NULL, " +
		ENCOUNTER_ID 	+ " INTEGER NOT NULL REFERENCES " + TABLE_ENCOUNTER + "(" + ENCOUNTER_ID + ")" + ", " +
		REQUESTED 		+ " DATETIME NOT NULL " +	" ) ";
		
	 static final String CREATE_TABLE_LAB_SERVICE =
		"CREATE TABLE " + TABLE_LAB_SERVICE + " ( " +
		SERVICE_ID 		+ " INTEGER PRIMARY KEY NOT NULL, " +
		SECTION 		+ " VARCHAR(50) NOT NULL, " +
		SERVICE 		+ " VARCHAR(50) NOT NULL UNIQUE " +	")";
			
	 static final String CREATE_TABLE_SERVICE_REQUEST = 
		"CREATE TABLE " + TABLE_SERVICE_REQUEST + "(" +
		SERVICE_ID 		+ " INTEGER NOT NULL REFERENCES " + TABLE_LAB_SERVICE + "(" + SERVICE_ID + ")" + ", " +
		REQUEST_ID 		+ " INTEGER NOT NULL REFERENCES " + TABLE_LAB_REQUEST + "(" + REQUEST_ID + ")" + ", " +
		QUANTITY 		+ " INTEGER DEFAULT '1' " +	")";

	 static final String CREATE_TABLE_LAB_RESULT = 
		"CREATE TABLE " + TABLE_LAB_RESULT + "(" +
		RESULT_ID 	+ " INTEGER PRIMARY KEY NOT NULL, " +
		REQUEST_ID 	+ " INTEGER NOT NULL REFERENCES " 	+ TABLE_LAB_REQUEST + "(" + REQUEST_ID + ")" + ", "	+
		RECEIVED 	+ " DATETIME NOT NULL, " 	+
		TEST 		+ " VARCHAR(50) NOT NULL, " +
		HL7 		+ " VARCHAR(50) NOT NULL, " +
		PATHO 		+ " VARCHAR(50) NOT NULL " 	+ ")";

	 static final String CREATE_TABLE_SOAP = 
		"CREATE TABLE " + TABLE_SOAP + "(" +
		SOAP_ID	+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		ENCOUNTER_ID + " INTEGER NOT NULL REFERENCES " 	+ TABLE_ENCOUNTER + "(" + ENCOUNTER_ID + ")" + ", "	+
		SOAP_S 	+ " VARCHAR(50), " 	+ 
		SOAP_O 	+ " VARCHAR(50), "	+
		SOAP_A 	+ " VARCHAR(50), " 	+ 
		SOAP_P 	+ " VARCHAR(50), " 	+
		MODIFIED  + " DATETIME NOT NULL"	+ ")";

	public void addDoctorProfile(DoctorProfile doctor)
	{
		db = dbHandler.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(PERSONNEL_ID, doctor.getPersonnelNumber());
		values.put(DEPT_ID, doctor.getLocationNumber());
		values.put(USERNAME, doctor.getDoctorUsername());
		values.put(PASSWORD, doctor.getDoctorPassword());
		values.put(DNAME_FIRST, doctor.getDoctorFirstName());
		values.put(DNAME_MIDDLE, doctor.getDoctorMiddleName());
		values.put(DNAME_LAST, doctor.getDoctorLastName());
		
		db.insert(TABLE_DOCTOR, null, values);
		db.close();
	}
	
	public boolean ifExists(String personnelnumber){
		db = dbHandler.getWritableDatabase();
		String query = 
			"SELECT " +
				PERSONNEL_ID + ", " + 
				DNAME_FIRST + ", " + 
				DNAME_LAST + " " + 
			" FROM " + TABLE_DOCTOR +
			" WHERE " + 
				PERSONNEL_ID + " = " + "'" + personnelnumber + "'";
		Cursor cursor = db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			return true;
		}
		else{
			return false;
		}
	
	
	}
	
	public DoctorProfile getDoctor(String personnelnumber){
		DoctorProfile doctor = new DoctorProfile("username", "password", "firstname", "lastname");
		db = dbHandler.getWritableDatabase();
		String query = 
			"SELECT " +
				PERSONNEL_ID + ", " + 
				DNAME_FIRST + ", " + 
				DNAME_LAST + " " + 
			" FROM " + TABLE_DOCTOR +
			" WHERE " + 
				PERSONNEL_ID + " = " +  "'" + personnelnumber + "'";
		Cursor cursor = db.rawQuery(query, null);
		if (cursor.moveToFirst()) {
    		do {
            	try{
	                DoctorProfile doctor1 = new DoctorProfile(cursor.getString(0), cursor.getString(1), cursor.getString(2));
	                if(doctor1.getPersonnelNumber().equals(personnelnumber)){
	                	return doctor1;
	                }
	                
            	}
            	catch(Exception e){
            		System.out.println(e);
            		return doctor;
            	}
                
            } while (cursor.moveToNext());
        }
    	
		
		
		return doctor;
	}
	//temporary update function
	public void updateDoctor(String personnel_id, String username, String password)
	{
		db = dbHandler.getWritableDatabase();
		String query = 
			"UPDATE " + TABLE_DOCTOR + 
			" SET " + USERNAME + " = '" + username + "', " + 
					  PASSWORD + " = '" + password + "' " +
			"WHERE " + PERSONNEL_ID + " = '" + personnel_id + "'";
		db.execSQL(query);
		/*
		ContentValues values = new ContentValues();
		values.put(PERSONNEL_ID, doctor.getPersonnelNumber());
		values.put(location_number, doctor.getLocationNumber());
		values.put(doctor_username, doctor.getDoctorUsername());
		values.put(doctor_password, doctor.getDoctorPassword());
		values.put(DNAME_FIRST, doctor.getDoctorFirstName());
		values.put(doctor_middle_name, doctor.getDoctorMiddleName());
		values.put(DNAME_LAST, doctor.getDoctorLastName());
		
		return db.update(TABLE_DOCTOR, values, PERSONNEL_ID + " = ?",
				new String[] { String.valueOf(doctor.getPersonnelNumber())});
			*/
		
	}
	
	public boolean checkDoctorCredentials(String username, String password){
		db = dbHandler.getWritableDatabase();
		String query = 
			"SELECT username, password FROM " + TABLE_DOCTOR + " WHERE username = '" + username + "' AND password = '" + password + "'";
		Cursor cursor = db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public ArrayList<Encounter> getEncountersFromPatients() {
		/*
		 * Created By: Dalisay, Christian Joseph
		 * Created On: 04/29/2014
		 */
		ArrayList<Encounter> record = new ArrayList<Encounter>();
		db = dbHandler.getWritableDatabase();
		
		try {
			String query = 	
				"SELECT * " + 
					/*
					ENCOUNTER_ID 	+ ", " 	+
					PID				+ ", "	+
					PATIENT			+ ", " 	+
					COMPLAINT 		+ ", " 	+
					ENCOUNTERED 	+ ", " 	+	
					RELEASED 		+ ", "	+
					PNAME_LAST		+ ", " 	+
					PNAME_FIRST		+ ", " 	+
					PNAME_MIDDLE	+ ", " 	+
					SEX				+ ", " 	+
					DATE_BIRTH		+ ", " 	+
					STREET			+ ", " 	+
					CITY			+ ", " 	+
					PROVINCE		+ ", " 	+
					ZIPCODE			+ "  " 	+
					 */
				"FROM " + TABLE_ENCOUNTER + " " +
					"JOIN " + TABLE_PATIENT	+ " " +
						"USING" + "(" + PID + ") " +
				"ORDER BY (" + PID + ")";
			
				
			Cursor cursor = db.rawQuery(query, null);
			if(cursor != null && cursor.moveToFirst()) {
				do	{
					Patient rPatient = new Patient();
					Encounter rEncounter = new Encounter(rPatient); 
					
					rEncounter.setEncounterId(cursor.getInt(0));
					rEncounter.setNameLast(cursor.getString(1));
					rEncounter.setNameFirst(cursor.getString(2));
					rEncounter.setDateEncountered(cursor.getString(3));
					rEncounter.setTypePatient(cursor.getString(4));
					rEncounter.setMessageComplaint(cursor.getString(5));
					rEncounter.setDateReleased(cursor.getString(6));
					
					record.add(rEncounter);
				} while (cursor.moveToNext());
			}
			
			Log.d("DatabaseHandler", "Successful getEncountersFromPatients");

			return record;
		} 
		catch (SQLException SQLe) {
			Log.v("DatabaseHandler" , Log.getStackTraceString(SQLe));
		} 
		catch (Exception e) {
			Log.v("DatabaseHandler" , Log.getStackTraceString(e));
		} 
		finally  {
			db.close();
		}
		
		return record;
	}

	
}

