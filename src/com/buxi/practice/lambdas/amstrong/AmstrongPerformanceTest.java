package com.buxi.practice.lambdas.amstrong;

import java.util.stream.IntStream;

public class AmstrongPerformanceTest {
	public static void main(String[] args) {

		// testing the lambda implementation
		IntStream testRangesStream = IntStream.rangeClosed(3, 6);
		testRangesStream.forEach(x -> new AmstrongFinderWithLambdas().findAmstrongNumber(x));
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

		// testing the normal implementation
		IntStream testRanges2Stream = IntStream.rangeClosed(3, 6);
		testRanges2Stream.forEach(x -> new AmstrongFinder().findAmstrongNumber(x));
	}
}
