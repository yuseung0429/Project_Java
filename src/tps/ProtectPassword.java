package tps;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ProtectPassword {
	String protectpassword;
	MessageDigest md;
	ProtectPassword(String str)
	{
		protectpassword = str;
		try {
			md = MessageDigest.getInstance("SHA-512");
			md.update(protectpassword.getBytes());
			protectpassword = String.format("%0128x", new BigInteger(1,md.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	public String getProtectPassword()
	{
		return protectpassword; 
	}
}
