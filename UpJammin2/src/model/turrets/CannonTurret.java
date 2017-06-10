package model.turrets;

import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.Map;
import model.Turret;

public class CannonTurret extends Turret {

	public CannonTurret(Map map, int health, Point location, int range, int damage, int fireRate, int fireSpeed) {
		super(map, health, location, range, damage, fireRate, fireSpeed);
		// TODO Auto-generated constructor stub
	}

	public void render(Graphics2D g) 
	{
		if(this.isFacingRight())
		{
			g.drawImage(new ImageIcon("resources/cannonRight.jpg").getImage(), this.getMap().toGridPoint((this.getPoint())).x, this.getMap().toGridPoint((this.getPoint())).y, null);
		}
		else
		{
			g.drawImage(new ImageIcon("resources/cannonLeft.jpg").getImage(), this.getMap().toGridPoint((this.getPoint())).x, this.getMap().toGridPoint((this.getPoint())).y, null);
		}
	}
}
