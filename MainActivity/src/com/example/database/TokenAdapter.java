/*Created By: Christian Joseph Dalisay
 * Created On: 05/08/14
 * TokenAdapter - This table adapter manages the tokens
 */
	
package com.example.database;

import com.example.model.TokenValidate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TokenAdapter extends Data {
	
	public  SQLiteDatabase db;
	private DatabaseHandler dbHandler;
	
	private static final int 	DATABASE_VERSION	= 1;
	private static final String DATABASE_NAME 		= "localhost";
	
	public  TokenAdapter(Context context) 
	{
		try {
			dbHandler = new DatabaseHandler(context, DATABASE_NAME, null, DATABASE_VERSION);
			Log.d("DatabaseHandler", "Database Created");
		} catch (Exception e) {
			Log.d("DatabaseHandler Exception", Log.getStackTraceString(e));
		}
	}
	
	public String getAuthToken() {
		db = dbHandler.getWritableDatabase();
		String sql = "SELECT authtoken FROM 'doctor'";
		Cursor cursor=db.rawQuery(sql, null);
		cursor.moveToFirst();
		System.out.println("Token " + cursor.getString(0));
		try {
			Log.d("TokenAdapter getAuthentication", "Valid Authentication Token");
			return cursor.getString(0);
		}catch(Exception e){
        	Log.d("TokenAdapter getAuthentication", Log.getStackTraceString(e));
        	return null;
        }
	}
	
	public TokenValidate getTokens(String rLicense){
		db = dbHandler.getWritableDatabase();
		
		String sql = "SELECT 'authtoken','accesstoken' LIMIT '1' FROM 'doctor' WHERE 'license_no' = " + rLicense;
		Cursor cursor=db.rawQuery(sql, null);
		try{
            TokenValidate token = new TokenValidate();
            token.setTokens(cursor.getString(0), cursor.getString(1));
            return token;
        }catch(Exception e) {
         Log.d("Token Adapter getTokens", Log.getStackTraceString(e));
         return null;
        }
	}
	
	public void setTokens(String[] rToken,String license){
		db = dbHandler.getWritableDatabase();
		
        /*
		ContentValues values = new ContentValues();
		values.put(AUTH, token.getAuthToken());
		values.put(ACCESS, token.getAccessToken());
		
		db.insert(TABLE_DOCTOR, null, values);
		*/
        String query = "UPDATE " + TABLE_DOCTOR + 
        				" SET '" + AUTH + "' = " + rToken[0] + ", "	 +
        						   ACCESS + "' = " + rToken[1] + " " +
        				" WHERE '"+ LICENSE_NO + "' = " + license;
        try {
        	db.execSQL(query);
        } catch(SQLException se) {
        	Log.d("TokenAdapter setTokens", Log.getStackTraceString(se));
        }
        						 
	}
}


