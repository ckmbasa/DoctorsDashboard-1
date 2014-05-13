/*
 ** Created by Jessie Emmanuel Adante
 *** Created on 4/29/14
 ** Edited by Jose Martin Ipong - 4/29/14
 ** Updated by Christian Joseph Dalisay - 4/30/14
 
 ** DatabaseHandler - This class handles the instantiation of the database
 */

package com.example.database;


import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.example.database.Data;
import com.example.model.Age;
import com.example.model.DoctorProfile;
import com.example.model.Encounter;
import com.example.model.Patient;

public class DatabaseAdapter extends Data {
	
	
	public  SQLiteDatabase db;
	private DatabaseHandler dbHandler;
	
	private ArrayList<Patient> patients;
	private ArrayList<Encounter> encounterlist;
	
	private static final int 	DATABASE_VERSION	= 1;
	private static final String DATABASE_NAME 		= "localhost";
	
	public  DatabaseAdapter(Context context) {
		try {
			dbHandler = new DatabaseHandler(context, DATABASE_NAME, null, DATABASE_VERSION);
			Log.d("DatabaseHandler", "Database Created");
		} catch (Exception e) {
			Log.d("DatabaseHandler Exception", Log.getStackTraceString(e));
		}
	}
	
	public  DatabaseAdapter open() throws SQLException {
		db = dbHandler.getWritableDatabase();
		return this;
	}
	
	public void close() {
		db.close();
	}
	
	public  SQLiteDatabase getDatabaseInstance() {
		return db;
	}

	/*public void addDoctorProfile(DoctorProfile doctor)
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
	*/
	public Patient getPatient(int patientid){
		db = dbHandler.getWritableDatabase();
		Patient patient;
		String select = "pid, name_last, name_first, name_middle, sex, date_birth, street, city, province, zipcode";
		String table = "patient";
		String query = "SELECT " + select + " FROM " + table + " WHERE pid = " + patientid;
		Cursor cursor = db.rawQuery(query, null);
		
		if(cursor.moveToFirst()){
			int pid = Integer.parseInt(cursor.getString(cursor.getColumnIndex("pid")));
			String lastname = cursor.getString(cursor.getColumnIndex("name_last"));
			String firstname = cursor.getString(cursor.getColumnIndex("name_first"));
			String middlename = cursor.getString(cursor.getColumnIndex("name_middle"));
			String sex = cursor.getString(cursor.getColumnIndex("sex"));
			String birthdate = cursor.getString(cursor.getColumnIndex("date_birth"));
			String street = cursor.getString(cursor.getColumnIndex("street"));
			String city = cursor.getString(cursor.getColumnIndex("city"));
			String province = cursor.getString(cursor.getColumnIndex("province"));
			String zipcode = cursor.getString(cursor.getColumnIndex("zipcode"));
			
			patient = new Patient(pid, lastname, firstname, middlename, sex, birthdate, street, city, province, zipcode);
			return patient;
		}
		else{
			patient = new Patient();
			return patient;
		}
	
		
		
	}
	
