package com.example.android.navigationdrawerexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PatientActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_patient);
		super.onCreate(savedInstanceState);
	}
	
	public void showPatientInfo(View view){
    	Intent intent = new Intent(this, PatientInfo.class);
    	startActivity(intent);
    }
}
