package spring.ioc;

import java.awt.Point;

public class PointInstanceFactory {

	private int x;
	private int y;
	
	
	public PointInstanceFactory() {
		
	}


	public PointInstanceFactory(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public Point createPoint(int x , int y) {
		return new Point(x,y);
	}
}
