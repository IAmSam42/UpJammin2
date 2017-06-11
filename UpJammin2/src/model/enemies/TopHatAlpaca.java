package model.enemies;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.Enemy;
import model.Map;

public class TopHatAlpaca extends Enemy {

	public TopHatAlpaca(Map map, int health, Point point) {
		super(map, health, point);
		
		this.setStolenGold(30);
	}

	@Override
	public void render(Graphics g, boolean hover) 
	{
		g.drawImage(new ImageIcon("resources/EnemyAlpacaTopHatRight.png").getImage(), this.getPoint().x, this.getPoint().y, null);	
	}
}
