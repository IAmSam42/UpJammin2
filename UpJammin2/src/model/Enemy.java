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
		System.out.println("tick");
		//If the path is empty:
		if(path.isEmpty())
		{
			this.setHealth(0);
			
			//Don't do anything in the tick.
			return;
		}
		
		//Convert the current point to a grid reference.
		Point target_point = path.get(0);
		
		//Get the pixel coordinates of the top left.
		Point pixel_point = this.getMap().toPixelPoint(target_point);
		
		//If the enemy is at the top left corner:
		if(this.getPoint().equals(pixel_point))
		{
			//Remove the first element of the path.
			path.remove(0);
			
			//If there are still points in the path and the next point is blocked:
			if(!path.isEmpty() && this.getMap().isBlocked(path.get(0)))
			{
				//Recalculate the path.
				path = path_finder.calculatePath(this.getMap().toGridPoint(this.getPoint()), this.getMap().getGoal());
			}
			
			//Move on the next tick.
			return;
		}
		
		//Get x and y coordinate of the enemy.
		int x_coord = (int)this.getPoint().getX();
		int y_coord = (int)this.getPoint().getY();
		
		//Work out the movement needed.
		int x_diff = (int)pixel_point.getX() - x_coord;
		int y_diff = (int)pixel_point.getY() - y_coord;
		
		//Normalise both differences.
		x_diff = normalise(x_diff);
		y_diff = normalise(y_diff);
		
		//Get the new position of the enemy.
		Point new_point = new Point(x_coord + x_diff, y_coord + y_diff);
		
		//Set the new position.
		this.setPoint(new_point);
	}
	
	/**
	 * Manually recalculate the path
	 */
	public void recalculatePath()
	{
		path = path_finder.calculatePath(this.getMap().toGridPoint(this.getPoint()), this.getMap().getGoal());
	}
	
	/**
	 * Reduce an int to an int between -1 and 1.
	 * @param x The int to reduce.
	 * @return The reduced int.
	 */
	private int normalise(int x)
	{
		if(x == 0)
		{
			return 0;
		}
		else if(x < 0)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}

	@Override
	public void render(Graphics g, boolean hover) 
	{
		// TODO Auto-generated method stub

	}

}
