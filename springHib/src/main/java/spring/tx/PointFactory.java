package spring.tx;

import java.awt.Point;

public class PointFactory {
	
	static int i;
	public static Point createPoint() {
		return new Point(i++,i);
	}
	
	public static Point createPoint(int x, int y) {
		System.out.println("X:: "+x+"Y:: "+y);
		return new Point(x,y);
	}
}

