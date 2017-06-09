package ai;

import java.awt.Point;

public class Tuple implements Comparable<Tuple> {

	private Point point;
	private double distance;
	
	public Tuple(Point point, double distance) {
		this.point = point;
		this.distance = distance;
	}

	public Point getPoint() {
		return point;
	}
	
	public double getDistance() {
		return distance;
	}
	
	@Override
	public int compareTo(Tuple tuple) {
		if(tuple.getDistance() > distance) {
			return -1;
		}
		else if(tuple.getDistance() < distance) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
