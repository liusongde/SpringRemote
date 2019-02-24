package com.haleywang.putty.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Md5Utils {

	private static String getMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes("UTF-8"));
		return new BigInteger(1, md.digest()).toString(16);
	}
	
	
	public static String getT4MD5(String str) {
		try {
			return getMD5(getMD5(getMD5(getMD5(str))));
		}catch (Exception e) {
			throw new RuntimeException("encrypt error", e);
		}

	}

}
