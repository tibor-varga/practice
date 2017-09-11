package com.buxi.practice.lambdas.amstrong;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Eine Armstrong-Zahl ist eine Zahl , bei der die Summe der einzelnen Ziffern,
 * die jeweils mit der Anzahl der Ziffern der Zahl potenziert wird, gleich der
 * Zahl ist wie z.B.: 153 = 1³+5³+3³
 * 
 * @author buxi
 *
 */
public class AmstrongFinder {

	public static void main(String[] args) {
		AmstrongFinder mainObj = new AmstrongFinder();
		List<Integer> amstrongs = mainObj.findAmstrongNumber(6);
		System.out.println(amstrongs);

	}

	/**
	 * Intuitive 5 minutes implementation of the problem
	 * 
	 * @param length
	 *            number of digits to find the Amstrong numbers
	 * @return
	 */
	static List<Integer> findAmstrongNumber(int length) {
		long start = new Date().getTime();
		int minRange = (int) Math.pow(10, length - 1);
		int maxRange = (int) Math.pow(10, length) - 1;
		List<Integer> result = new ArrayList<>();
		System.out.println("Finding Amstrong numbers for length" + length + ", between:" + minRange + "-" + maxRange);
		for (int i = minRange; i <= maxRange; i++) {
			if (isAmstrong(i, length)) {
				result.add(i);
				System.out.println("found:" + i);
			}
		}
		long end = new Date().getTime();
		System.out.println("Time consumed:" + (end - start));
		return result;
	}

	/**
	 * Helper to test a number
	 * 
	 * @param number
	 * @param length
	 * @return
	 */
	private static boolean isAmstrong(int number, int length) {
		String numberStr = Integer.toString(number);
		long sum = 0;
		for (int i = 0; i < numberStr.length(); i++) {
			Integer digit = Integer.valueOf(numberStr.substring(i, i + 1));
			sum += Math.pow(digit, length);
			// System.out.print(digit + "^" + length + " + ");

		}
		// System.out.println(number + "-> " + sum);
		if (sum == number) {
			return true;
		}

		return false;
	}

}
