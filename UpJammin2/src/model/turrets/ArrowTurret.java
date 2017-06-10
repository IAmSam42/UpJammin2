package model.turrets;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.Map;
import model.Turret;

public class ArrowTurret extends Turret 
{

	public ArrowTurret(Map map, int health, Point location, int range, int damage, int fireRate, int fireSpeed) 
	{
		super(map, health, location, range, damage, fireRate, fireSpeed);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render(Graphics g) 
	{
		if(this.isFacingRight())
		{
			System.out.println("Right");
			g.drawImage(new ImageIcon("resources/crossbowRight.jpg").getImage(), (this.getPoint()).x,(this.getPoint()).y, null);
		}
		else
		{
			System.out.println("Left");
			System.out.println(this.getMap().toGridPoint((this.getPoint())).x);
			g.drawImage(new ImageIcon("resources/crossbowLeft.jpg").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);
		}
	}
}
