package model;

import java.awt.Graphics;
import java.awt.Point;

public class Turret extends Entity {

	private int range;
	private int damage;
	private int fireRate;
	private Enemy targetted;
	private int ttNextFire;
	private int fireSpeed;
	private boolean facingRight;
	
	public Turret(Map map, int health, Point location, int range, int damage, int fireRate, int fireSpeed) {
		super(map, health, location);
		this.range = range;
		this.damage = damage;
		this.fireRate = fireRate;
		this.fireSpeed = fireSpeed;
		targetted = null;
		ttNextFire = 0; //<1 -> Ready to fire
		setFacingRight(false);
		//Register the turret on the map.
		map.addBlockingEntity(this);
	}

	@Override
	public void tick() {
		ttNextFire--;
		if(targetted == null){
			System.out.println("enemies: " + getMap().getEnemies().size());
			for(Entity ent : getMap().getEnemies()){
				System.out.println("looking for enemy");
				System.out.println("Wc "+ent.getPoint()+" fefw "+this.getPoint() + " ffefe " + ent.getPoint().distance(this.getPoint()));
					if(ent.getPoint().distance(this.getPoint())<range) {
						System.out.println("found enemy");
						targetted = (Enemy) ent;
						fireAtTarget();
						return;
					}
				
			}
		} else{
			fireAtTarget();
		}

	}
	
	private void fireAtTarget() {
		assert(targetted != null);
		if(targetted.getHealth() < 0 || targetted.getPoint().distance(getPoint()) > range * getMap().getScale()){
			targetted = null;
			return;
		}
		if(ttNextFire > 0)
			return;
		
		ttNextFire = fireRate;
		new Projectile(getMap(), 1, getPoint(), targetted.getPoint(), fireSpeed);
		setDir();
	}

	private void setDir() {
		facingRight = (getPoint().x - targetted.getPoint().x) < 0; 
	}
	
	@Override
	public void render(Graphics g, boolean hover) {
		

	}

	public boolean isFacingRight() {
		return facingRight;
	}

	public void setFacingRight(boolean facingRight) {
		this.facingRight = facingRight;
	}


}
