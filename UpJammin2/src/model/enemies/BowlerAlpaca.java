package model.enemies;

import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.Enemy;
import model.Map;

public class BowlerAlpaca extends Enemy{

	public BowlerAlpaca(Map map, int health, Point point) {
		super(map, health, point);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics2D g) 
	{
		g.drawImage(new ImageIcon("resources/EnemyAlpacaBowerHatRight.jpg").getImage(), this.getMap().toGridPoint((this.getPoint())).x, this.getMap().toGridPoint((this.getPoint())).y, null);
	}
}
