package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 * Contains information about the dimensions of the map, and which tiles are
 * being blocked by walls and turrets
 * 
 * @author sam
 *
 */
public class Map
{
	private int width;
	private int height;
	private int scale;
	private boolean[][] blocked;
	private ArrayList<Enemy> enemies;
	private ArrayList<Entity> notEnemies;

	/**
	 * Constructor for a map object.
	 * 
	 * @param height
	 *            The height of the map in grid references (not pixels).
	 * @param width
	 *            The width of the map in grid references (not pixels).
	 * @param scale
	 *            How many pixels per grid point.
	 */
	public Map(int width, int height, int scale)
	{
		this.setWidth(width);
		this.setHeight(height);
		this.setScale(scale);

		this.blocked = new boolean[width][height];
		
//		for (int i = 0; i < 20; i++) {
//			int x = new Random().nextInt(width);
//			int y = new Random().nextInt(height);
//			if(!this.blocked[x][y]){
//				this.blocked[x][y] = true;
//			}
//		}

		this.notEnemies = new ArrayList<Entity>();
	}

	/**
	 * Get the height of the map.
	 * 
	 * @return The height of the map.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Set the height of the map.
	 * 
	 * @param height
	 *            The new height of the map.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Set the width of the map.
	 * 
	 * @return The width of the map.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Set the width of the map.
	 * 
	 * @param width
	 *            The new width of the map.
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Get the scale of the map.
	 * 
	 * @return The scale of the map.
	 */
	public int getScale() {
		return scale;
	}

	/**
	 * Set the scale of the map.
	 * 
	 * @param scale
	 *            The new scale of the map.
	 */
	public void setScale(int scale) {
		this.scale = scale;
	}

	/**
	 * Check if a given x y coordinate is blocked in the grid.
	 * @param x The x (width) part of the coordinate.
	 * @param y The y (height) part of the coordinate.
	 * @return If the coordinate is blocked.
	 */
	public boolean isBlocked(int x, int y)
	{
		return blocked[x][y];
	}

	
	/**
	 * Get the location of the blocked array to determine if a location is blocked
	 * @param x The x coord
	 * @param y The y coord
	 * @return
	 */
	public boolean getBlockedLocation(int x, int y){
		return blocked[x][y];
	}
	
	
	/**
	 * Get the ArrayList of all the entities in the game.
	 * 
	 * @return An ArrayList of all the entities in the game,
	 */
	public ArrayList<Entity> getNonEnemies() {
		return notEnemies;
	}

	/**
	 * Add a new entity to the game.
	 * 
	 * @param entity
	 * 
	 *            The entity to add to the game.
	 */
	public void addNotEnemy(Entity entity) {
		notEnemies.add(entity);
	}
	
	/**
	 * Convert a point from pixel space to grid space
	 * @param pixel_point The pixel space point to covert to grid space.
	 * @return The grid space point the pixel space point is located in.
	 */
	public Point toGridPoint(Point pixel_point)
	{
		Point grid_point = new Point((int)(pixel_point.getX() / scale), 
				(int)(pixel_point.getY() / scale));
		
		return grid_point;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}
}
