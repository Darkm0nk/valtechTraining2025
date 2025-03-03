package com.valtech.training.first;

public class ArithmeticImpl implements Arithmetic {
		@Override
		public int add(int a,int b) {
			System.out.println("Add A="+a+"B ="+b);
			return a+b;
		}
		
		@Override
		public int sub(int a,int b) {
			System.out.println("Sub A ="+a+"B = "+b);
			return a-b;
		}
		
		@Override
		public int mult(int a,int b) {
			System.out.println("Mult A ="+a+"B = "+b);

			return a*b;
		}
		
		@Override
		public int div(int a,int b) {
			System.out.println("Div A ="+a+"B = "+b);

			return a/b;
		}
}
