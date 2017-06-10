package model;

import java.awt.Graphics2D;
import java.awt.Point;

public class Wall extends Entity {
	
	public Wall(Map map, int health, Point point) {
		super(map, health, point);
		
		//Register the wall on the map.
		map.addBlockingEntity(this);
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
