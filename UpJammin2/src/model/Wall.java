package model;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class Wall extends Entity {

	private Map map;
	private int health;
	private Point2D point;
	
	public Wall(Map map, int health, Point2D point) {
		super(map, health, point);
		this.map = map;
		this.health = health;
		this.point = point;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

}
