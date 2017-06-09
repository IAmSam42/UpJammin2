package ai;

import java.awt.Point;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Path {
	
	public Path() {
		
	}
	
	public ArrayList<Point> calculatePath(Point start, Point goal) {
		ArrayList<Point> visited = new ArrayList<Point>();
		PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>();
		queue.add(new Tuple(start, start.distance(goal)));
		
		return null;
	}
	
	
	
}
