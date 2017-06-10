package model.projectiles;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.Map;
import model.Projectile;

public class Arrow extends Projectile{

	public Arrow(Map map, int health, Point point, Point target, int speed) {
		super(map, health, point, target, speed);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void render(Graphics g, boolean hover) {
		g.drawImage(new ImageIcon("resources/Arrow.png").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);

	}
}
