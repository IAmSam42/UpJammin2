package model.projectiles;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.Enemy;
import model.Map;
import model.Projectile;

public class Arrow extends Projectile{

	public Arrow(Map map, int health, Point point, Enemy target, int speed,int damage, boolean right) {
		super(map, health, point, target, speed,damage, right);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void render(Graphics g, boolean hover) {
		if (this.getRight())
		{
			g.drawImage(new ImageIcon("resources/Arrow.png").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);
		}else
		{
			g.drawImage(new ImageIcon("resources/ArrowFlip.png").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);
		}
		
	}
}
