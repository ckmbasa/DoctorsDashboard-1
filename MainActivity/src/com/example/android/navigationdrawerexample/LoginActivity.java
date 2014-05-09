package com.example.android.navigationdrawerexample;

import java.util.UUID;

import com.example.database.*;
import com.example.model.Registration;
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
		setContentView(R.layout.activity_login);
		getActionBar().setDisplayHomeAsUpEnabled(false);
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
	
	public void successfulLogin(){
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(intent);	
	}
	
	/* Retrieves inputted text by user and assigns it to a variable */
	private void setInputText(){
		et_username = (EditText) findViewById(R.id.username);
		et_password = (EditText) findViewById(R.id.password);
	}
	
	/* Retrieves inputted text by user and converts/saves it as String */
	private void convertInputText(){
		username = et_username.getText().toString();
		password = et_password.getText().toString();
	}
	
	
	public void handleLogin(View view){
		
		setInputText();
		
		/* Convert data type from EditText -> Editable -> String */ 
		convertInputText();
		
		/* Validate inputs from user (i.e. empty field, unequal passwords) */
		//validateInputs();

		Registration reg = new Registration();

		/* Retrieve inputted data in textbox */
		//reg.setLicenseNumber(license_nr);
		reg.setUsername(username);
		reg.setPassword (password);
		
		/* Retrieve client_id from mobile DB */
		//reg.setClientId(getClientId());
		
		//System.out.println(getClientId());
		//finish();

		
		TokenValidate token = new TokenValidate();
		token.getAuthToken();
		token.getAccessToken();
	}
	
	
}
