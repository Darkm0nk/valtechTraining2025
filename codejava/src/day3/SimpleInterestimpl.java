package day3;

public class SimpleInterestimpl implements SimpleInterest {

	public static void main(String[] args) {
		SimpleInterest si = new SimpleInterestimpl();
		System.out.println(si.computeInterest(2200, 12, 3));
			SimpleInterest newSi = new SimpleInterest() {
				@Override
				public double computeInterest(double principal, double rateOfInterest, double duration) {
					
					return SimpleInterest.super.computeInterest(principal, rateOfInterest, duration);
				}
			};
			System.out.println(newSi.computeInterest(2200, 12, 3));
//			SimpleInterest lambdaSi = (double p, double r, double d)->(p*r*d/100);
		
	}
}
