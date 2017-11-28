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
			//����Ű �� ����Ű ����
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048);

			KeyPair keyPair = keyPairGenerator.genKeyPair();
			Key publicKey = keyPair.getPublic(); // ����Ű
			Key privateKey = keyPair.getPrivate(); // ����Ű

			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			RSAPublicKeySpec publicKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
			RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);

			//            System.out.println("public key modulus(" + publicKeySpec.getModulus() + ") exponent(" + publicKeySpec.getPublicExponent() + ")");
			//            System.out.println("private key modulus(" + privateKeySpec.getModulus() + ") exponent(" + privateKeySpec.getPrivateExponent() + ")");


			// ��ȣȭ(Encryption) ����
			String test = ""; // "������123"�� ��ȣȭ�Ѵ�!
			//				System.out.println("�Է� : ");
			//				Scanner sc = new Scanner(System.in);
			//				inputStr = sc.nextLine();
			//				System.out.println("��ȣȭ �� �� : "+inputStr);
			//				System.out.println(publicKey);
			//				System.out.println(privateKey);
			Cipher cipher = Cipher.getInstance("RSA");
			//				cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			//				byte[] arrCipherData = cipher.doFinal(inputStr.getBytes()); // ��ȣȭ�� ������(byte �迭)
			//				String strCipher = new String(arrCipherData);
			//
			//				System.out.println("��ȣȭ �Ȱ� : \n"+strCipher); // ��ȣȭ ����� ���(������ ���̱⿡�� ���� �� ����)
			byte[] arrCipherData = sv.service(publicKey);
//			test =  publicKey.toString();
//			byte[]keyBytes = test.getBytes();
//			byte[]decode = Base64.decodeBase64(keyBytes);
			KeyFactory fact = KeyFactory.getInstance("RSA");
//			X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(decode);
//			PublicKey pubKey2 = (PublicKey)fact.generatePublic(x509KeySpec);
			
			System.out.println("ù ����Ű : "+publicKey);
//			System.out.println("��ȯ ����Ű : "+pubKey2);
			
			// ��ȣȭ(Decryption) ����
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] arrData = cipher.doFinal(arrCipherData);
			String strResult = new String(arrData);

			System.out.println("��ȣȭ �� �� : "+strResult); // ��ȣȭ ����� ���(�ٽ� "������123"�� ��µ�)
		} catch (Exception e) {
			e.printStackTrace();
		}
		//		}while(!inputStr.equals("����"));
	}
}