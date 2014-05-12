
package com.example.api.auth;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HMAC_SHA1 {
	private static StringBuffer hash;

public static String hmacSha2(String data, String keyString) {
    	
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
	    System.out.println("digest " + digest);	
	    return digest;
}
	    
	    public static String hmacSha1(String value, String key) {
    	System.out.println("data " + value);
    	System.out.println("key " + key);
        try {
            // Get an hmac_sha1 key from the raw key bytes
            byte[] keyBytes = key.getBytes();           
            SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");

            // Get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);

            // Compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(value.getBytes());

            // Convert raw bytes to Hex
            byte[] hexBytes = new Hex().encode(rawHmac);
            System.out.println("HMAC_SHA1.hmacSha1 " + new String(hexBytes, "UTF-8"));
            
            //  Covert array of Hex bytes to a String
            return new String(hexBytes, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	   
}