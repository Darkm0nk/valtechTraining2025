package day1;

public class Point {
		public final static double zero = 0;
		private double x ;
		private double y ;
		
		public Point() {};
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		 
//		public abstract void markMeOnScreen();
		public final double getX() {
			return x;
		}
		
		public final double getY() {
			return y;
		}
		
		public final void setX(double x) {
			this.x = x;
		}
		public final void setY(double y) {
			this.y = y;
		}
		
		public double distance() {
			return Math.sqrt(x*x + y*y);
		}
		
		public double distance(Point p) {
			return distance(p.x,p.y);
		}
		
		public double distance(final double x1,final double y1) {
			double diffx = x1 - x;
			double diffy = y1 - y;
			return Math.sqrt(diffx * diffx + diffy * diffy);
		}
		public static void main(String[] args) {
			Point p = new Point(10,20);
			System.out.println(p);
			System.out.println(p.distance());
			System.out.println(p.distance(100, 200));
			System.out.println(p.distance(p));
		}
		
		@Override
		public String toString() {
		return "Point x :" + x+ " Point Y : " + y;
		}
}
		
