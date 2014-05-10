/*
 ** Created by Alvin Jay Cosare
 ** Created on 05/07/14
 ** This class handles all database processes (SELECT,POST,UPDATE,DELETE)
 *  related to Registration process
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

public class RegistrationAdapter extends Data{
	
	
	public  SQLiteDatabase db;
	private DatabaseHandler dbHandler;
	
	private static final int 	DATABASE_VERSION	= 1;
	private static final String DATABASE_NAME 		= "localhost";
	//
	public  RegistrationAdapter(Context context) 
	{
		try {
			dbHandler = new DatabaseHandler(context, DATABASE_NAME, null, DATABASE_VERSION);
			Log.d("DatabaseHandler", "Database Created");
		} catch (Exception e) {
			Log.d("DatabaseHandler Exception", Log.getStackTraceString(e));
		}
	}
	
	public String getClientId(){
		//Add code for query getting number of accounts in mobile DB
		
		db = dbHandler.getWritableDatabase();
		
		String query = 
			"SELECT " + CLIENT_ID +
			" FROM " + TABLE_CLIENT + 
			" WHERE id = 1";
		
		
		Cursor cursor = db.rawQuery(query, null);
		cursor.moveToFirst();
		
		System.out.println(cursor.getString(0));
		return cursor.getString(0);
	}
	
	
	public String getBaseURL(String license_nr){

		db = dbHandler.getWritableDatabase();
		
		String query = 
			"SELECT " + URL + 
			" FROM " + TABLE_DOCTOR + 
			" WHERE " + LICENSE_NO + " = '" + license_nr + "'";
		
		Cursor cursor = db.rawQuery(query, null);
		System.out.println(cursor.getString(0));
		
		return cursor.getString(0);
	}
	
	/*From old version
	public void setClientId(String client_id){
	
		db = dbHandler.getWritableDatabase();
		String query = 
			"INSERT into " + TABLE_CLIENT + " (client_id) VALUES (" + client_id + ")";
		
		System.out.println("insert client");
		db.execSQL(query);
	} */
	
	
}