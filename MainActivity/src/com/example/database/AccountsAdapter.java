/*
 ** Created by Alvin Jay Cosare
 ** Created on 05/07/14
 ** This class handles all database processes (SELECT,POST,UPDATE,DELETE)
 *  related to Accounts
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

public class AccountsAdapter extends Data{
	
	
	public  SQLiteDatabase db;
	private DatabaseHandler dbHandler;
	
	private static final int 	DATABASE_VERSION	= 1;
	private static final String DATABASE_NAME 		= "localhost";
	//
	public  AccountsAdapter(Context context) 
	{
		
		try {
			dbHandler = new DatabaseHandler(context, DATABASE_NAME, null, DATABASE_VERSION);
			Log.d("DatabaseHandler", "Database Created");
		} catch (Exception e) {
			Log.d("DatabaseHandler Exception", Log.getStackTraceString(e));
		}
	}
	
	public int getAccounts(){
		//Add code here for query getting number of accounts in mobile DB
		
		return 0; //Assume that database is empty
	}
}