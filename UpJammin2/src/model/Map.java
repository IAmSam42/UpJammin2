package model;

/**
 * Contains information about the dimensions of the map, and which tiles 
 * are being blocked by walls and turrets
 * @author sam
 *
 */
public class Map
{
	private int height;
	private int width;
	private int scale;
	private boolean[][] blocked;
	
	/**
	 * Constructor for a map object.
	 * @param height The height of the map in grid references (not pixels).
	 * @param width The width of the map in grid references (not pixels).
	 * @param scale How many pixels per grid point.
	 */
	public Map(int height, int width, int scale)
	{
		this.setHeight(height);
		this.setWidth(width);
		this.setScale(scale);
		
		this.blocked = new boolean[width][height];
	}

	/**
	 * Get the height of the map.
	 * @return The height of the map.
	 */
	public int getHeight() 
	{
		return height;
	}

	/**
	 * Set the height of the map.
	 * @param height The new height of the map.
	 */
	public void setHeight(int height) 
	{
		this.height = height;
	}

	/**
	 * Set the width of the map.
	 * @return The width of the map.
	 */
	public int getWidth() 
	{
		return width;
	}

	/**
	 * Set the width of the map.
	 * @param width The new width of the map.
	 */
	public void setWidth(int width)
	{
		this.width = width;
	}

	/**
	 * Get the scale of the map.
	 * @return The scale of the map.
	 */
	public int getScale() 
	{
		return scale;
	}

	/**
	 * Set the scale of the map.
	 * @param scale The new scale of the map.
	 */
	public void setScale(int scale) 
	{
		this.scale = scale;
	}

	/**
	 * Get the array of blocked grid points.
	 * @return The blocked grid points.
	 */
	public boolean[][] getBlocked() 
	{
		return blocked;
	}
}
