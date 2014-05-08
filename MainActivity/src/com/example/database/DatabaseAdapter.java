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

public class DatabaseAdapter extends Data {
	
	
	public  SQLiteDatabase db;
	private DatabaseHandler dbHandler;
	
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
	
	public void addDoctorProfile(DoctorProfile doctor){
		
		db = dbHandler.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(PERSONNEL_ID, doctor.getPersonnelNumber());
		values.put(DEPT_ID, doctor.getLocationNumber());
		values.put(USERNAME, doctor.getDoctorUsername());
		values.put(PASSWORD, doctor.getDoctorPassword());
		values.put(NAME_FIRST, doctor.getDoctorFirstName());
		values.put(NAME_MIDDLE, doctor.getDoctorMiddleName());
		values.put(NAME_LAST, doctor.getDoctorLastName());
		
		db.insert(TABLE_DOCTOR, null, values);
		db.close();
	}
	
	public boolean ifExists(String personnelnumber){
		db = dbHandler.getWritableDatabase();
		String query = 
			"SELECT " +
				PERSONNEL_ID + ", " + 
				NAME_FIRST + ", " + 
				NAME_LAST + " " + 
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
				NAME_FIRST + ", " + 
				NAME_LAST + " " + 
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
		values.put(NAME_FIRST, doctor.getDoctorFirstName());
		values.put(doctor_middle_name, doctor.getDoctorMiddleName());
		values.put(NAME_LAST, doctor.getDoctorLastName());
		
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
					LICENSE_NO		+ ", "	+
					PATIENT			+ ", " 	+
					COMPLAINT 		+ ", " 	+
					ENCOUNTERED 	+ ", " 	+	
					RELEASED 		+ ", "	+
					NAME_LAST		+ ", " 	+
					NAME_FIRST		+ ", " 	+
					NAME_MIDDLE	+ ", " 	+
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

	public void storeToken(String rToken) {
		try {
			db = dbHandler.getWritableDatabase();
			
			DoctorProfile doctor = null;
			ContentValues values = new ContentValues();
			values.put(PERSONNEL_ID, doctor.getPersonnelNumber());
			values.put(DEPT_ID, doctor.getLocationNumber());
			values.put(NAME_FIRST, doctor.getDoctorFirstName());
			values.put(NAME_MIDDLE, doctor.getDoctorMiddleName());
			values.put(NAME_LAST, doctor.getDoctorLastName());
			
			db.update(TABLE_DOCTOR, values, PERSONNEL_ID + " = ?",
					new String[] { String.valueOf(doctor.getPersonnelNumber())});
				
		}catch (SQLException SQLe) {
			Log.v("DatabaseAdapter SQLException" , Log.getStackTraceString(SQLe));
		} 
		catch (Exception e) {
			Log.v("DatabaseAdapter Exception" , Log.getStackTraceString(e));
		} 
		finally  {
			db.close();
		}
	}
}