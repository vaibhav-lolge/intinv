package com.inventory.util;

import java.security.MessageDigest;

public class EncryptPassword {
	
	public static String getSerucerPassword (String passwordToHash){
		String generatePassword = null;
		try {
			MessageDigest messageDigest= MessageDigest.getInstance("MD5");
			byte[] bytes = messageDigest.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			
			for(int counter=0; counter< bytes.length; counter++){
				sb.append(Integer.toString((bytes [counter] & 0xff)+0x100,16).substring(1));
			}
			
			generatePassword = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return generatePassword;
	}
	
}
