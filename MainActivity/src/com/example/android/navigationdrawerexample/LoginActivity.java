/*
 ** Created by Alvin Jay Cosare
 ** Created on 05/06/14
 ** Handles processes for the logging in of the user
 **
 ** Updated by Christian Joseph Dalisay
 ** Updated on 05/10/14
 */

 package com.example.android.navigationdrawerexample;

import com.example.api.auth.HMAC_SHA1;
import com.example.api.auth.MD5Hash;
import com.example.database.*;
import com.example.model.Registration;
import com.example.model.TokenValidate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
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
		if(validateInputs()){
			if (AuthtokenValidation()){
				successfulLogin();
			}
			else {
				Toast.makeText(getApplicationContext(), "Failed to Authenticate", Toast.LENGTH_SHORT).show();
			}
		}

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
	
	public boolean validateInputs(){
		/*Created By: Christian Joseph Dalisay
		 * Created On: 05/08/14
		 * ValidatesInputs - Validates the input of the user for logging in
		 */
			boolean cancel = false; //for flagging; will be equal to true if there are errors
			View focusView = null; //refers to the EditText View that will be focused if there are errors
			
			// must only contain alphanumeric characters
			String regex = "[\\p{Alnum}]+"; 
			if (!username.matches(regex)) {
				et_username.setError(getString(R.string.error_invalid_format));
				focusView = et_username;
				cancel = true;
			} 
			
			if (!password.matches(regex)) {
				et_password.setError(getString(R.string.error_invalid_format));
				focusView = et_password;
				cancel = true;
			} 
			
			if (password.isEmpty()){
				et_password.setError(getString(R.string.error_field_required));
				focusView = et_password;
				cancel = true;
			}
			
			if (username.isEmpty()){
				et_username.setError(getString(R.string.error_field_required));
				focusView = et_username;		
				cancel = true;
			} 
			
			if(cancel){
				focusView.requestFocus();
				return false;
			}
			
			else {
				// Show a progress spinner, and kick off a background task to
				// perform the user login attempt.
				//mLoginStatusMessageView.setText(R.string.login_progress_signing_in);
				//showProgress(true);
				return true;
			}
		}
	
	public Boolean AuthtokenValidation() {
		RegistrationAdapter client = new RegistrationAdapter(this);
		String data = client.getClientId() + "\\n" + username;
		String key = "";
		
		try {
			key = MD5Hash.md5(password);
			System.out.println("Key " + key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String digest = null;
		try {
			digest = HMAC_SHA1.hmacSha1(data,key);
		} catch (Exception e) {
			// TODO Auto-generated catch block[
			e.printStackTrace();
		}
		if(isAuthtokenExists(digest)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean isAuthtokenExists(String token) {
		TokenAdapter _token = new TokenAdapter(this);
		if(_token.isAuthtokenExists(token)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Shows the progress UI and hides the login form.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	private void showProgress(final boolean show) {
		// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
		// for very easy animations. If available, use these APIs to fade-in
		// the progress spinner.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			int shortAnimTime = getResources().getInteger(
					android.R.integer.config_shortAnimTime);

			mLoginStatusView.setVisibility(View.VISIBLE);
			mLoginStatusView.animate().setDuration(shortAnimTime)
					.alpha(show ? 1 : 0)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginStatusView.setVisibility(show ? View.VISIBLE
									: View.GONE);
						}
					});

			mLoginFormView.setVisibility(View.VISIBLE);
			mLoginFormView.animate().setDuration(shortAnimTime)
					.alpha(show ? 0 : 1)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginFormView.setVisibility(show ? View.GONE
									: View.VISIBLE);
						}
					});
		} else {
			// The ViewPropertyAnimator APIs are not available, so simply show
			// and hide the relevant UI components.
			mLoginStatusView.setVisibility(show ? View.VISIBLE : View.GONE);
			mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
		}
	}
}
