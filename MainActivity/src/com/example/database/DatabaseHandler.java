/*
 *  Created By: Christian Joseph Dalisay
 *  Created On: 05/01/14
 *  DataHandler Class - class handles the creation, upgrade of database,
 *  					and other auxiliary functions
 */

package com.example.database;


import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper
{
	public DatabaseHandler(Context context, String name, CursorFactory factory, int version)  {
	    super(context, name, factory, version);
	    Log.d("DatabaseHandler", "Database Created");
	}
	
	
	//	----------------TABLE CREATION METHODS----------------
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		try{
			db.execSQL(DatabaseAdapter.CREATE_TABLE_DOCTOR);
			db.execSQL(DatabaseAdapter.CREATE_TABLE_DEPARTMENT);
			db.execSQL(DatabaseAdapter.CREATE_TABLE_PATIENT);
			db.execSQL(DatabaseAdapter.CREATE_TABLE_ENCOUNTER);
			db.execSQL(DatabaseAdapter.CREATE_TABLE_REFERRAL);
			db.execSQL(DatabaseAdapter.CREATE_TABLE_REASON);
			db.execSQL(DatabaseAdapter.CREATE_TABLE_CANVASS);
			db.execSQL(DatabaseAdapter.CREATE_TABLE_LAB_REQUEST);
			db.execSQL(DatabaseAdapter.CREATE_TABLE_LAB_SERVICE);
			db.execSQL(DatabaseAdapter.CREATE_TABLE_SERVICE_REQUEST);
			db.execSQL(DatabaseAdapter.CREATE_TABLE_LAB_RESULT);
			db.execSQL(DatabaseAdapter.CREATE_TABLE_SOAP);
			
			onCreateDummy(db);
			
			Log.d("DatabaseHandler","Database onCreateTables Successful");
		} catch (SQLException se) {
			Log.d("onCreateTables SQLException",Log.getStackTraceString(se));
		} catch (Exception e) {
			Log.d("onCreateTables Exception",Log.getStackTraceString(e));
		}

		try {//initial indexing of 1:personnel_id, 2:encounter_id
			db.execSQL("CREATE INDEX idx_doctor ON " + Data.TABLE_DOCTOR + " (" + Data.PERSONNEL_ID + " )");
			db.execSQL("CREATE INDEX idx_encounter ON " + Data.TABLE_ENCOUNTER + " (" + Data.ENCOUNTER_ID + " )");
			Log.d("DatabaseHandler","Database onCreateIndexes Successful");
		} catch (SQLException se) {
			Log.d("onCreateIndexes SQLException",Log.getStackTraceString(se));
		} catch (Exception e) {
			Log.d("onCreateIndexes Exception",Log.getStackTraceString(e));
		} 
		
	}
	
	public void onCreateDummy(SQLiteDatabase db) {
		db.execSQL("INSERT INTO 'department' ('dept_id','short_dept','name_dept') VALUES (1,'PED','Pediatrics')");
		db.execSQL("INSERT INTO 'department' ('dept_id','short_dept','name_dept') VALUES (2,'NEU','Neurology')");
		db.execSQL("INSERT INTO 'doctor' ('personnel_id','dept_id','name_last','name_first') VALUES (1000,1,'Dalisay','Christian')");
		db.execSQL("INSERT INTO 'doctor' ('personnel_id','dept_id','name_last','name_first') VALUES (1001,1,'Muncada','Jake')");
		db.execSQL("INSERT INTO 'patient' ('pid','name_last','name_first') VALUES (1,'Cosare','Alvin')");
		db.execSQL("INSERT INTO 'encounter' ('encounter_id','pid','date_encountered') VALUES (1,1,'2012-07-01 00:00:00' )");
		db.execSQL("INSERT INTO 'encounter' ('encounter_id','pid','date_encountered') VALUES (2,2,'2013-06-02 00:08:00' )");
		db.execSQL("INSERT INTO 'encounter' ('encounter_id','pid','date_encountered','date_released') VALUES (3,1,'2014-01-03 00:00:00','2014-01-02 12:00:00' )");
		db.execSQL("INSERT INTO 'reason' ('reason_id','name_reason') VALUES (1,'Fever') ");
		db.execSQL("INSERT INTO 'referral' ('referral_id','encounter_id','dept_id','reason_id','date_referred') VALUES (1,1,1,1,'2013-06-02 00:12:00' )");
		Log.d("DatabaseHandler","onCreateDummy successful");
	}
	
	public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
		try {
			db.execSQL("DROP TABLE IF EXISTS " + DatabaseAdapter.TABLE_DOCTOR);
			db.execSQL("DROP TABLE IF EXISTS " + DatabaseAdapter.TABLE_DEPARTMENT);
			db.execSQL("DROP TABLE IF EXISTS " + DatabaseAdapter.TABLE_PATIENT);
			db.execSQL("DROP TABLE IF EXISTS " + DatabaseAdapter.TABLE_ENCOUNTER);
			db.execSQL("DROP TABLE IF EXISTS " + DatabaseAdapter.TABLE_REFERRAL);
			db.execSQL("DROP TABLE IF EXISTS " + DatabaseAdapter.TABLE_REASON);
			db.execSQL("DROP TABLE IF EXISTS " + DatabaseAdapter.TABLE_CANVASS);
			db.execSQL("DROP TABLE IF EXISTS " + DatabaseAdapter.TABLE_LAB_REQUEST);
			db.execSQL("DROP TABLE IF EXISTS " + DatabaseAdapter.TABLE_LAB_SERVICE);
			db.execSQL("DROP TABLE IF EXISTS " + DatabaseAdapter.TABLE_SERVICE_REQUEST);
			db.execSQL("DROP TABLE IF EXISTS " + DatabaseAdapter.TABLE_LAB_RESULT);
			db.execSQL("DROP TABLE IF EXISTS " + DatabaseAdapter.TABLE_SOAP);
			
			onCreate(db);
			//better if there is a backup of a table
			Log.d("DatabaseHandler","Database onDropTables Successful");
		} catch (SQLException se) {
			Log.d("onDropTables SQLException",Log.getStackTraceString(se));
		} catch (Exception e) {
			Log.d("onDropTables Exception",Log.getStackTraceString(e));
		}
		
		try {
			db.execSQL("DROP INDEX " + DatabaseAdapter.TABLE_DOCTOR + ".idx_doctor" );
			db.execSQL("DROP INDEX " + DatabaseAdapter.TABLE_ENCOUNTER + ".idx_encounter" );
			
			onCreate(db);
			//better if there is a backup of a table
			Log.d("DatabaseHandler","Database onDropIndexes Successful");
		} catch (SQLException se) {
			Log.d("onDropIndexes SQLException",Log.getStackTraceString(se));
		} catch (Exception e) {
			Log.d("onDropIndexes Exception",Log.getStackTraceString(e));
		}
	}
	
	
}
