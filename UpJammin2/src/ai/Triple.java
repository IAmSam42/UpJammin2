package ai;

import java.awt.Point;

public class Triple implements Comparable<Triple> {

	private Point point;
	private double distance;
	private Triple parent;
	
	public Triple(Point point, double distance, Triple parent) {
		this.point = point;
		this.distance = distance;
		this.parent = parent;
	}

	public Point getPoint() {
		return point;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public Triple getParent() {
		return parent;
	}
	
	@Override
	public int compareTo(Triple Triple) {
		if(Triple.getDistance() > distance) {
			return -1;
		}
		else if(Triple.getDistance() < distance) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
