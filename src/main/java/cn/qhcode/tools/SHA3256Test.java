package cn.qhcode.tools;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA3256Test {

	private static String bytesToHex(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String originalString = "hello";
		final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
		final byte[] hashbytes = digest.digest(
		  originalString.getBytes(StandardCharsets.UTF_8));
		String sha3_256hex = bytesToHex(hashbytes);
		System.out.println(sha3_256hex);
		
		sha3_256hex = new DigestUtils("SHA3-256").digestAsHex(originalString);
		
		System.out.println(sha3_256hex);
	}

}
