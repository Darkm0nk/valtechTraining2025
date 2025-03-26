package mocks;

public class SimpleInterestImpl implements SimpleInterest {

	private Arithmetic arithmetic;
	
	@Override
	public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic =arithmetic;
	}
	
	@Override
	public int compute(int prin, int rate, int time) {
		int prod = arithmetic.mul(rate, prin);
		prod = arithmetic.mul(rate, prod);
		return arithmetic.div(prod, 100);
	}
}
