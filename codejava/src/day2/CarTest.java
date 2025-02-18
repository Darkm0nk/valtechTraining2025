package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
	
	@Test
	void testClone() throws Exception{
		Car car = new Car();
		Car car1 = (Car)car.clone();
		assertNotSame(car, car1);
	}
	
	@Test
	void testhashCode() {
		Car car = new Car("Honda","City","Vx",2024,7);
		int hash = car.hashCode();
		
		System.out.println(car+"hash::"+ hash);
		
		assertEquals(hash, car.hashCode());
		assertEquals(hash, new Car("Honda","City","Vx",2024,7).hashCode());
		
		car.setVariant("ZX");
//		int hash1 = car.hashCode();
		System.out.println(car+"hash::"+ car.hashCode());
		
		assertNotEquals(hash, car.hashCode());
		
		car.setModel("new");
		System.out.println(car+"hash::"+car.hashCode());
		
		assertNotEquals(hash, car.hashCode());
	}
	
	@Test
	void testToString() {
		Car car = new Car("Honda","City","Vx",2024,7);
		assertEquals("Honda City Vx 2024 Version 7 ", car.toString());
		car.setVariant("ZX");
		assertEquals("Honda City ZX 2024 Version 7 ", car.toString());
		car.setModel("new");
		assertEquals("Honda new ZX 2024 Version 7 ", car.toString());
	}

}
