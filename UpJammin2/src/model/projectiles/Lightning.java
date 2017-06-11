package model.projectiles;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.Enemy;
import model.Map;
import model.Projectile;

public class Lightning extends Projectile{

	public Lightning(Map map, int health, Point point, Enemy target, int speed, int damage) {
		super(map, health, point, target, speed, damage);
		// TODO Auto-generated constructor stub
		
	}
	public void render(Graphics g, boolean hover) {
		g.drawImage(new ImageIcon("resources/lightning.jpg").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);
	}

}
