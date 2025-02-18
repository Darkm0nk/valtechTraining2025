package day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArithmaticTest {
	
	private Arithmatic a = new SimpleArithmatic();
	@Test
	void testAdd() {
		assertEquals(5,a.add(2.7, 2.3),0.01);
	}

	@Test
	void testSub() {
		fail("Not yet implemented");
	}

	@Test
	void testMul() {
		fail("Not yet implemented");
	}

	@Test
	void testDiv() {
		fail("Not yet implemented");
	}
	
	
	
//	private void example(Arithmatic a) {
//		a.add(10,20);
//		a.sub(20, 10);
//		a.div(20, 10);
//		a.mul(20, 10);
//	}

}
