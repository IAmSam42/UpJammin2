package model.turrets;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.Enemy;
import model.Map;
import model.Turret;
import model.projectiles.Cannonball;
import model.projectiles.Lightning;

public class WizardTower extends Turret{

	public WizardTower(Map map, int health, Point location, int range, int damage, int fireRate, int fireSpeed) {
		super(map, health, location, range, damage, fireRate, fireSpeed);
		
		//Increase the cost.
		this.getMap().getBank().buyBlock(Map.blockType.Wizard);
	}
	public void render(Graphics g, boolean hover) 
	{
		if(this.isFacingRight())
		{
			if(hover == false) {
				g.drawImage(new ImageIcon("resources/wizardRight.jpg").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);
			}
			else {
				g.drawImage(new ImageIcon("resources/greyWizardRight.jpg").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);
			}
		}
		else
		{
			if(hover == false) {
				g.drawImage(new ImageIcon("resources/wizardLeft.jpg").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);
			}
			else {
				g.drawImage(new ImageIcon("resources/greyWiardLeft.jpg").getImage(), ((this.getPoint())).x, ((this.getPoint())).y, null);
			}
		}
	}
	@Override
	public void createProjectile(Map map, int i, Point point, Enemy targetted, int fireSpeed, int damage) {
		new Lightning(getMap(), 1, new Point(getPoint()), targetted, fireSpeed, damage, this.isFacingRight());
	}
}
