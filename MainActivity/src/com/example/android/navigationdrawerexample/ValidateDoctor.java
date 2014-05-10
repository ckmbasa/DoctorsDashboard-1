package com.example.android.navigationdrawerexample;


import com.example.database.DatabaseAdapter;
import com.example.database.DatabaseHandler;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ValidateDoctor extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_validate_doctor);
		
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		String personnel_number = extras.getString("PERSONNEL_NUMBER");
		String firstname = extras.getString("FIRSTNAME");
		String lastname = extras.getString("LASTNAME");
		
		TextView personnel_number_textview = (TextView) findViewById(R.id.textView6);
		TextView firstname_textview = (TextView) findViewById(R.id.textView2);
		TextView lastname_textview = (TextView) findViewById(R.id.textView4);
		
		personnel_number_textview.setText(personnel_number);
		firstname_textview.setText(firstname);
		lastname_textview.setText(lastname);
		
		
		/*
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		*/
	}
	
	public void updateDoctor(View view){
		TextView personnel_number_textview = (TextView) findViewById(R.id.textView6);
		EditText username_edittext = (EditText) findViewById(R.id.LicenseNumber);
		EditText password_edittext = (EditText) findViewById(R.id.BaseURL);
		EditText confirm_password_edittext = (EditText) findViewById(R.id.Age);
		String personnel_number = personnel_number_textview.getText().toString();
		String username = username_edittext.getText().toString();
		String password = password_edittext.getText().toString();
		String confirm_password = confirm_password_edittext.getText().toString();
		
		
		//Toast.makeText(this, username + " " + password, Toast.LENGTH_SHORT).show();
		DatabaseAdapter db = new DatabaseAdapter(this);
		if(password.equals(confirm_password)){
			//db.updateDoctor(personnel_number, username, password);
			Intent intent = new Intent(this, LoginActivity.class);
			startActivity(intent);
		}
		else{
			Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.validate_doctor, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_validate_doctor,
					container, false);
			return rootView;
		}
	}

}
