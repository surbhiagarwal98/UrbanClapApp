package com.nagarro.Admin.util;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * util method for generating random string
 * 
 * @author surbhiagarwal
 *
 */
public class RandomStringGenerator {
	public static String generateRandomString() {

		int length = 8;
		boolean useLetters = true;
		boolean useNumbers = true;
		return (RandomStringUtils.random(length, useLetters, useNumbers));
	}
}
