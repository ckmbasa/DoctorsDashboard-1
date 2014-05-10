package com.example.model;

public class TokenValidate {

	private String auth = "authtoken";
	private String access = "accesstoken";
	
	public TokenValidate() {
		this.auth 	= "";
		this.access = "";
	}
	
	public void setTokens(String rAuth, String rAccess) {
		setAuthToken(rAuth);
		this.access = rAccess;
	}

	public void setAuthToken(String rAuth) {
		this.auth = rAuth;
	}

	public void setAccessToken(String rAccess) {
		this.access = rAccess;
	}
	
	public String getAuthToken() {
		return this.auth;
	}

	public String getAccessToken() {
		return this.access;
	}
}
