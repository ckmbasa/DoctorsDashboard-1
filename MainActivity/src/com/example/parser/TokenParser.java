package com.example.parser;

import java.util.HashMap;

import com.google.resting.json.JSONArray;
import com.google.resting.json.JSONException;
import com.google.resting.json.JSONObject;

public class TokenParser extends JSONParser {
	
	private HashMap<String, String> data = new HashMap<String, String>();
	private JSONObject json_childNode;
	
	public TokenParser(String content) throws NullPointerException{
		
		try {
			json_object = new JSONObject(content);
			json_childNode = (JSONObject) json_object.get("data");
			//System.out.println(json_childNode.optString("auth_token"));
		} catch (JSONException e) {
			System.out.println("boom");
		}
		
	}
	
	public HashMap<String, String> extractData(){
		System.out.println("ok");
		System.out.println(json_childNode.optString("auth_token"));
		
        data.put("auth_token", json_childNode.optString("auth_token").toString());
        data.put("access_token", json_childNode.optString("access_token"));
        data.put("name_first", json_childNode.optString("name_first"));
        data.put("name_middle", json_childNode.optString("name_middle").toString());
        data.put("name_last", json_childNode.optString("name_last").toString());
        data.put("sex", json_childNode.optString("sex").toString());
        data.put("location_nr", json_childNode.optString("location_nr").toString());
        data.put("birth_date", json_childNode.optString("birth_date").toString());
     
        return data;
	}

}
