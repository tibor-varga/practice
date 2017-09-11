package com.buxi.practice.lambdas.amstrong;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.IntStream;

/**
 * Eine Armstrong-Zahl ist eine Zahl , bei der die Summe der einzelnen Ziffern,
 * die jeweils mit der Anzahl der Ziffern der Zahl potenziert wird, gleich der
 * Zahl ist wie z.B.: 153 = 1³+5³+3³
 * 
 * Implementation with lambdas
 * 
 * @author buxi
 *
 */
public class AmstrongFinderWithLambdas {

	class Info {
		int i;
		long amstrongSum;

		/**
		 * helper class
		 * 
		 * @param number
		 * @param amstrongSum
		 */
		public Info(int number, long amstrongSum) {
			super();
			this.i = number;
			this.amstrongSum = amstrongSum;
		}

		@Override
		public String toString() {
			return "Info [i=" + i + ", amstrongSum=" + amstrongSum + "]";
		}

	}

	public static void main(String[] args) {
		AmstrongFinderWithLambdas mainObj = new AmstrongFinderWithLambdas();
		mainObj.findAmstrongNumber(3);
	}

	/**
	 * Finding Amstrongs number for length
	 * 
	 * @param length
	 */
	public void findAmstrongNumber(int length) {
		int minRange = (int) Math.pow(10, length - 1);
		int maxRange = (int) Math.pow(10, length);
		IntStream rangeStream = IntStream.range(minRange, maxRange);
		System.out.println("Finding Amstrong numbers for length" + length + ", between:" + minRange + "-" + maxRange);
		long start = new Date().getTime();

		// Stream of Arrays containing the digits of the number
		rangeStream.parallel().mapToObj(x -> new Info(x, calcSum(x, length))).filter(x -> x.i == x.amstrongSum)
				.forEach(System.out::println);
		long end = new Date().getTime();
		System.out.println("Time consumed:" + (end - start));
	}

	/**
	 * calculating the Amstrong value to a number
	 * 
	 * @param x
	 * @param length
	 * @return
	 */
	private long calcSum(int x, int length) {
		return Arrays.asList(Integer.toString(x).split("")).stream()
				.map(digit -> (int) Math.pow(Integer.valueOf(digit), length)).reduce(0, Integer::sum);
	}
}
