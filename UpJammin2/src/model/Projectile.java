package model;

import java.awt.Graphics;
import java.awt.Point;

public class Projectile extends Entity {

	private Enemy target;
	private int distance;
	private int speed;
	private int damage;
	private double angle;
	
	
	public Projectile(Map map, int health, Point point, Enemy target, int speed, int damage) {
		super(map, health, point);
		this.target = target;
		this.speed = 4;
		this.damage = 1000;
		map.addEntity(this);
	}

	@Override
	public void tick() 
	{
		if((this.getPoint().getX() == target.getPoint().getX())&&(this.getPoint().getY() == target.getPoint().getY()))
		{
			System.out.println("health before: " + target.getHealth());
			this.setHealth(0);
			target.takeDamage(damage);
			System.out.println("health after: "+ target.getHealth());
		}
		else
		{
			double xdiff = target.getPoint().getX() - this.getPoint().getX();
			double ydiff =  target.getPoint().getY() - this.getPoint().getY();
			
			//System.out.println("xdiff: " + xdiff + " ydiff: " + ydiff);
			angle = Math.atan((this.getPoint().getY()-target.getPoint().getY())/(this.getPoint().getX()-target.getPoint().getX()));
			//System.out.println("arrow" + this + "start = " + this.getPoint());
			this.setPoint(new Point((int) (this.getPoint().getX()-(speed*Math.cos(angle))), (int)(this.getPoint().getY() - (speed*Math.sin(angle)))));
			//System.out.println(" target = " + target.getPoint() + "after move = " + this.getPoint());
		}
	}
	
	@Override
	public void render(Graphics g, boolean hover) {
		// TODO Auto-generated method stub
		
	}

}
