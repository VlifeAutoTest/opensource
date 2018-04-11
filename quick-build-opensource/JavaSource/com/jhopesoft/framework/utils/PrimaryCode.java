package com.jhopesoft.framework.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import com.jhopesoft.framework.exception.ProjectException;

public class PrimaryCode {

	public PrimaryCode() {

	}

	public synchronized static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public static String encryMD5(String psd) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bys = md.digest(psd.getBytes());
			String code = "";
			for (int i = 0; i < bys.length; i++) {
				if (code.length() > 0)
					code += ",";
				code += bys[i];
			}
			return code;
		} catch (NoSuchAlgorithmException e) {
			throw new ProjectException(" encryMD5 exception! ", e);
		}
	}

	public static void main(String[] args) {
		System.out.println(getUUID());
	}
}
