package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public abstract class Entity {

	private Map map;
	private int health;
	private Point point;
	
	public Entity(Map map, int health, Point point) {
		this.map = map;
		this.health = health;
		this.point = point;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public Point getPoint() {
		return point;
	}
	
	public void setPoint(Point point) {
		this.point = point;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public Map getMap() {
		return map;
	}
	
	/**
	 * Subtract the given damage from the health
	 * @param damage The amount to subtract from the health
	 */
	public void takeDamage(int damage){
		health -= damage;
	}
	
}
