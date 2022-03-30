package no.hvl.dat109.proj2.yatzy.services;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

public class Encryption {
	final static int SALTLENGTH = 16;
	final static int ITER = 1000;
	private static final String VALID_PASSWORD_PATTERN = "^.{8,}$";
	
	public Encryption () {
		
	}
	
	public String encrypt (String password) throws UnsupportedEncodingException, NoSuchAlgorithmException  {
		
		char[] passchar = password.toCharArray();
		byte[] salt = getRandomSalt();
		byte[] keyhash = null;
		
		try {
			PBEKeySpec pks = new PBEKeySpec(passchar, salt, 1000, 256);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			keyhash = skf.generateSecret(pks).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return DatatypeConverter.printHexBinary(keyhash);
	}
	
	private static byte[] getRandomSalt() {
		SecureRandom sr;
		byte[] salt = new byte[SALTLENGTH];
			sr = new SecureRandom();
			sr.nextBytes(salt);
		
		return salt;
	}
	
	 public boolean validatePassword(String password, String kryptert) throws UnsupportedEncodingException, NoSuchAlgorithmException {
	    	if (password == null || !password.matches(VALID_PASSWORD_PATTERN)) {
	    		throw new IllegalArgumentException("Ugyldig passord. Passordet må matche " + VALID_PASSWORD_PATTERN);
	    	}
	    	if (kryptert == null) {
	    		throw new IllegalArgumentException("Kryptert passord kan ikke være null");
	    	}
	        byte[] salt = extractSalt(kryptert);
	        return encrypt(password).equals(kryptert);
	    }
	 
	 private byte[] extractSalt(String kryptert) {
	        byte[] saltPlusDigest = Base64.getDecoder().decode(kryptert);
	        byte[] salt = Arrays.copyOf(saltPlusDigest, SALTLENGTH);
	        return salt;
	    }
}
