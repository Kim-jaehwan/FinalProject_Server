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
		String otp="��ȣ��";
		String strCipher = null;
		byte[] arrCipherData = null;
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			arrCipherData = cipher.doFinal(otp.getBytes()); // ��ȣȭ�� ������(byte �迭)
			strCipher = new String(arrCipherData);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("��ȣȭ �Ȱ� : \n"+strCipher); // ��ȣȭ ����� ���(������ ���̱⿡�� ���� �� ����)


		return arrCipherData;

	}
}