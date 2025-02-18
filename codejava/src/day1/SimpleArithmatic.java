package day1;

public class SimpleArithmatic implements Arithmatic{

	@Override
	public double add(double a, double b) {
		System.out.println(a+b);
		return a+b;
	}

	@Override
	public double sub(double a, double b) {
	
		return a-b;
	}

	@Override
	public double mul(double a, double b) {

		return  a*b;
	}

	@Override
	public double div(double a, double b) {
		
		return a/b;
	}
	
	public int div(int a, int b) {
		return a/b;
	}
	

}
