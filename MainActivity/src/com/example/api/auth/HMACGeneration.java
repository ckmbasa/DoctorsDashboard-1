package com.example.api.auth;
import java.security.Key;
import java.security.SignatureException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HMACGeneration {
      
      public static String getHmacMD5(String input, String privateKey, String algorithm) throws Exception{
    	  	System.out.println("data " + input);
      		System.out.println("key " + privateKey);
      		byte[] keyBytes = privateKey.getBytes();
            Key key = new SecretKeySpec(keyBytes, 0, keyBytes.length, algorithm); 
            Mac mac = Mac.getInstance(algorithm);
            mac.init(key); 
            return byteArrayToHex(mac.doFinal(input.getBytes()));
      }
      protected static String byteArrayToHex(byte [] a) {
            int hn, ln, cx;
            String hexDigitChars = "0123456789abcdef";
            StringBuffer buf = new StringBuffer(a.length * 2);
            for(cx = 0; cx < a.length; cx++) {
                  hn = ((int)(a[cx]) & 0x00ff) / 16;
                  ln = ((int)(a[cx]) & 0x000f);
                  buf.append(hexDigitChars.charAt(hn));
                  buf.append(hexDigitChars.charAt(ln));
            }

            System.out.println("HMACGeneration.getHmacMD5 " + buf.toString());
            return buf.toString();
      }
}