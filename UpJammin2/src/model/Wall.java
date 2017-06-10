package model;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Wall extends Entity {
	
	public Wall(Map map, int health, Point point) {
		super(map, health, point);
		
		//Register the wall on the map.
		map.addBlockingEntity(this);
		
		//Increase the cost.
		this.getMap().getBank().increase_cost(Map.blockType.Wall);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g, boolean hover) {
		if(hover == false) {
			g.drawImage(new ImageIcon("resources/wall.jpg").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);
		}
		else {
			g.drawImage(new ImageIcon("resources/greyWall.jpg").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);
		}
	}

}
