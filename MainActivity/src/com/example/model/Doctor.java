/*
 * Created By: Christian Joseph Dalisay
 * Created On: 5/9/14
 * Doctor Model - this model handles the data of the table doctor
 */

package com.example.model;

public class Doctor {

	private int personnel_id;
	private String license_no;
	private int dept_id;
	//private String dept_id;
	private String name_last;
	private String name_first;
	private String name_middle;
	private String authtoken;
	private String accesstoken;
	private String base_url;
	private String last_sync;
	private String date_birth;
	private String sex;
	
	public Doctor() {
		this.personnel_id	= (Integer) null;
		this.license_no 	= "";
		//this.dept_id 		= "";
		this.dept_id		= (Integer) null;
		this.name_last 		= "";
		this.name_first 	= "";
		this.name_middle 	= "";
		this.authtoken 		= "";
		this.accesstoken 	= "";
		this.base_url 		= "";
		this.last_sync 		= "";
		this.date_birth		= "";
		this.sex 			= "";
		this.base_url		= "";
	}
	
	public void setDoctor(Doctor doctor){
		this.personnel_id	= doctor.personnel_id;
		this.license_no 	= doctor.license_no;
		this.dept_id 		= doctor.dept_id;
		this.name_last 		= doctor.name_last;
		this.name_first 	= doctor.name_first;
		this.name_middle 	= doctor.name_middle;
		this.authtoken 		= doctor.authtoken;
		this.accesstoken 	= doctor.accesstoken;
		this.base_url 		= doctor.base_url;
		this.last_sync 		= doctor.last_sync;
		this.date_birth 	= doctor.date_birth;
		this.sex 			= doctor.sex;
		this.base_url 		= doctor.base_url;
	}
	
	/*public void setDoctorCredentials(String[] doctor){
		this.license_no 	= doctor[0];
		this.dept_id 		= doctor[1];
		this.name_last 		= doctor[2];
		this.name_first 	= doctor[3];
		this.name_middle 	= doctor[4];
		this.authtoken 		= doctor[5];
		this.accesstoken 	= doctor[6];
		this.date_birth 	= doctor[7];
		this.sex 			= doctor[8];
		this.base_url 		= doctor[9];
	}*/
	
	public void setDoctorCredentials(String[] doctor){
		this.license_no 	= doctor[0];
		this.name_last 		= doctor[1];
		this.name_first 	= doctor[2];
		this.name_middle 	= doctor[3];
		this.authtoken 		= doctor[4];
		this.accesstoken 	= doctor[5];
		this.date_birth 	= doctor[6];
		this.sex 			= doctor[7];
		this.base_url 		= doctor[8];
	}
	
	public void setBaseUrl(String url) {
		this.base_url = url;
	}
	
	public void setLastSync(String sync) {
		this.last_sync = sync;
	}
	
	public void setPersonnelId(Integer personnel ) {
		this.personnel_id = personnel;
	}

	public void setDeptId(Integer dept ) {
		this.dept_id = dept;
	}
	
	public void setDoctor(String license, String authtoken, String accesstoken) {
		this.license_no 	= license;
		this.authtoken 		= authtoken;
		this.accesstoken 	= accesstoken;
	}
	
	public Doctor getDoctor() {
		return this;
	}
	
	public Integer getPersonnelId(){
		return this.personnel_id;
	}
	
	public String getLicenseNo(){
		return this.license_no;
	}
	
	public Integer getDeptId() {
		return this.dept_id;
	}
	
	public String getNameLast() {
		return this.name_last;
	}
	
	public String getNameFirst() {
		return this.name_first;
	}
	
	public String getNameMiddle() {
		return this.name_middle;
	}
	
	public String getAuthToken() {
		return this.authtoken;
	}
	
	public String getAccessToken() {
		return this.accesstoken;
	}
	
	public String getBaseUrl() {
		return this.base_url;
	}
	
	public String getLastSync() {
		return this.last_sync;
	}
	
	public String getBirthDate() {
		return this.date_birth;
	}
	
	public String getSex() {
		return this.sex;
	}
}

	
