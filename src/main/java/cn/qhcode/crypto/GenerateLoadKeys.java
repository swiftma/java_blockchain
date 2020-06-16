package cn.qhcode.crypto;

import java.math.BigInteger;

import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Sign;

//https://wizardforcel.gitbooks.io/practical-cryptography-for-developers-book/crypto-libraries-for-developers/java-crypto-libraries.html

public class GenerateLoadKeys {

	public static String compressPubKey(BigInteger pubKey) {
        String pubKeyYPrefix = pubKey.testBit(0) ? "03" : "02";
        String pubKeyHex = pubKey.toString(16);
        String pubKeyX = pubKeyHex.substring(0, 64);
        return pubKeyYPrefix + pubKeyX;
    }
	
	public static void main(String[] args) {
		// Generate random private key
		// BigInteger privKey = Keys.createEcKeyPair().getPrivateKey(); 

		BigInteger privKey = new BigInteger(
		 "97ddae0f3a25b92268175400149d65d6887b9cefaf28ea2c078e05cdc15a3c0a", 16);
		BigInteger pubKey = Sign.publicKeyFromPrivate(privKey);
		ECKeyPair keyPair = new ECKeyPair(privKey, pubKey);

		System.out.println("Private key: " + privKey.toString(16));
		System.out.println("Public key: " + pubKey.toString(16));
		System.out.println("Public key (compressed): " +
		   compressPubKey(pubKey));

	}

}
