package ai;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

import model.Map;

public class Path {
	
	private Map map;
	
	public Path(Map map) {
		this.map = map;
	}
	
	/**
	 * This function calculates a path from a start to a goal
	 * @param start The starting position
	 * @param goal The goal
	 * @param width The width of the map
	 * @param height The height of the map
	 * @return The path from the start to the goal
	 */
	public ArrayList<Point> calculatePath(Point start, Point goal, int width, int height) {
		ArrayList<Point> visited = new ArrayList<Point>();
		PriorityQueue<Triple> queue = new PriorityQueue<Triple>();
		queue.add(new Triple(start, start.distance(goal), null));
		Triple current = queue.poll();
		
		while(!current.getPoint().equals(goal)) {
			ArrayList<Point> neighbours = getNeighbours(current.getPoint(), width, height);
			visited.add(current.getPoint());
			
			for(Point point : neighbours) {
				if(!visited.contains(point) && (map.isBlocked((int)point.getX(), (int)point.getY()) != true)) {
					queue.add(new Triple(point, point.distance(goal), current));
				}
			}
		}
		
		ArrayList<Point> path = new ArrayList<Point>();
		while(current.getParent() != null) {
			path.add(current.getPoint());
			current = current.getParent();
		}
		Collections.reverse(path);
		return path;
	}
	
	/**
	 * Gets all the possible neighbours of the given point
	 * @param point The given point
	 * @param width The width of the map
	 * @param height The height of the map
	 * @return All the neighbours of the given point
	 */
	public static ArrayList<Point> getNeighbours(Point point, int width, int height) {
		ArrayList<Point> points = new ArrayList<Point>();
		
		//above
		if(point.getY() - 1 >= 0) {
			Point x = new Point();
			x.setLocation(point.getX(), point.getY()-1);
			points.add(x);
		}
		
		//left
		if(point.getX() - 1 >= 0) {
			Point x = new Point();
			x.setLocation(point.getX()-1, point.getY());
			points.add(x);
		}
		
		//below
		if(point.getY() + 1 <= height) {
			Point x = new Point();
			x.setLocation(point.getX(), point.getY()+1);
			points.add(x);
		}
		
		//right
		if(point.getX() + 1 <= width) {
			Point x = new Point();
			x.setLocation(point.getX()+1, point.getY());
			points.add(x);
		}
		return points;
	}
	
	
	
}
