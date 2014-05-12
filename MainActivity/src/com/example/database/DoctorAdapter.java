/*
 * Created By: Christian Joseph Dalisay
 * Created On: 5/9/14
 * DoctorAdapter - this class handles the database functions for the table doctor
 */


package com.example.database;

import com.example.model.Doctor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.database.Data;

public class DoctorAdapter extends Data{
	
	
	public  SQLiteDatabase db;
	private DatabaseHandler dbHandler;
	protected Cursor cursor;
	
	private static final int 	DATABASE_VERSION	= 1;
	private static final String DATABASE_NAME 		= "localhost";
	//
	public  DoctorAdapter(Context context) 
	{
		try {
			dbHandler = new DatabaseHandler(context, DATABASE_NAME, null, DATABASE_VERSION);
			Log.d("TokenAdapter", "Database Created");
		} catch (Exception e) {
			Log.d("DatabaseHandler Exception", Log.getStackTraceString(e));
		}
	}
	
	//This function adds the values of the doctor into the table
	public void addDoctor(Doctor doctor)
	{
		db = dbHandler.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(PERSONNEL_ID, doctor.getPersonnelId());
		values.put(LICENSE_NO, doctor.getLicenseNo());
		values.put(DEPT_ID, doctor.getDeptId());
		values.put(AUTH, doctor.getAuthToken());
		values.put(ACCESS, doctor.getAccessToken());
		values.put(NAME_FIRST, doctor.getNameFirst());
		values.put(NAME_MIDDLE, doctor.getNameMiddle());
		values.put(NAME_LAST, doctor.getNameLast());
		values.put(URL, doctor.getBaseUrl());
		values.put(BIRTH, doctor.getBirthDate());
		values.put(SEX, doctor.getSex());
		
		try {
			db.insert(TABLE_DOCTOR, null, values);
			db.close();
		}
		catch (SQLException se) {
			Log.d("DoctorAdapter addDoctor",Log.getStackTraceString(se));
		}
	}
	
	//This function updates the last manual sync made by the doctor
	public void setLastSync(String license) {
		db = dbHandler.getWritableDatabase();
		
		String query = "UPDATE " + TABLE_DOCTOR + 
						" SET " + LAST_SYNC + " = " + "''" +
						" WHERE " + LICENSE_NO + " = " + license;
		try {
			db.execSQL(query);
		}
		catch (SQLException se) {
			Log.d("DoctorAdapter setLastSync",Log.getStackTraceString(se));
		}
	}
	
	//This function checks if a doctor exists using his/her license
	public boolean isDoctorExists(String license)	{
		db = dbHandler.getReadableDatabase();
		
		String query=
				" SELECT count(" + LICENSE_NO + ")" +
				" FROM " + TABLE_DOCTOR + 
				" WHERE license_no = " + license;
		try {
			cursor = db.rawQuery(query, null);
		}
		catch (SQLException se) {
			Log.d("DoctorAdapter setLastSync",Log.getStackTraceString(se));
		}
		cursor.moveToFirst();
		System.out.println(cursor.getInt(0));
		if(cursor.getInt(0) > 0)
			return true;
		else
			return false;
	}
}
