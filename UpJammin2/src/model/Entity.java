package model;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public abstract class Entity {

	private Map map;
	private int health;
	private Point2D point;
	
	public Entity(Map map, int health, Point2D point) {
		this.map = map;
		this.health = health;
		this.point = point;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics2D g);
	
	public abstract Point2D getPoint();
	
	public abstract int getHealth();
	
	public abstract Map getMap();
	
}
