
package com.example.api.auth;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HMAC_SHA1 {

	private static StringBuffer hash;

    public static String hmacDigest(String data, String keyString) {
    	
	    String digest = null;
	    
	    try {
	      SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), "SHA1");
	      
	      Mac mac = Mac.getInstance("SHA1");
	      mac.init(key);
	
	      byte[] bytes = mac.doFinal(data.getBytes("ASCII"));
	
	      hash = new StringBuffer();
	     
	      for (int i = 0; i < bytes.length; i++) {
	        String hex = Integer.toHexString(0xFF & bytes[i]);
	        if (hex.length() == 1) {
	          hash.append('0');
	        }
	        hash.append(hex);
	      }
	      
	      digest = hash.toString();
	      
	    } catch (UnsupportedEncodingException e) {
	    	
	    } catch (InvalidKeyException e) {
	    
	    } catch (NoSuchAlgorithmException e) {
	    
	    } 
	    	
	    return digest;
	    
  }
}