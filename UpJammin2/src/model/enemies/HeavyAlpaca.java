package model.enemies;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.Enemy;
import model.Map;

public class HeavyAlpaca extends Enemy {

	public HeavyAlpaca(Map map, int health, Point point) {
		super(map, health, point);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(new ImageIcon("resources/EnemyAlpacaBowlerHatRight.jpg").getImage(), this.getMap().toGridPoint((this.getPoint())).x, this.getMap().toGridPoint((this.getPoint())).y, null);
	}

}
