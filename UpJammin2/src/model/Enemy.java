package model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import ai.Path;

public class Enemy extends Entity {

	private ArrayList<Point> path;
	private Path path_finder;
	
	public Enemy(Map map, int health, Point point) {
		super(map, health, point);
		
		path_finder = new Path(this.getMap());
		path = new ArrayList<Point>();
		
		path = path_finder.calculatePath(map.toGridPoint(this.getPoint()), map.getGoal());

		map.addEnemy(this);
	}

	@Override
	public void tick() 
	{
		System.out.println(this.getPoint());
		
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
			
			if(this.getMap().isBlocked(path.get(0)))
			{
				path = path_finder.calculatePath(this.getMap().toGridPoint(this.getPoint()), this.getMap().getGoal());
			}
		}
		
		
		//If the path is empty:
		if(path.isEmpty())
		{
			//Don't do anything in the tick.
			return;
		}
		
		
		//Work out the direction for the next point in the path.
		int x_move = (int)Math.abs(grid_point.getX() - path.get(0).getX());
		int y_move = (int)Math.abs(grid_point.getY() - path.get(0).getY());
		
		//Create a new point (old point plus the movement amount.
		Point new_point = new Point((int)this.getPoint().getX() + x_move, 
									(int)this.getPoint().getY() + y_move);
		
		//Set the new point of the enemy.
		this.setPoint(new_point);

	}

	@Override
	public void render(Graphics g, boolean hover) 
	{
		// TODO Auto-generated method stub

	}

}
