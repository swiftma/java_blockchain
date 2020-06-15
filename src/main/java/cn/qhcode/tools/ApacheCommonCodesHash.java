package cn.qhcode.tools;

import org.apache.commons.codec.digest.DigestUtils;

public class ApacheCommonCodesHash {

	public static void main(String[] args) {
		String originalString = "hello";
		String sha256hex = DigestUtils.sha256Hex(originalString);
		
		System.out.println(sha256hex);
	}

}
