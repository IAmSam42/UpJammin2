package model;

import java.awt.Graphics;
import java.awt.Point;

public class Projectile extends Entity {

	private Enemy target;
	private double distance;
	private int speed;
	private int damage;
	private double angle;
	
	
	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public Projectile(Map map, int health, Point point, Enemy target, int speed, int damage) {
		super(map, health, point);
		this.target = target;
		this.speed = speed;
		this.damage = damage;
		map.addEntity(this);
	}

	@Override
	public void tick() 
	{
		double xdiff = target.getPoint().getX() - this.getPoint().getX();
		double ydiff =  target.getPoint().getY() - this.getPoint().getY();
		distance = Math.sqrt((xdiff*xdiff)+(ydiff*ydiff));
		if(distance<=15||target.getHealth()<=0)
		{
			System.out.println("health before: " + target.getHealth());
			this.setHealth(0);
			target.takeDamage(damage);
			System.out.println("health after: "+ target.getHealth());
		}
		else
		{
			//System.out.println("xdiff: " + xdiff + " ydiff: " + ydiff);
			angle = Math.atan((this.getPoint().getY()-target.getPoint().getY())/(this.getPoint().getX()-target.getPoint().getX()));
			System.out.println(angle);
			if (xdiff < 0)
			{
				this.setPoint(new Point((int) (this.getPoint().getX()-(speed*Math.cos(angle))), (int)(this.getPoint().getY() - (speed*Math.sin(angle)))));
			}
			else
			{
				this.setPoint(new Point((int) (this.getPoint().getX()+(speed*Math.cos(angle))), (int)(this.getPoint().getY() + (speed*Math.sin(angle)))));
			}
			//System.out.println(" target = " + target.getPoint() + "after move = " + this.getPoint());
			System.out.println("distance = " + Math.sqrt((xdiff*xdiff)+(ydiff*ydiff)));
		}
	}
	
	@Override
	public void render(Graphics g, boolean hover) {
		// TODO Auto-generated method stub
		
	}

}
