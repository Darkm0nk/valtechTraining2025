package com.valtech.training.unittesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ArithmeticImplTest {

	private Arithmetic arithmetic ;
	
	@BeforeAll
	public static void awsas() {
		System.out.println("Before All........");
	}
	
	@BeforeEach
	public void some() {
		System.out.println("Init.....");
		arithmetic = new ArithmeticImpl();
	}
	
	static Stream<Arguments> addArgumentsProvider(){
		return Stream.of(Arguments.of(2,3,5),
				Arguments.of(-1,2,1),
				Arguments.of(5,-5,0));
	}
	
	@ParameterizedTest(name = "Add with Method Source A ={0} B = {1} resuklt ={2}")
	@MethodSource(value ="addArgumentsProvider")
	void testAddWithMethodSource(int a , int b , int result) {
		assertEquals(result, arithmetic.add(a, b));
	}
	@ParameterizedTest(name = "Add with CSV File A ={0} B ={1} Result = {2}")
	@CsvFileSource(files = "data.csv")
	void testAddWithCsvFile(int a, int b ,int result) {
		assertEquals(result, arithmetic.add(a, b));
	}
	
	@ParameterizedTest(name ="Add with  CSV Source A ={0} B ={1} Result = {2}")
	@CsvSource(value ={"2,3,5","-1,3,2","0,3,3"})
	void testAddWithCsv(int a, int b , int result) {
		assertEquals(result, arithmetic.add(a, b));
	}
	
	@ParameterizedTest(name = "Add with multiple Values")
	@ValueSource(strings = {"5,2,3","4,2,2","0,3,-3"})
	void testAddAgain(String param) {//"5,2,3","4,2,2","0,3,-3"
		List<Integer> args = Arrays.asList(param.split(",")).stream().map(it->Integer.parseInt(it)).collect(Collectors.toList()); 
		assertEquals(args.get(0),arithmetic.add(args.get(1), args.get(2)));
	}
	
	@Test
	void testAdd() {
		System.out.println("Add");
		assertEquals(5, arithmetic.add(2, 3));
	}
	
	@Test
	void testSub() {
		System.out.println("Sub");
		assertEquals(-1, arithmetic.sub(2, 3));
	}
	
	@Test
	void testMul() {
		System.out.println("Mul");
		assertEquals(6, arithmetic.mul(2, 3));
	}
	
	@Test
	void testDiv() {
		System.out.println("Div");
		assertEquals(2, arithmetic.div(6, 3));
		
//		System.out.println("Enter number:");
//		Scanner sc=new Scanner(System.in);
//		int a=sc.nextInt();
//		System.out.println(a);
	}
}




