package model.projectiles;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.Enemy;
import model.Map;
import model.Projectile;

public class Lightning extends Projectile{

	public Lightning(Map map, int health, Point point, Enemy target, int speed, int damage, boolean right) {
		super(map, health, point, target, speed, damage,right);
		// TODO Auto-generated constructor stub
		
	}
	public void render(Graphics g, boolean hover) {
		if (!this.getRight())
		{
			g.drawImage(new ImageIcon("resources/lightning.png").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);
		}
		else
		{
			g.drawImage(new ImageIcon("resources/lightningFlip.png").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);
		}
	}

}
