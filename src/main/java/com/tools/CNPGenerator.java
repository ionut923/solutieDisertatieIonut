package com.tools;


import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.StringUtils;

public class CNPGenerator {

	public static String generateCnp() {

		StringBuilder cnp = new StringBuilder();

		int sex = ThreadLocalRandom.current().nextInt(1, 2);
		cnp.append(sex);
		int year = ThreadLocalRandom.current().nextInt(20, 99);
		cnp.append(year);
		int month = ThreadLocalRandom.current().nextInt(1, 12);
		cnp.append(StringUtils.leftPad(String.valueOf(month), 2, "0"));
		int day = ThreadLocalRandom.current().nextInt(1, 28);
		cnp.append(StringUtils.leftPad(String.valueOf(day), 2, "0"));
		int county = ThreadLocalRandom.current().nextInt(1, 52);
		cnp.append(StringUtils.leftPad(String.valueOf(county), 2, "0"));
		int orderNumber = ThreadLocalRandom.current().nextInt(1, 999);
		cnp.append(StringUtils.leftPad(String.valueOf(orderNumber), 3, "0"));
		int controlDigit = CNPGenerator.calculateControlDigit(Long.parseLong(cnp.toString()));
		cnp.append(controlDigit);

		return cnp.toString();
	}

	public static int calculateControlDigit(long n) {

		int[] refDigits = Long.toString(279146358279L).chars().map(c -> c -= '0').toArray();
		int[] digits = Long.toString(n).chars().map(c -> c -= '0').toArray();
		int sum = 0;
		for (int i = 0; i < digits.length; i++) {
			sum = sum + (digits[i] * refDigits[i]);
		}
		int remainder = sum % 11;

		return remainder == 10 ? 1 : remainder;
	}
}

