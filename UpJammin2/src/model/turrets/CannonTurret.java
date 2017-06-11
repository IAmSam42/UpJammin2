package model.turrets;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.Enemy;
import model.Map;
import model.Turret;
import model.projectiles.Arrow;
import model.projectiles.Cannonball;

public class CannonTurret extends Turret {

	public CannonTurret(Map map, int health, Point location, int range, int damage, int fireRate, int fireSpeed) {
		super(map, health, location, range, damage, fireRate, fireSpeed);
		
		//Increase the cost.
		this.getMap().getBank().buyBlock(Map.blockType.CannonTurret);
	}

	@Override
	public void render(Graphics g, boolean hover) 
	{
		if(this.isFacingRight())
		{
			if(hover == false) {
				g.drawImage(new ImageIcon("resources/cannonRight.jpg").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);
			}
			else {
				g.drawImage(new ImageIcon("resources/greyCannonRight.jpg").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);
			}
		}
		else
		{
			if(hover == false) {
				g.drawImage(new ImageIcon("resources/cannonLeft.jpg").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);
			}
			else {
				g.drawImage(new ImageIcon("resources/greyCannonLeft.jpg").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);
			}
		}
	}

	@Override
	public void createProjectile(Map map, int i, Point point, Enemy targetted, int fireSpeed, int damage) 
	{
		new Cannonball(getMap(), 1, new Point(getPoint()), targetted, fireSpeed, damage, this.isFacingRight());
	}
}
