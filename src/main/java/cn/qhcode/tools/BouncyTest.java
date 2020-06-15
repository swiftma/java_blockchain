package cn.qhcode.tools;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.bouncycastle.util.encoders.Hex;

public class BouncyTest {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String originalString = "hello";
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
		String sha256hex = new String(Hex.encode(hash));
		System.out.println(sha256hex);

	}

}
