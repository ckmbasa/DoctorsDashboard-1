/*
 ** Created by Alvin Jay Cosare
 ** Created on 05/06/14
 ** Handles processes for the registration of a new account 
 */

package com.example.android.navigationdrawerexample;

import com.example.database.RegistrationAdapter;
import com.example.model.Registration;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {

	private String license_nr;
	private String username;
	private String password;
	private String confirm_password;
	private String base_url;
	
	private EditText et_license_nr;
	private EditText et_username;
	private EditText et_password;
	private EditText et_confirm_password;
	private EditText et_base_url;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("lol");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		getActionBar().setDisplayHomeAsUpEnabled(false);
		
	}
	
	public void prepareCredentials(View view){
		//Add code here for using API for POST credentials and retrieve actual token
		
		/* Set inputted text by user to variables */
		setInputText();
		
		/* Convert data type from EditText -> Editable -> String */ 
		convertInputText();
		
		/* Validate inputs from user (i.e. empty field, unequal passwords) */
		validateInputs();
		
		/* FOR THE MEAN TIME */

		Registration reg = new Registration();

		/* Retrieve inputted data in textbox */
		reg.setLicenseNumber(license_nr);
		reg.setUsername(username);
		reg.setPassword (password);
		
		/* Retrieve client_id from mobile DB */
		reg.setClientId(getClientId());
		
		System.out.println(getClientId());
		//finish();
	}
	/* Retrieves inputted text by user and assigns it to a variable */
	private void setInputText(){
		et_license_nr = (EditText) findViewById(R.id.license_number);
		et_username = (EditText) findViewById(R.id.username);
		et_password = (EditText) findViewById(R.id.password);
		et_confirm_password = (EditText) findViewById(R.id.confirm_password);
	    et_base_url = (EditText) findViewById(R.id.base_url);
	}
	
	/* Retrieves inputted text by user and converts/saves it as String */
	private void convertInputText(){
		license_nr = et_license_nr.getText().toString();
		username = et_username.getText().toString();
		password = et_password.getText().toString();
		confirm_password = et_confirm_password.getText().toString();
		base_url = et_base_url.getText().toString();
	}
	
		
	/* Validate each input of user in case or missing fields and etc.*/
	public void validateInputs(){
		
		boolean cancel = false; //for flagging; will be equal to true if there are errors
		View focusView = null; //refers to the EditText View that will be focused if there are errors
		
		if (base_url.isEmpty()){
			et_base_url.setError(getString(R.string.error_field_required));
			focusView = et_base_url;
			cancel = true;
		}
		
		if (confirm_password.isEmpty()){
			et_confirm_password.setError(getString(R.string.error_field_required));
			focusView = et_confirm_password;
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
		if (license_nr.isEmpty()) {
			et_license_nr.setError(getString(R.string.error_field_required));
			focusView = et_license_nr;
			cancel = true;
		} 
		
		if(!password.equals(confirm_password) && !cancel){
			Toast.makeText(getApplicationContext(), "Passwords doesn't match", Toast.LENGTH_SHORT).show();
		}
		
		if(cancel){
			focusView.requestFocus();
		}
			
	}
	
	/* Call a web service to validate credentials and receive tokens */
	private void submitCredentials(){
		//Add code to implement POST API for authtoken and accesstoken generation
	}
	
	/* Retrieves client_id of mobile device and returns it as string */
	private String getClientId(){
		RegistrationAdapter db = new RegistrationAdapter(this);
		System.out.println("getClientId");
		return db.getClientId().toString();
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/*
	 * A placeholder fragment containing a simple view.
	 */

	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_register,
					container, false);
			return rootView;
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

}
