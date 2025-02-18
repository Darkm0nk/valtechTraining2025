package com.valtech.training.arithmatic;

public interface operation {
	
	public static final operation add = (a,b)->a+b;
	public static final operation sub = (a,b)->a-b;
	public static final operation mul = (a,b)->a*b;
	public static final operation div = (a,b)->a/b;
	int perform(int a, int b);
}
