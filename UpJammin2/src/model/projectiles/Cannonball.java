package model.projectiles;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.Map;
import model.Projectile;

public class Cannonball extends Projectile{

	public Cannonball(Map map, int health, Point point, Point target, int speed) {
		super(map, health, point, target, speed);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void render(Graphics g) {
		g.drawImage(new ImageIcon("resources/cannonball.png").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);

	}

}
