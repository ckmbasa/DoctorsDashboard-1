/*Created By: Christian Joseph Dalisay
 * Created On: 05/08/14
 * IPAddressValidator - this class handles the validation
 * 						of a valid IPv4 Address
 */
	
package com.example.api.auth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class IPAddressValidator{
 
    public Pattern pattern;
    public Matcher matcher;
 
    private static final String IPADDRESS_PATTERN = 
		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
 
    public IPAddressValidator(){
	  pattern = Pattern.compile(IPADDRESS_PATTERN);
    }
 
   /**
    * Validate ip address with regular expression
    * @param ip ip address for validation
    * @return true valid ip address, false invalid ip address
    */
    public boolean validate(String ip){		  
	  matcher = pattern.matcher(ip);
	  return matcher.matches();	    	    
    }
}