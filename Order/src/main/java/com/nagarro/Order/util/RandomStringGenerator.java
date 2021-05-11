package com.nagarro.Order.util;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * generates random string
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