	public Patient getPatientProfile(int patientid)
	{
		db 				= dbHandler.getWritableDatabase();
		String query 	= "SELECT pid, name_last, name_first, name_middle, sex, date_birth, street, city, province, zipcode  FROM patient WHERE pid = " + patientid;
		Cursor cursor 	= db.rawQuery(query, null);
		//patients 		= new ArrayList<Patient>();
		Age patientage = new Age();
		Patient patient = new Patient();
		try{
		if(cursor.moveToFirst())
		{
			do
			{
			int pid 			= cursor.getInt(cursor.getColumnIndex("pid"));
			String lastname 	= cursor.getString(cursor.getColumnIndex("name_last"));
			String firstname 	= cursor.getString(cursor.getColumnIndex("name_first"));
			String middlename 	= cursor.getString(cursor.getColumnIndex("name_middle"));
			String sex 			= cursor.getString(cursor.getColumnIndex("sex"));
			//int birthdate 	= (int)cursor.getFloat(cursor.getColumnIndex("age"));
			String date 		= cursor.getString(cursor.getColumnIndex("date_birth"));
			int age 			= patientage.getAge(date);
			String street 		= cursor.getString(cursor.getColumnIndex("street"));
			String city 		= cursor.getString(cursor.getColumnIndex("city"));
			String province 	= cursor.getString(cursor.getColumnIndex("province"));
			String zipcode 		= cursor.getString(cursor.getColumnIndex("zipcode"));
			
			patient 	= new Patient(pid, lastname, firstname, middlename, sex, age, street, city, province, zipcode);
			
			//patients.add(patient);
			
			}
			while(cursor.moveToNext());
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return patient;
	}
	//temporary update function
	/*
	 * public void updateDoctor(String personnel_id, String username, String password)
	{
		db = dbHandler.getWritableDatabase();
		String query = 
			"UPDATE " + TABLE_DOCTOR + 
			" SET " + USERNAME + " = '" + username + "', " + 
					  PASSWORD + " = '" + password + "' " +
			"WHERE " + PERSONNEL_ID + " = '" + personnel_id + "'";
		db.execSQL(query);
		
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
			
		
	}
	*/
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
	
	public ArrayList<Patient> searchPatient(String search)
	{
		 db = dbHandler.getWritableDatabase();
		
		String select = "pid, name_last, name_first, name_middle, sex, date_birth, street, city, province, zipcode";
		String table = "patient";
		String patient_first_name = "name_first";
		String patient_last_name = "name_last";
		String condition = "";
		String order = "name_last";
		Cursor cursor;
		boolean isDigit = true;
		
		if(search.equals("")){
			String query = "SELECT " + select + " FROM " + table + " ORDER BY " + order;
			cursor = db.rawQuery(query, null);
		}
		else{
			for (int i = 0; i < search.length(); i++) {
				if (!Character.isDigit(search.charAt(i))) {
					isDigit = false;
					break;
				}
			}
			
			// If patient_id is a String:
			if (isDigit) {
				condition = patient_first_name + " LIKE '%" + search + "%'";
			}
			// If patient_id is an integer:
			if (isDigit) {
				condition = patient_first_name + "=" + search;
			}
			
			// If the search is a name instead of patient_id
			else if (!isDigit) {
				String fname = "";
				String lname = "";
				
				int comma_pos = -1;
				for (int i = 0; i < search.length(); i++) {
					if (',' == search.charAt(i)) {
						comma_pos = i;
						break;
					}
				}
				if (-1 == comma_pos) {
					condition = patient_last_name + " LIKE '" + search + "%' OR " + patient_first_name + " LIKE '" + search + "%'";  
					// Comma not found; Error on search
					//Toast.makeText(this, "Error! Search should contain a comma.", Toast.LENGTH_SHORT).show();
				}
				else {
					lname = search.substring(0,comma_pos);
					fname = search.substring(comma_pos+1);
					fname = fname.trim();
					lname = lname.trim();
					
					condition = patient_last_name + " LIKE '" + lname + "%' AND " + patient_first_name + " LIKE '" + fname + "%'";
				}
			}
			
			
			
			
			//System.out.println(condition);
				String query = "SELECT " + select + " FROM " + table + " WHERE " + condition + " ORDER BY " + order;
				cursor = db.rawQuery(query, null);
			
		}
		patients = new ArrayList<Patient>();
		
			if (cursor.getCount() == 0)
			{
				
			}
			else{
				
				if (cursor.moveToFirst())
				{
					
					do
					{
						
						int pid = Integer.parseInt(cursor.getString(cursor.getColumnIndex("pid")));
						String lastname = cursor.getString(cursor.getColumnIndex("name_last"));
						String firstname = cursor.getString(cursor.getColumnIndex("name_first"));
						String middlename = cursor.getString(cursor.getColumnIndex("name_middle"));
						String sex = cursor.getString(cursor.getColumnIndex("sex"));
						String birthdate = cursor.getString(cursor.getColumnIndex("date_birth"));
						String street = cursor.getString(cursor.getColumnIndex("street"));
						String city = cursor.getString(cursor.getColumnIndex("city"));
						String province = cursor.getString(cursor.getColumnIndex("province"));
						String zipcode = cursor.getString(cursor.getColumnIndex("zipcode"));
						
						Patient patient = new Patient(pid, lastname, firstname, middlename, sex, birthdate, street, city, province, zipcode);
						
						patients.add(patient);
						
						
					}
					while (cursor.moveToNext());
				}
			}
			
		
		return patients;
	}
	
	public ArrayList<Encounter> getPatientEncounter(int patientid){
		db = dbHandler.getWritableDatabase();
		encounterlist = new ArrayList<Encounter>();
		try {
			String query = "SELECT encounter.encounter_id, encounter.date_encountered, encounter.date_released, encounter.type_patient, encounter.message_complaint, encounter.pid FROM encounter INNER JOIN patient ON encounter.pid = patient.pid WHERE patient.pid = " + patientid;
			Cursor cursor = db.rawQuery(query,  null);
			if(cursor.moveToFirst()){
				do{
					int eid = cursor.getInt(cursor.getColumnIndex("encounter_id"));
					String dateencountered = cursor.getString(cursor.getColumnIndex("date_encountered"));
					String datereleased = cursor.getString(cursor.getColumnIndex("date_released"));
					String typepatient = cursor.getString(cursor.getColumnIndex("type_patient"));
					String message = cursor.getString(cursor.getColumnIndex("message_complaint"));
					int pid = cursor.getInt(cursor.getColumnIndex("pid"));
					Encounter encounter = new Encounter(eid, typepatient, message, dateencountered, datereleased, pid);
					encounterlist.add(encounter);
				}while(cursor.moveToNext());
			}
		} catch (Exception e) {
			Log.d("getPatientEncounter", e.getMessage());
		}
		finally {
			db.close();
		}
		Log.d("getPatientEncounter", "Done successfully.");
		return encounterlist;
	}
	
	/**
	 * @author Jake Randolph B Muncada
	 * @param encounter_id
	 * @return Encounter
	 */
	public Encounter getEncounter(int encounter_id){
		db = dbHandler.getWritableDatabase();
		Encounter encounter = new Encounter();
		try {
			String query = "SELECT " +
					"encounter.encounter_id, encounter.date_encountered, encounter.date_released, encounter.type_patient, encounter.message_complaint, encounter.pid" +
					" FROM encounter " +
					"INNER JOIN patient ON encounter.pid = patient.pid " +
					"WHERE encounter.encounter_id = " + encounter_id;
			Cursor cursor = db.rawQuery(query,  null);
			if(cursor.moveToFirst()){
					int eid = cursor.getInt(cursor.getColumnIndex("encounter_id"));
					String dateencountered = cursor.getString(cursor.getColumnIndex("date_encountered"));
					String datereleased = cursor.getString(cursor.getColumnIndex("date_released"));
					String typepatient = cursor.getString(cursor.getColumnIndex("type_patient"));
					String message = cursor.getString(cursor.getColumnIndex("message_complaint"));
					int pid = cursor.getInt(cursor.getColumnIndex("pid"));
					encounter = new Encounter(eid, typepatient, message, dateencountered, datereleased, pid);
					encounterlist.add(encounter);
			}
		} catch (Exception e) {
			Log.d("getEncounter", "Something wrong.");
			Log.d("getEncounter", e.toString());
		}
		finally {
			db.close();
		}
		Log.d("getEncounter", "Done successfully.");
		return encounter;
	}

	/**
	 * @author Jake Randolph B Muncada
	 * @param patient_id
	 * @param date_encountered
	 * @return Encounter
	 */
	public ArrayList<Encounter> getPreviousEncounter(int patient_id, String date_encountered){
		db = dbHandler.getWritableDatabase();
		encounterlist = new ArrayList<Encounter>();
		try {
			String query = "SELECT " +
					"encounter.encounter_id, encounter.date_encountered, encounter.date_released, encounter.type_patient, encounter.message_complaint, encounter.pid" +
					" FROM encounter " +
					"INNER JOIN patient ON encounter.pid = patient.pid " +
					"WHERE patient.pid = " + patient_id + " " +
						"AND " + ENCOUNTERED + " < '" + date_encountered + "'";
			Cursor cursor = db.rawQuery(query,  null);
			Encounter encounter = new Encounter();
			if(cursor.moveToFirst()){
				do {
					int eid = cursor.getInt(cursor.getColumnIndex("encounter_id"));
					String dateencountered = cursor.getString(cursor.getColumnIndex("date_encountered"));
					String datereleased = cursor.getString(cursor.getColumnIndex("date_released"));
					String typepatient = cursor.getString(cursor.getColumnIndex("type_patient"));
					String message = cursor.getString(cursor.getColumnIndex("message_complaint"));
					int pid = cursor.getInt(cursor.getColumnIndex("pid"));
					encounter = new Encounter(eid, typepatient, message, dateencountered, datereleased, pid);
					encounterlist.add(encounter);
				} while (cursor.moveToNext());
			}
		} catch (Exception e) {
			Log.d("getPreviousEncounters", "Something wrong.");
		} finally {
			db.close();
		}
		Log.d("getPreviousEncounters", "Done successfully.");
		return encounterlist;
	}
}