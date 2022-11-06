package fr.reservations.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class HashUtil {

	public static String toHash(String msg) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(msg.getBytes());
			byte[] digest = md.digest();
			return DatatypeConverter.printHexBinary(digest).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
		}
		return null;
	}
}
