package model.turrets;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.Map;
import model.Turret;

public class ArrowTurret extends Turret 
{

	public ArrowTurret(Map map, int health, Point location, int range, int damage, int fireRate, int fireSpeed) 
	{
		super(map, health, location, range, damage, fireRate, fireSpeed);
		
		//Increase the cost
		this.getMap().getBank().increaseCost(Map.blockType.ArrowTurret);
	}
	
	@Override
	public void render(Graphics g, boolean hover) 
	{
		if(this.isFacingRight())
		{
			if(hover == false) {
				g.drawImage(new ImageIcon("resources/crossbowRight.jpg").getImage(), (this.getPoint()).x,(this.getPoint()).y, null);
			}
			else {
				g.drawImage(new ImageIcon("resources/greyCrossbowRight.jpg").getImage(), (this.getPoint()).x,(this.getPoint()).y, null);
			}
		}
		else
		{
			if(hover == false) {
				g.drawImage(new ImageIcon("resources/crossbowLeft.jpg").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);
			}
			else {
				g.drawImage(new ImageIcon("resources/greyCrossbowLeft.jpg").getImage(), (this.getPoint()).x,(this.getPoint()).y, null);
			}
		}
	}
}
