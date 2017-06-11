package model.enemies;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.Enemy;
import model.Map;

public class HeavyAlpaca extends Enemy {

	public HeavyAlpaca(Map map, int health, Point point) {
		super(map, health, point);
		
		this.setStolenGold(50);
	}
	
	@Override
	public void render(Graphics g, boolean hover) 
	{
		g.drawImage(new ImageIcon("resources/EnemyAlpacaTopHatTieBriefcaseRight.png").getImage(), this.getPoint().x, this.getPoint().y, null);
	}

}
