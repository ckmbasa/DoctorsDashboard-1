package com.example.android.navigationdrawerexample;

import java.util.UUID;

import com.example.database.*;
import com.example.model.TokenValidate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity {
	
	
	// Values for username and password at the time of the login attempt.
	private String username;
	private String password;

	// UI references.
	private EditText et_username;
	private EditText et_password;
	private View mLoginFormView;
	private View mLoginStatusView;
	private TextView mLoginStatusMessageView;

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
		else {
			setContentView(R.layout.activity_login);
			getActionBar().setDisplayHomeAsUpEnabled(false);
			
			//Intent intent = new Intent(getApplicationContext(), MainActivity.class);
			//startActivity(intent);	
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
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.login, menu);
		
		return true;
	}
	
	public void showRegisterActivity(View view){
		Intent intent = new Intent(this, RegisterActivity.class);
		startActivity(intent);
	}
	
	public void showRegisterActivity(){
		//System.out.println("register");
		Intent intent = new Intent(this, RegisterActivity.class);
		startActivity(intent);
	}
	
	public void handleLogin(View view){
		
		TokenValidate token = new TokenValidate();
		token.getAuthToken();
		token.getAccessToken();
	}
}
