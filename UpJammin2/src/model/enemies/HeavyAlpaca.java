package model.enemies;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.Enemy;
import model.Map;

public class HeavyAlpaca extends Enemy {

	private int flip;
	private int current;

	public HeavyAlpaca(Map map, int health, Point point) {
		super(map, health, point);
		this.flip = 0;
		this.current = 0;
		
		this.setStolenGold(100);
	}
	
	@Override
	public void render(Graphics g, boolean hover) 
	{
		if (this.flip<17)
		{
			this.flip++;
			if (this.current == 0)
			{
				g.drawImage(new ImageIcon("resources/EnemyAlpacaTopHatTieBriefcaseRight.png").getImage(), this.getPoint().x, this.getPoint().y, null);
			}
			else
			{
				g.drawImage(new ImageIcon("resources/EnemyAlpacaTopHatTieBriefcaseLeft.png").getImage(), this.getPoint().x, this.getPoint().y, null);
			}
		}
		else
		{
			this.flip = 0;
			if (this.current == 0)
			{
				this.current = 1;
				g.drawImage(new ImageIcon("resources/EnemyAlpacaTopHatTieBriefcaseRight.png").getImage(), this.getPoint().x, this.getPoint().y, null);
			}
			else
			{
				this.current = 0;
				g.drawImage(new ImageIcon("resources/EnemyAlpacaTopHatTieBriefcaseLeft.png").getImage(), this.getPoint().x, this.getPoint().y, null);
			}
		}
	}
	

}
