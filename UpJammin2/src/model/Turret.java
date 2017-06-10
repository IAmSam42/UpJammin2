package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
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
			for(Entity ent : getMap().getNonEnemies()){
				if(ent instanceof Enemy)
					if(ent.getPoint().distance(getPoint())<range) {
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
		getMap().getNonEnemies().add(new Projectile(getMap(), 1, getPoint(), targetted.getPoint(), fireSpeed));
		setDir();
	}

	private void setDir() {
		facingRight = (getPoint().x - targetted.getPoint().x) > 0; 
	}
	
	@Override
	public void render(Graphics g) {
		

	}

	public boolean isFacingRight() {
		return facingRight;
	}

	public void setFacingRight(boolean facingRight) {
		this.facingRight = facingRight;
	}


}
