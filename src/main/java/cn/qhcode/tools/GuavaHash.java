package cn.qhcode.tools;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

public class GuavaHash {

	public static void main(String[] args) {
		String originalString = "hello";
		
		String sha256hex = Hashing.sha256()
				  .hashString(originalString, StandardCharsets.UTF_8)
				  .toString();
		
		System.out.println(sha256hex);

	}

}
