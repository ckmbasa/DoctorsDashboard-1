package com.example.android.navigationdrawerexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
    }
    
    public void showPatientActivity(View view){
    	Intent intent = new Intent(this, PatientActivity.class);
    	startActivity(intent);
    }
    
    public void showLaboratoryActivity(View view){
    	Intent intent = new Intent(this, LaboratoryActivity.class);
    	startActivity(intent);
    }
    
    public void showMedicalHistoryActivity(View view){
    	Intent intent = new Intent(this, MedicalHistoryActivity.class);
    	startActivity(intent);
    }
    
    public void showResultsActivity(View view){
    	Intent intent = new Intent(this, ResultsActivity.class);
    	startActivity(intent);
    }
    
    public void showCalculationsActivity(View view){
    	Intent intent = new Intent(this, CalculationsActivity.class);
    	startActivity(intent);
    }
    
    public void showEncountersActivity(View view){
    	Intent intent = new Intent(this, EncountersActivity.class);
    	startActivity(intent);
    }
    
    public void showCanvassActivity(View view){
    	Intent intent = new Intent(this, CanvassActivity.class);
    	startActivity(intent);
    }
    
}

// Test comment for commit
// Jake comment