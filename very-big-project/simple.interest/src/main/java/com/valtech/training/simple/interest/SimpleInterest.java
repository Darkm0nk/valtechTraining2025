package com.valtech.training.simple.interest;
import com.valtech.training.arithmatic.operation;
public class SimpleInterest {

	public int compute(int price, int rate , int time) {
		int product = operation.mul.perform(price*rate,time);
		return operation.div.perform(product,100);
	}
}
