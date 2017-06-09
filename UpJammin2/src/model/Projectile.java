package model;

import java.awt.Graphics2D;
import java.awt.Point;

public class Projectile extends Entity {

	private Map map;
	private int health;
	private Point point;
	private Point target;
	private int distance;
	private int pixelsPerTick;
	private int speed;
	private int addToX;
	private int addToY;
	
	
	public Projectile(Map map, int health, Point point, Point target, int speed) {
		super(map, health, point);
		this.map = map;
		this.health = health;
		this.point = point;
		this.target = target;
		this.speed = speed;
		calculate();
	}

	@Override
	public void tick() {
		this.point.setLocation(this.point.getX() + addToX, this.point.getY() + addToY);
	}
	
	public void calculate() {
		this.distance = (int) point.distance(target);
		//pixelsPerTick = (distance/speed);
		int xdist = (int) (point.getX() - target.getX());
		int ydist = (int) (point.getY() - target.getY());
		pixelsPerTick = distance/speed;
		int jumps = distance/pixelsPerTick;
		addToX = xdist/jumps;
		addToY = ydist/jumps;
	}
	
	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

}
