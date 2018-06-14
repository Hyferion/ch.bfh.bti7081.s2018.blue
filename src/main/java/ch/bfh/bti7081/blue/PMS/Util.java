package ch.bfh.bti7081.blue.PMS;

import java.security.MessageDigest;

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
	if (createSHA256(loginPassword).equals(loginAccount.getPassword())) {
		return true;
	}
	return false;
	}
	
	private static String createSHA256(String s) {
		String result = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(s.getBytes("UTF-8"));
			return DatatypeConverter.printHexBinary(hash);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
}
