package model;

import java.awt.Point;
import java.util.ArrayList;



/**
 * Contains information about the dimensions of the map, and which tiles are
 * being blocked by walls and turrets
 * 
 * @author sam
 *
 */
public class Map {
	private int width;
	private int height;
	private int scale;
	
	private Point goal; //Where the gold be at.
	
	private boolean[][] blocked;
	private ArrayList<Enemy> enemies;
	private ArrayList<Entity> nonEnemies;
	
	public enum blockType {
		Turret, Wall, None
	}

	/**
	 * Constructor for a map object.
	 * @param height The height of the map in grid references (not pixels).
	 * @param width The width of the map in grid references (not pixels).
	 * @param scale How many pixels per grid point.
	 */
	public Map(int width, int height, int scale) {
		this.setWidth(width);
		this.setHeight(height);
		this.setScale(scale);

		//Calculate the goal (the end column and half the height).
		goal = new Point(width - 1, (int)(height / 2));
		
		//Setup all the arrays
		this.blocked = new boolean[width][height];
		this.enemies = new ArrayList<Enemy>();
		this.nonEnemies = new ArrayList<Entity>();
	}

	/**
	 * Convert a point from pixel space to grid space
	 * 
	 * @param pixel_point
	 *            The pixel space point to covert to grid space.
	 * @return The grid space point the pixel space point is located in.
	 */
	public Point toGridPoint(Point pixel_point) {
		Point grid_point = new Point((int) (pixel_point.getX() / scale), (int) (pixel_point.getY() / scale));

		return grid_point;
	}

	/**
	 * Convert a grip point to a pixel point. Method returns the top left pixel
	 * for a given grid point.
	 * 
	 * @param grid_point
	 *            The grid point to convert.
	 * @return The top left pixel for the given grid point.
	 */
	public Point toPixelPoint(Point grid_point) {
		Point pixel_point = new Point((int) grid_point.getX() * scale, (int) grid_point.getY() * scale);

		return pixel_point;
	}

	/**
	 * Add a non-blocking entity to the game.
	 * @param entity The entity to add.
	 */
	public void addEntity(Entity entity) {
		nonEnemies.add(entity);
	}
	
	/**
	 * Add a blocking entity to the game - both adding it to the array list to
	 * receive ticks and blocking the relevant grip points to prevent unroutable
	 * walls.
	 * 
	 * @param entity
	 *            The entity to add to the game.
	 * @return Whether the entity was added to the game.
	 */
	public boolean addBlockingEntity(Entity entity) {
		// Get the grid coordinates of the entity.
		Point grid_point = this.toGridPoint(entity.getPoint());

		// If the tile is blocked:
		if (this.isBlocked(grid_point)) {
			// The entity cannot be added, so return false.
			return false;
		}

		// Mark the grip point as blocked.
		this.setBlocked(grid_point, true);

		// Add the entity to the none enemy array list.
		nonEnemies.add(entity);

		return true;
	}

	/**
	 * Add an enemy to the game, registering it in the enemy array list so it
	 * can receive ticks.
	 * 
	 * @param enemy
	 *            The enemy to add to the game.
	 */
	public void addEnemy(Enemy enemy) {
		// Add the enemy to the enemy array list.
		enemies.add(enemy);
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
	 * Get the goal point.
	 * @return The goal.
	 */
	public Point getGoal()
	{
		return goal;
	}

	/**
	 * Check if a given point is blocked in the grid.
	 * 
	 * @param point
	 *            The point to check.
	 * @return If the point is blocked.
	 */
	public boolean isBlocked(Point point) {
		return blocked[(int) point.getX()][(int) point.getY()];
	}

	/**
	 * Set a given point to be blocked or unblocked.
	 * 
	 * @param point
	 *            The point to mark as blocked or not.
	 * @param blocked
	 *            If the point is blocked or not.
	 */
	public void setBlocked(Point point, boolean blocked) {
		this.blocked[(int) point.getX()][(int) point.getY()] = blocked;
	}

	/**
	 * Get the ArrayList of all the none-enemy entities in the game.
	 * @return An ArrayList of all the entities in the game,
	 */
	public ArrayList<Entity> getNonEnemies() {
		return nonEnemies;
	}

	/**
	 * Get the enemy array list.
	 * @return The array list of the enemies.
	 */
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	
	public blockType findNonEnemy(Point p) {
		for(int i = 0; i < nonEnemies.size(); i++) {
			if(this.toGridPoint(nonEnemies.get(i).getPoint()).equals(p)) {
				if(nonEnemies.get(i) instanceof Turret) {
					return blockType.Turret;
				}
				else {
					return blockType.Wall;
				}
			}
		}
		return blockType.Turret;
	}
}
