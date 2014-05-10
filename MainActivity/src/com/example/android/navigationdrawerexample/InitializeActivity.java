/*
 ** Created by Alvin Jay Cosare
 ** Created on 05/06/14
 ** Handles processes for the initialization of the application
 **
 ** Updated by Christian Joseph Dalisay
 ** Updated on 05/10/14
 */

package com.example.android.navigationdrawerexample;

import java.util.UUID;

import com.example.database.AccountsAdapter;
import com.example.database.ClientAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class InitializeActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		/* check if client_id needs to be generated */
		if(!checkClientId()){
			String client_id = generateClientId();
			saveClientId(client_id);
		}
		
		/*
		 *  Check if at least one account already exists 
		 *  If no existing accounts then proceed to Registration
		 *  Else proceed to LogIn
		 */
		if(!accountExists()){
			showRegisterActivity();
			finish(); //temporary
		} 
		else{
			showLoginActivity();
			finish();
		}
			
	}
	
	/* Checks if a client_id already exists */
	private boolean checkClientId(){
		
		ClientAdapter db = new ClientAdapter(this);
		
		if(db.clientIdExists()){
			return true;
		} 
		else{
			return false;
		}
	}
	
	/* Generates client_id */
	private String generateClientId(){ 
		
		System.out.println("uuid");
		return UUID.randomUUID().toString();
		
	}
	
	/* Saves generated client_id to mobile DB */
	private void saveClientId(String client_id){
		
		ClientAdapter db = new ClientAdapter(this);
		
		db.insertClientId(client_id);
		
	}
	
	/* Checks if at least one account exists */
	private boolean accountExists(){
		AccountsAdapter db = new AccountsAdapter(this);
		
		if(db.getAccounts() > 0){
			return true;
		}
		else{
			return false;
		}

	}
	
	public void showRegisterActivity(){
		//System.out.println("register");
		Intent intent = new Intent(this, RegisterActivity.class);
		startActivity(intent);
	}
	
	public void showLoginActivity(){
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}

	@Override
	protected void onPause() {
		finish();
	}
	
	
	
}


