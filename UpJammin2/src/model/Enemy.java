package model;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class Enemy extends Entity {

	private ArrayList<Point> path;
	
	public Enemy(Map map, int health, Point point) {
		super(map, health, point);
	}

	@Override
	public void tick() 
	{
		//If the path is empty:
		if(path.isEmpty())
		{
			//Don't do anything in the tick.
			return;
		}
		
		
		//Convert the current point to a grid reference.
		Point grid_point = this.getMap().toGridPoint(this.getPoint());
		
		//If the enemy is at the next part of the path:
		if(path.get(0).equals(grid_point))
		{
			//Then remove the next part of the path.
			path.remove(0);
		}
		
		
		//If the path is empty:
		if(path.isEmpty())
		{
			//Don't do anything in the tick.
			return;
		}
		
		
		//Work out the direction for the next point in the path.
		

	}

	@Override
	public void render(Graphics2D g) 
	{
		// TODO Auto-generated method stub

	}

}
