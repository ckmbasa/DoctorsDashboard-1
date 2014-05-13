package com.example.android.navigationdrawerexample;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.database.DatabaseAdapter;
import com.example.model.Encounter;
import com.example.model.Patient;

public class PatientInfo extends Activity {
	Encounter encounter;
	ArrayList<Encounter> encounters;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_info);
		// Show the Up button in the action bar.
		setupActionBar();
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		int patientid = extras.getInt("EXTRA_PATIENT_ID");
		//Toast.makeText(getApplicationContext(), patientid, Toast.LENGTH_SHORT).show();
		
		DatabaseAdapter db = new DatabaseAdapter(this);
		Patient patient = db.getPatient(patientid);
		
		EditText nameEditText = (EditText) findViewById(R.id.FullName);
		EditText genderEditText = (EditText) findViewById(R.id.Gender);
		EditText addressEditText = (EditText) findViewById(R.id.Address);
		EditText ageEditText = (EditText) findViewById(R.id.Age);
		CheckBox histOfSmokingCheckBox = (CheckBox) findViewById(R.id.HistOfSmoking);
		CheckBox histOfDrinkingCheckBox = (CheckBox) findViewById(R.id.HistOfDrinking);
		histOfSmokingCheckBox.setChecked(true);
		histOfDrinkingCheckBox.setChecked(true);
		String nametext = patient.getNameLast() + ", " + patient.getNameFirst();
		String gendertext;
		if(patient.getSex().equals("M")){
			gendertext = "Male";
		}
		else{
			gendertext = "Female";
		}
		addressEditText.setText(patient.getAddress());
		nameEditText.setText(nametext);
		genderEditText.setText(gendertext);
		String age = String.valueOf(patient.getAge());
		ageEditText.setText(age);
		
		encounters = db.getPatientEncounter(patientid);
		patient = db.getPatientProfile(patientid);
		ListView listview = (ListView) findViewById(R.id.listView1);
		ArrayAdapter<Encounter> arrayAdapter = new ArrayAdapter<Encounter>(getApplicationContext(), android.R.layout.simple_list_item_1, encounters){
			@Override
			public View getView(int position, View ConvertView, ViewGroup parent){
				View view = super.getView(position, ConvertView, parent);
				TextView text = (TextView) view.findViewById(android.R.id.text1);
				text.setTextColor(Color.BLACK);
				return view;
			}
		};
		listview.setAdapter(arrayAdapter);
		listview.setOnItemClickListener(new OnItemClickListener() {
					
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position,
							long id) {
						TextView text 	= (TextView) view.findViewById(android.R.id.text1);
						encounter = encounters.get(position);
						int eid = encounter.getEncounterId();
						Bundle extras = new Bundle();
						extras.putInt("EXTRA_ENCOUNTER_ID", eid);
						
						Intent intent = new Intent(getApplicationContext(), PatientEncounterActivity.class);
						intent.putExtras(extras);
						startActivity(intent);
					}
				});
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.patient_info, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
