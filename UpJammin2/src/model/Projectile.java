package model;

import java.awt.Graphics;
import java.awt.Point;

public class Projectile extends Entity {

	private Point target;
	private int distance;
	private int pixelsPerTick;
	private int speed;
	private int addToX;
	private int addToY;
	private int jumps;
	
	
	public Projectile(Map map, int health, Point point, Point target, int speed) {
		super(map, health, point);
		this.target = target;
		this.speed = speed;
		calculate();
		
		map.addEntity(this);
	}

	@Override
	public void tick() {
		if(jumps > 0) {
			this.getPoint().setLocation(this.getPoint().getX() + addToX, this.getPoint().getY() + addToY);
			jumps--;
		}
		else {
			this.setHealth(0);
		}
	}
	
	public void calculate() {
		this.distance = (int) this.getPoint().distance(target);
		int xdist = (int) (target.getX() - this.getPoint().getX());
		int ydist = (int) (target.getY()- this.getPoint().getY());
		pixelsPerTick = distance/speed;
		jumps = distance/pixelsPerTick;
		addToX = xdist/jumps;
		addToY = ydist/jumps;
	}
	
	@Override
	public void render(Graphics g, boolean hover) {
		// TODO Auto-generated method stub
		
	}

}
