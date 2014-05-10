/*
 ** Created by Alvin Jay Cosare
 ** Created on 05/08/14
 ** This class handles all database processes (SELECT,POST,UPDATE,DELETE)
 *  related to Client ID generation process
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

public class ClientAdapter extends Data{
	
	
	public  SQLiteDatabase db;
	private DatabaseHandler dbHandler;
	
	private static final int 	DATABASE_VERSION	= 1;
	private static final String DATABASE_NAME 		= "localhost";
	//
	public  ClientAdapter(Context context) 
	{
		try {
			dbHandler = new DatabaseHandler(context, DATABASE_NAME, null, DATABASE_VERSION);
			Log.d("DatabaseHandler", "Database Created");
		} catch (Exception e) {
			Log.d("DatabaseHandler Exception", Log.getStackTraceString(e));
		}
	}
	
	/* Checks if a client_id already exists */
	public boolean clientIdExists(){
	
		db = dbHandler.getReadableDatabase();
		String query = 
				"SELECT " + CLIENT_ID + 
			    " FROM " + TABLE_CLIENT + 
				" WHERE id = 1"; 
		
		Cursor cursor = db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			return true;
		}
		else{
			return false;
		}
	}
	
	/*  generated client_id to mobile DB */
	public void insertClientId(String client_id){
		System.out.println("inserting client_id..");
		db = dbHandler.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		
		values.put(CLIENT_ID, client_id);
		
		db.insert(TABLE_CLIENT, null, values);
		db.close();
	}
}