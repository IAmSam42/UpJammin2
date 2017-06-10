package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Projectile extends Entity {

	private Point point;
	private Point target;
	private int distance;
	private int pixelsPerTick;
	private int speed;
	private int addToX;
	private int addToY;
	private int jumps;
	
	
	public Projectile(Map map, int health, Point point, Point target, int speed) {
		super(map, health, point);
		this.point = point;
		this.target = target;
		this.speed = speed;
		calculate();
		
		map.addEntity(this);
	}

	@Override
	public void tick() {
		if(jumps > 0) {
			this.point.setLocation(this.point.getX() + addToX, this.point.getY() + addToY);
			jumps--;
		}
		else {
		}
	}
	
	public void calculate() {
		this.distance = (int) point.distance(target);
		int xdist = (int) (point.getX() - target.getX());
		int ydist = (int) (point.getY() - target.getY());
		pixelsPerTick = distance/speed;
		jumps = distance/pixelsPerTick;
		addToX = xdist/jumps;
		addToY = ydist/jumps;
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
