package com.example.database;

import com.example.model.DoctorProfile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TokenAdapter extends DatabaseAdapter {
	
	public  SQLiteDatabase db;
	private DatabaseHandler dbHandler;
	
	public TokenAdapter(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public DoctorProfile getToken(){
		DoctorProfile doctor = new DoctorProfile("auth","access");
		db = dbHandler.getWritableDatabase();
		
		String sql = "SELECT authtoken,accesstoken LIMIT '1' FROM doctor ";
		Cursor cursor=db.rawQuery(sql, null);
		if (cursor.moveToFirst()) {
    		do {
            	try{
	                DoctorProfile record = new DoctorProfile(cursor.getString(0),cursor.getString(1));
	                if(!record.getAuthToken().equals(null)&&!record.getAccessToken().equals(null)){
	                	return record;
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
	
	public void setToken(String[] rToken){
		DoctorProfile doctor = new DoctorProfile(rToken[0],rToken[1]);
		db = dbHandler.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(AUTH, doctor.getAuthToken());
		values.put(ACCESS, doctor.getAccessToken());
		
		db.insert(TABLE_DOCTOR, null, values);
	}
}


