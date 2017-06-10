package model.enemies;

import java.awt.Graphics;
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
		g.drawImage(new ImageIcon("resources/EnemyAlpacaBowlerHatRight.png").getImage(), this.getPoint().x, this.getPoint().y, null);
	}

}
