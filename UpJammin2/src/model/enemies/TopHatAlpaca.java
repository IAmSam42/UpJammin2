package model.enemies;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.Enemy;
import model.Map;

public class TopHatAlpaca extends Enemy {

	private int flip;
	private int current;

	public TopHatAlpaca(Map map, int health, Point point) {
		super(map, health, point);
		this.flip = 0;
		this.current = 0;
		
		this.setStolenGold(50);
	}

	@Override
	public void render(Graphics g, boolean hover) 
	{
		g.drawImage(new ImageIcon("resources/EnemyAlpacaTopHatRight.png").getImage(), this.getPoint().x, this.getPoint().y, null);	
		if (this.flip<17)
		{
			this.flip++;
			if (this.current == 0)
			{
				g.drawImage(new ImageIcon("resources/EnemyAlpacaTopHatRight.png").getImage(), this.getPoint().x, this.getPoint().y, null);
			}
			else
			{
				g.drawImage(new ImageIcon("resources/EnemyAlpacaTopHatLeft.png").getImage(), this.getPoint().x, this.getPoint().y, null);
			}
		}
		else
		{
			this.flip = 0;
			if (this.current == 0)
			{
				this.current = 1;
				g.drawImage(new ImageIcon("resources/EnemyAlpacaTopHatRight.png").getImage(), this.getPoint().x, this.getPoint().y, null);
			}
			else
			{
				this.current = 0;
				g.drawImage(new ImageIcon("resources/EnemyAlpacaTopHatLeft.png").getImage(), this.getPoint().x, this.getPoint().y, null);
			}
		}
	}
}
