package ch.bfh.bti7081.blue.PMS;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import ch.bfh.bti7081.blue.PMS.model.LoginAccount;

public class Util {

	// validate username
	public static boolean validateUsername(LoginAccount loginAccount, String loginField) {
		if (loginField.equals(loginAccount.getUsername())) {
			return true;
		}
		return false;
	}

	// validate password for login
	public static boolean validatePassword(LoginAccount loginAccount, String loginPassword) {
	if (createSHA256(loginPassword).equalsIgnoreCase(loginAccount.getPassword())) {
		return true;
	}
	return false;
	}
	
	public static String createSHA256(final String originalString) {
        MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        final byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encodedhash);
	}
	
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
}
