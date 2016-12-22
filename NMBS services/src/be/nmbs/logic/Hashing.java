package be.nmbs.logic;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// sources : http://viralpatel.net/blogs/java-md5-hashing-salting-password/
// 			http://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/

/**
 * Deze klasse gaat de wachtwoorden encrypteren.
 * 
 * @author flaviusb
 *
 */
public class Hashing {
	/**
	 * Hashing met md5 die dan gehasht wordt met sha256 en een salt.
	 * 
	 * @param paswoord
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String hashPaswoord(String password) {
		String saltString = "QxLUF1bgIAdeQX";
		byte[] salt = saltString.getBytes();
		String securePassword = getSecurePassword(md5(password), salt);
		return securePassword;
	}

	/**
	 * Deze methode stuurt een md5 encryptie terug van een Stringobject
	 * 
	 * @param input
	 * @return
	 */
	public static String md5(String input) {
		String md5 = null;

		if (null == input)
			return null;

		try {
			// Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");

			// Update input string in message digest
			digest.update(input.getBytes(), 0, input.length());

			// Converts message digest value in base 16 (hex)
			md5 = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}
	
	/**
	 * Deze methode het wachtwoord hashen.
	 * @param passwordToHash
	 * @param salt
	 * @return
	 */
	private static String getSecurePassword(String passwordToHash, byte[] salt) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(salt);
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

}