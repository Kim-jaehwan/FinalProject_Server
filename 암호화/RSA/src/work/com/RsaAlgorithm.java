package work.com;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Scanner;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class RsaAlgorithm {
	private static server sv = new server();
	public static void main(String[] args) {
		String inputStr = "";
		//		do {

		try {
			//공개키 및 개인키 생성
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048);

			KeyPair keyPair = keyPairGenerator.genKeyPair();
			Key publicKey = keyPair.getPublic(); // 공개키
			Key privateKey = keyPair.getPrivate(); // 개인키

			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			RSAPublicKeySpec publicKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
			RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);

			//            System.out.println("public key modulus(" + publicKeySpec.getModulus() + ") exponent(" + publicKeySpec.getPublicExponent() + ")");
			//            System.out.println("private key modulus(" + privateKeySpec.getModulus() + ") exponent(" + privateKeySpec.getPrivateExponent() + ")");


			// 암호화(Encryption) 예제
			String test = ""; // "세이프123"을 암호화한다!
			//				System.out.println("입력 : ");
			//				Scanner sc = new Scanner(System.in);
			//				inputStr = sc.nextLine();
			//				System.out.println("암호화 전 값 : "+inputStr);
			//				System.out.println(publicKey);
			//				System.out.println(privateKey);
			Cipher cipher = Cipher.getInstance("RSA");
			//				cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			//				byte[] arrCipherData = cipher.doFinal(inputStr.getBytes()); // 암호화된 데이터(byte 배열)
			//				String strCipher = new String(arrCipherData);
			//
			//				System.out.println("암호화 된값 : \n"+strCipher); // 암호화 결과물 출력(눈으로 보이기에는 깨질 수 있음)
			byte[] arrCipherData = sv.service(publicKey);
//			test =  publicKey.toString();
//			byte[]keyBytes = test.getBytes();
//			byte[]decode = Base64.decodeBase64(keyBytes);
			KeyFactory fact = KeyFactory.getInstance("RSA");
//			X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(decode);
//			PublicKey pubKey2 = (PublicKey)fact.generatePublic(x509KeySpec);
			
			System.out.println("첫 공개키 : "+publicKey);
//			System.out.println("변환 공개키 : "+pubKey2);
			
			// 복호화(Decryption) 예제
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] arrData = cipher.doFinal(arrCipherData);
			String strResult = new String(arrData);

			System.out.println("복호화 한 값 : "+strResult); // 복호화 결과물 출력(다시 "세이프123"이 출력됨)
		} catch (Exception e) {
			e.printStackTrace();
		}
		//		}while(!inputStr.equals("꺼져"));
	}
}