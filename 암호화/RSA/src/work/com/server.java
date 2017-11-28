package work.com;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class server {
	public byte[] service(Key publicKey) {
		String otp="요호이";
		String strCipher = null;
		byte[] arrCipherData = null;
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			arrCipherData = cipher.doFinal(otp.getBytes()); // 암호화된 데이터(byte 배열)
			strCipher = new String(arrCipherData);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("암호화 된값 : \n"+strCipher); // 암호화 결과물 출력(눈으로 보이기에는 깨질 수 있음)


		return arrCipherData;

	}
}