package ch.bfh.bti7081.blue.PMS;

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
	if (loginPassword.equals(loginAccount.getPassword())) {
		return true;
	}
	return false;
	}
}
