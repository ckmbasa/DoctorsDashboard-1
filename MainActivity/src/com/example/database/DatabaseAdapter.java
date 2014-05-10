/*
 ** Created by Jessie Emmanuel Adante
 *** Created on 4/29/14
 ** Edited by Jose Martin Ipong - 4/29/14
 ** Edited by Christian Joseph Dalisay - 4/30/14
 
 ** DatabaseHandler - handles the CRUD Operations, 
 *					  and auxiliary database functions/queries
 */

package com.example.database;


import android.content.Context;
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
}