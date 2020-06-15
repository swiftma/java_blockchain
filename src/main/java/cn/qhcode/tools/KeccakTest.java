package cn.qhcode.tools;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.bouncycastle.jcajce.provider.digest.Keccak;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

public class KeccakTest {

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
		Security.addProvider(new BouncyCastleProvider());
		final MessageDigest digest = MessageDigest.getInstance("KECCAK-256");
		final byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
		String sha3_256hex = bytesToHex(encodedhash);

		System.out.println(sha3_256hex);

		
		Keccak.Digest256 digest256 = new Keccak.Digest256();
		byte[] hashbytes = digest256.digest(
		  originalString.getBytes(StandardCharsets.UTF_8));
		sha3_256hex = new String(Hex.encode(hashbytes));
		System.out.println(sha3_256hex);
	}

}
