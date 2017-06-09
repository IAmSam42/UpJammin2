package model;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class Projectile extends Entity {

	private Map map;
	private int health;
	private Point point;
	private Point2D target;
	private double distance;
	private double pixelsPerTick;
	private int speed;
	
	public Projectile(Map map, int health, Point2D point, Point2D target, int speed) {
		super(map, health, point);
		this.map = map;
		this.health = health;
		this.point = point;
		this.target = target;
		this.speed = speed;
	}

	@Override
	public void tick() {
		
	}
	
	public void calculate() {
		this.distance = point.distance(target);
		pixelsPerTick = (distance/speed);
		
	}
	
	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

}
