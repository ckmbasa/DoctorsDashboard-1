/*
 *  Created By: Christian Joseph Dalisay
 *  Created On: 05/01/14
 *  Edited On: 05/06/14
 *  DataHandler Class - class handles the creation, & upgrade of database
 */

package com.example.database;


import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {
	public DatabaseHandler(Context context, String name, CursorFactory factory, int version)  {
	    super(context, name, factory, version);
	    Log.d("DatabaseHandler", "Database Created");
	}
	
	//	----------------TABLE CREATION METHODS----------------
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		try {
			db.execSQL(Data.CREATE_TABLE_CLIENT);
			db.execSQL(Data.CREATE_TABLE_DOCTOR);
			db.execSQL(Data.CREATE_TABLE_DEPARTMENT);
			db.execSQL(Data.CREATE_TABLE_PATIENT);
			db.execSQL(Data.CREATE_TABLE_ENCOUNTER);
			db.execSQL(Data.CREATE_TABLE_REFERRAL);
			db.execSQL(Data.CREATE_TABLE_REASON);
			db.execSQL(Data.CREATE_TABLE_CANVASS);
			db.execSQL(Data.CREATE_TABLE_LAB_REQUEST);
			db.execSQL(Data.CREATE_TABLE_LAB_SERVICE);
			db.execSQL(Data.CREATE_TABLE_SERVICE_REQUEST);
			db.execSQL(Data.CREATE_TABLE_LAB_RESULT);
			db.execSQL(Data.CREATE_TABLE_SOAP);
			
			onCreateDummy(db);
			Log.d("DatabaseHandler","Database onCreateTables Successful");
		} catch (SQLException se) {
			System.out.println("did not");
			Log.d("onCreateTables SQLException",Log.getStackTraceString(se));
		} catch (Exception e) {
			Log.d("onCreateTables Exception",Log.getStackTraceString(e));
		}

		try {//initial indexing
			db.execSQL("CREATE INDEX idx_encounter ON " + Data.TABLE_ENCOUNTER + " (" + Data.ENCOUNTER_ID + " )");
			db.execSQL("CREATE INDEX idx_license ON " + Data.TABLE_DOCTOR + " (" + Data.LICENSE_NO + " )");
			db.execSQL("CREATE INDEX idx_authtoken ON " + Data.TABLE_DOCTOR + " (" + Data.AUTH + " )");
			Log.d("DatabaseHandler","Database onCreateIndexes Successful");
		} catch (SQLException se) {
			Log.d("onCreateIndexes SQLException",Log.getStackTraceString(se));
		} catch (Exception e) {
			Log.d("onCreateIndexes Exception",Log.getStackTraceString(e));
		} 
	}
	
	public void onCreateDummy(SQLiteDatabase db) {
		try	{
			db.execSQL("INSERT INTO 'department' ('dept_id','short_dept','name_dept','acr_dept') " + 
				"VALUES (153,'Anesthesia','Anesthesia',''), " + 
				"	(106,'Med-Rheuma','Medicine-Rheumatology',''), " + 
				"	(107,'Med-Neuro','Medicine-Neurology',''), " + 
				"	(131,'Opthal','Opthalmology',''), " + 
				"	(133,'FaMed','Family Medicine',''), " + 
				"	(136,'ENT-HNS','ENT-HNS','') " );
			db.execSQL("INSERT INTO 'doctor' ('personnel_id','license_no','dept_id','name_last','name_first','name_middle') " +
				" VALUES (100022,'1234560',133,'Aquino','Aljun','Galaura'), " +
				"	(100027,'1234567',133,'Gaurino','Marc','Gonzales'), " +
				"	(100040,'1234568',133,'Caralos','Rex Arnold','Mesiona'), " +
				"	(100054,'1234569',131,'Chin','Elizabeth May','Tan') "  );
			db.execSQL("INSERT INTO 'patient' ('pid','name_last','name_first','name_middle','sex','date_birth','street','city','province','zipcode','hist_smoke','hist_drink') " +
				" VALUES " + //(1,'Cosare','Alvin','Ceniza','m','1994-00-00','Mintal','Davao City','Davao del Sur','8000',1,0), " + 
				//" 	(3,'Unknown','Patient','SPMC','f','0000-00-00','','','','',1,1), " + 
				" 	(1000000,'Montelibano','Julie','Himo','f','2007-07-07','Commonal','Davao City','Davao del Sur','8000',0,1), " +
				" 	(1000001,'Diamona','Francis','Garong','m','2003-04-30','Tuban','Davao City','Davao del Sur','8000',1,1), " + 
				" 	(1086278,'Sarael','Val','Teofilo','m','1974-10-08','#250 BLK III SIR','Davao City','Davao del Sur','8000',0,0), " + 
				" 	(1158851,'Satinitigan','Val','Repalda','f','2004-02-14','KM. 13, ZONE II','Davao City','Davao del Sur','8000',0,0), " + 
				" 	(1234567,'Sayman','Val Anthony','Garong','m','2006-07-19','Kabacan Ecoland','Davao City','Davao del Sur','8000',0,0) "  );
			db.execSQL("INSERT INTO 'encounter' ('encounter_id','personnel_id','pid','type_patient','message_complaint','date_encountered') " + 
				" VALUES (2008000001,100022,1000000,'OPD',null,'2008-11-24 16:05:43'), " + 
				"	(2008000002,100022,1000000,'OPD',null,'2008-12-24 08:07:43'), " + 
				" 	(2008000000,100022,1000000,'Inpatient from ER',null,'2009-02-09 11:47:00' )");
			db.execSQL("INSERT INTO 'reason' ('reason_id','name_reason') " +
				" VALUES (1,'Surgery'), " + 
				"   (2,'Dialysis'), " +
				"	(3,'ER')");
			db.execSQL("INSERT INTO 'referral' ('referral_id','encounter_id','dept_id','reason_id','date_referred') " + 
				" VALUES (1,1008000001,133,1,'2013-06-02 00:12:00' )");
			Log.d("DatabaseHandler","onCreateDummy successful");
		} catch (SQLException se) {
			Log.d("onCreateDummy SQLException",Log.getStackTraceString(se));
		} catch (Exception e) {
			Log.d("onCreateDummy Exception",Log.getStackTraceString(e));
		}
	}
	
	public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
		try {
			db.execSQL("DROP TABLE IF EXISTS " + Data.TABLE_CLIENT);
			db.execSQL("DROP TABLE IF EXISTS " + Data.TABLE_DOCTOR);
			db.execSQL("DROP TABLE IF EXISTS " + Data.TABLE_DEPARTMENT);
			db.execSQL("DROP TABLE IF EXISTS " + Data.TABLE_PATIENT);
			db.execSQL("DROP TABLE IF EXISTS " + Data.TABLE_ENCOUNTER);
			db.execSQL("DROP TABLE IF EXISTS " + Data.TABLE_REFERRAL);
			db.execSQL("DROP TABLE IF EXISTS " + Data.TABLE_REASON);
			db.execSQL("DROP TABLE IF EXISTS " + Data.TABLE_CANVASS);
			db.execSQL("DROP TABLE IF EXISTS " + Data.TABLE_LAB_REQUEST);
			db.execSQL("DROP TABLE IF EXISTS " + Data.TABLE_LAB_SERVICE);
			db.execSQL("DROP TABLE IF EXISTS " + Data.TABLE_SERVICE_REQUEST);
			db.execSQL("DROP TABLE IF EXISTS " + Data.TABLE_LAB_RESULT);
			db.execSQL("DROP TABLE IF EXISTS " + Data.TABLE_SOAP);
			
			onCreate(db);
			//better if there is a backup of a table
			Log.d("DatabaseHandler","Database onDropTables Successful");
		} catch (SQLException se) {
			Log.d("onDropTables SQLException",Log.getStackTraceString(se));
		} catch (Exception e) {
			Log.d("onDropTables Exception",Log.getStackTraceString(e));
		}
		
		try {
			db.execSQL("DROP INDEX " + Data.TABLE_DOCTOR + ".idx_encounter" );
			db.execSQL("DROP INDEX " + Data.TABLE_DOCTOR + ".idx_license" );
			db.execSQL("DROP INDEX " + Data.TABLE_DOCTOR + ".idx_authtoken" );
			
			onCreate(db);
			Log.d("DatabaseHandler","Database onDropIndexes Successful");
		} catch (SQLException se) {
			Log.d("onDropIndexes SQLException",Log.getStackTraceString(se));
		} catch (Exception e) {
			Log.d("onDropIndexes Exception",Log.getStackTraceString(e));
		}
	}
}
