package com.example.api.auth;

import java.util.UUID;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.telephony.TelephonyManager;
import android.util.Log;

public class ClientUUID{
	
	public static String deviceUDID(Context ctx) {
	     try{
	    	 final TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
	     
	     final String tmDevice, tmSerial, androidId;
	     tmDevice = "" + tm.getDeviceId();
	     tmSerial = "" + tm.getSimSerialNumber();
	     androidId = "" +android.provider.Settings.Secure.getString(ctx.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

	     UUID deviceUuid = new UUID(androidId.hashCode(), ((long)tmDevice.hashCode() << 32) | tmSerial.hashCode());
	     String deviceId = deviceUuid.toString();
	     System.out.println("DEVICEID " + deviceId);
	     } catch (Exception e){
	     Log.d("Device Id", deviceUDID(null));
	     }
	     return deviceUDID(null);
	} 
	
	private static String uniqueID = null;
	private static final String PREF_UNIQUE_ID = "PREF_UNIQUE_ID";

	public synchronized static String id(Context context) {
	    if (uniqueID == null) {
	        SharedPreferences sharedPrefs = context.getSharedPreferences(
	                PREF_UNIQUE_ID, Context.MODE_PRIVATE);
	        uniqueID = sharedPrefs.getString(PREF_UNIQUE_ID, null);
	        if (uniqueID == null) {
	            uniqueID = UUID.randomUUID().toString();
	            Editor editor = sharedPrefs.edit();
	            editor.putString(PREF_UNIQUE_ID, uniqueID);
	            editor.commit();
	        }
	    }

        System.out.println("UNIQUEID " + uniqueID);
        Log.d("ID", uniqueID);
	    return uniqueID;
	}

}
