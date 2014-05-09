/*
 ** Created by Alvin Jay Cosare
 ** Created on 05/06/14
 ** Handles processes for the registration of a new account 
 */

package com.example.android.navigationdrawerexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.api.auth.MD5Hash;
import com.example.database.RegistrationAdapter;
import com.example.model.Registration;
import com.example.model.Rest;
import com.example.parser.TokenParser;
import com.google.resting.Resting;
import com.google.resting.component.EncodingTypes;
import com.google.resting.component.impl.BasicRequestParams;
import com.google.resting.component.impl.ServiceResponse;
import com.google.resting.json.JSONException;

public class RegisterActivity extends Activity {

	private String license_nr = "0117236";
	private String username = "seurinane";
	private String password = "1234";
	private String confirm_password = "1234";
	private String base_url = "121.97.45.242";
	private HashMap<String, String> data;
	
	private EditText et_license_nr;
	private EditText et_username;
	private EditText et_password;
	private EditText et_confirm_password;
	private EditText et_base_url;	
	
	private Button register;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_register);
		getActionBar().setDisplayHomeAsUpEnabled(false);
		
		initViews();
	}
	
	public void prepareCredentials(View view){
		
		/* Convert data type from EditText -> Editable -> String */ 
		//convertInputText();
		
		/* Validate inputs from user (i.e. empty field, unequal passwords) */
		validateInputs();

		Registration reg = new Registration();
		
		/* Retrieve inputted data in textbox */
		reg.setLicenseNumber(license_nr);
		reg.setUsername(username);
		reg.setPassword(password);
		reg.setBaseURL(base_url);
		
		/* Retrieve client_id from mobile DB */
		reg.setClientId(getClientId());
		
		
		try{
			submitCredentials(reg);
		} catch(IllegalStateException e)
		{
			System.out.println("error");
		}
	}
	
	/* Associate layout elements with class variables */
	private void initViews(){
		et_license_nr = (EditText) findViewById(R.id.license_number);
		et_username = (EditText) findViewById(R.id.username);
		et_password = (EditText) findViewById(R.id.password);
		et_confirm_password = (EditText) findViewById(R.id.confirm_password);
	    et_base_url = (EditText) findViewById(R.id.base_url);
	    
	    register = (Button)findViewById(R.id.register_button);
	    register.requestFocus();
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
		else{
			
		}
			
	}
	
	/* Retrieves client_id of mobile device and returns it as string */
	private String getClientId(){
		RegistrationAdapter db = new RegistrationAdapter(this);
		System.out.println("getClientId");
		return db.getClientId().toString();
	}
	
	/* Submits credentials to server via API */
	private void submitCredentials(Registration reg){
		
		Rest rest = new Rest();
		
		try {
			rest.setURL("http://" + reg.getBaseURL() + 
					    "/segservice/registration/doctor?" + 
						"login_id="+reg.getUsername()+
						"&password="+MD5Hash.md5(reg.getPassword())+
						"&license_nr="+reg.getLicenseNumber()+
						"&client_id="+reg.getClientId());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(rest.getURL());
		
		rest.execute();
		
		//Toast.makeText(getApplicationContext(), rest.getResponse().getResponseString(), Toast.LENGTH_SHORT).show();
        
		
		while(rest.getContent() == null){}
		
		System.out.println(rest.getContent());
		
		parseJSONResponse(rest.getContent());
		//ServiceResponse response = rest.GET();
		
		//String content = response.getResponseString();
		
	} 
	
	private void parseJSONResponse(String content){
		try{
			System.out.println(content);
		}catch(NullPointerException e){
			System.out.println("aw");
		}

		TokenParser parser = new TokenParser(content);
		
		data = parser.extractData();
			
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
