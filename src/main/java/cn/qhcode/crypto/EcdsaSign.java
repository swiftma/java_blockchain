package cn.qhcode.crypto;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;

import org.bouncycastle.util.encoders.Hex;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Hash;
import org.web3j.crypto.Keys;
import org.web3j.crypto.Sign;

public class EcdsaSign {

	public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException,
			NoSuchProviderException, SignatureException {
		BigInteger privKey = Keys.createEcKeyPair().getPrivateKey();
		BigInteger pubKey = Sign.publicKeyFromPrivate(privKey);
		ECKeyPair keyPair = new ECKeyPair(privKey, pubKey);

		String msg = "Message for signing";
		byte[] msgHash = Hash.sha3(msg.getBytes());
		Sign.SignatureData signature = Sign.signMessage(msgHash, keyPair, false);

		System.out.println("Msg: " + msg);
		System.out.println("Msg hash: " + Hex.toHexString(msgHash));
		System.out.printf("Signature: [v = %d, r = %s, s = %s]\n", signature.getV() - 27,
				Hex.toHexString(signature.getR()), Hex.toHexString(signature.getS()));

		BigInteger pubKeyRecovered = Sign.signedMessageToKey(msg.getBytes(), signature);
		System.out.println("Recovered public key: " + pubKeyRecovered.toString(16));

		boolean validSig = pubKey.equals(pubKeyRecovered);
		System.out.println("Signature valid? " + validSig);

	}

}
