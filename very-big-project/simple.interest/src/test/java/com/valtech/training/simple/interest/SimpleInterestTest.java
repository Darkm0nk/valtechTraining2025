package com.valtech.training.simple.interest;

import junit.framework.TestCase;

public class SimpleInterestTest extends TestCase {

	public void testSimpleInterest() {
		SimpleInterest si = new SimpleInterest();
		assertEquals(5, si.compute(5, 10, 10));
	}
}
