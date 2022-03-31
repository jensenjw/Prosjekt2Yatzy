package no.hvl.dat109.proj2.yatzy.services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 * 
 * @author Henrik E
 * 
 */

public class PasswordService {
	
	/**
	 * @return et tilfeldig generert 16 bytes salt ved å bruke SHA1PRNG
	 */
	
	public static String generateSalt() {
		SecureRandom sr;
		 byte[] salt = new byte[16];
		 try {
			 sr = SecureRandom.getInstance("SHA1PRNG");
			 sr.nextBytes(salt);
		 } catch (NoSuchAlgorithmException e) {
			 e.printStackTrace();
		 }
		 return DatatypeConverter.printHexBinary(salt);
	}
	
	/**
	 * Genererer en kryptografisk hash for gitt passord og salt
	 * 
	 * Algoritmen som brukes er PBKDF2WithHmacSHA1
	 * - PBKDF2: Password-Based-Key-Derivation-Function
	 * - WithHmac: HMAC står for Keyed-Hash Message Authentication Code
	 * - SHA1: SHA1 hashing-algoritme
	 * 
	 * Det itereres 1000 ganger-
	 * Output fra denne algoritmen er 256 bits, dvs. 32 bytes
	 * 
	 * Til slutt omgjøres byte-tabellen til en HEX-streng på 64 tegn/siffer.
	 * 
	 * @param password
	 * @param salt
	 * @return en 64 tegn lang HEX-streng som representerer en 32byte/256bit hash.
	 */
	
	
	public static String hashWithSalt(String password, String salt) {
		
		if(password == null || salt == null) {
			throw new IllegalArgumentException();
		}
		
		char[] passchar = password.toCharArray();
		byte[] saltbytes = DatatypeConverter.parseHexBinary(salt);
		
		byte[] keyhash = null;
		try {
			PBEKeySpec pks = new PBEKeySpec(passchar,saltbytes,1000,256);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			keyhash = skf.generateSecret(pks).getEncoded();
			
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return DatatypeConverter.printHexBinary(keyhash);
	}
	
	
	/**
	 * Sjekker om et passord matcher en hash generert med korresponderende 
	 * hashWithSalt().
	 * 
	 * @param password - passordet som skal sjekkes
	 * @param salt - Saltet som ble brukt ved generering av passordhash
	 * @param passwordhash - Det "lagrete" passordet
	 * @return om passord matcher
	 */
	
	public static boolean validateWithSalt(String password,String salt, String passwordhash) {
		
		if(password == null || salt == null || passwordhash == null) {
			throw new IllegalArgumentException();
		}
		
		return passwordhash.equals(hashWithSalt(password,salt));
	}	

}
