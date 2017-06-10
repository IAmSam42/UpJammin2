package model.enemies;

import java.awt.Graphics;
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
	public void render(Graphics g) 
	{
		g.drawImage(new ImageIcon("resources/EnemyAlpacaBowlerHatRight.png").getImage(), this.getPoint().x,this.getPoint().y, null);
	}
}
