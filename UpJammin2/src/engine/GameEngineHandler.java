package engine;

import java.awt.Graphics;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import gui.Main;
import model.Bank;
import model.Enemy;
import model.Entity;
import model.Map;
import model.Map.blockType;
//import java.awt.Graphics2D;

public class GameEngineHandler {

	private Map map;
	private static int BLOCKSIZE = Config.block_size;
	private int level;
	private int wave;
	int tickCounter;
	
	private JSONArray levelsArray;
	private Bank bank;
	private Point hover;
	
	public GameEngineHandler() throws ParseException, FileNotFoundException, IOException{
		this.map = new Map(Main.WIDTH/BLOCKSIZE, Main.HEIGHT/BLOCKSIZE, BLOCKSIZE);
		level = 0;
		wave = 0;
		hover = null;
		bank = new Bank();
		levelsArray = (JSONArray) ResourceManager.getResourceManager().getJSONArrayFromFile(Config.levels_file).get("levels");
		
		newWave();
	}
	
	public void newWave() {
		/*get current game level; if passed the game level print game over*/
		JSONArray currentLevel = null;
		System.out.println(levelsArray.size() > level);
		if(levelsArray.size() > level) {
			currentLevel = ((JSONArray) levelsArray.get(level));
		} else {
			System.out.println("GAME WON");
			return;
		}
		
		/*get current wave; if done start again*/
		JSONObject currentWave = null;
		if(currentLevel.size() > wave) {
			currentWave = ((JSONObject) currentLevel.get(wave));
		} else {
			level++;
			//PAUSE
			bank.endDay();
			
			//PLAY
			newWave();
			return;
		}

		Random gen = new Random();
		Long y = (Long) currentWave.get("enemyType1");
		Integer x = y != null ? y.intValue() : null;
		for(int i = 0; i < x; i++) {
			map.getEnemies().add(new Enemy(map, 10, new Point(map.getWidth(), gen.nextInt(map.getHeight()))));
		}
		
		y = (Long) currentWave.get("enemyType2");
		x = y != null ? y.intValue() : null;
		for(int i = 0; i < x; i++) {
			map.getEnemies().add(new Enemy(map, 10, new Point(map.getWidth(), gen.nextInt(map.getHeight()))));
		}
		
		y = (Long) currentWave.get("enemyType3");
		x = y != null ? y.intValue() : null;
		for(int i = 0; i < x; i++) {
			map.getEnemies().add(new Enemy(map, 10, new Point(map.getWidth(), gen.nextInt(map.getHeight()))));
		}
		
		y = (Long) currentWave.get("enemyType4");
		x = y != null ? y.intValue() : null;
		for(int i = 0; i < x; i++) {
			map.getEnemies().add(new Enemy(map, 10, new Point(map.getWidth(), gen.nextInt(map.getHeight()))));
		}
	}
		
	public void tick() {
//		System.out.println("HEYYY I TICKED");
//		System.out.println("Width: " + Main.WIDTH/BLOCKSIZE);
//		System.out.println("Height: " + Main.HEIGHT/BLOCKSIZE);
		if(map.getEnemies().size() == 0){
			wave++;
			newWave();
		}
		for(Entity ent : map.getEnemies())
			ent.tick();
		for(Entity ent : map.getNonEnemies())
			ent.tick();
		
	}
	

	public void render(Graphics g) {
//		System.out.println("HEYYY I RENDERED");
		ImageIcon grass_img = ResourceManager.getResourceManager().getImageIcon(Config.grass_file);
		ImageIcon brighter_grass_img = ResourceManager.getResourceManager().getImageIcon(Config.brighter_grass_file);
		ImageIcon cannon_left_img = ResourceManager.getResourceManager().getImageIcon(Config.cannon_left_file);
		ImageIcon wall = ResourceManager.getResourceManager().getImageIcon(Config.wall);
		
		for (int i = 0; i < Main.HEIGHT/BLOCKSIZE; i++) {
			for (int j = 0; j < Main.WIDTH/BLOCKSIZE; j++) {
				if(!map.isBlocked(new Point(j, i))){
					if(hover == null || (hover.getX() != j || hover.getY() != i)) {
						g.drawImage(grass_img.getImage(), j*BLOCKSIZE, i*BLOCKSIZE, null);
					}
					else {
						g.drawImage(brighter_grass_img.getImage(), j*BLOCKSIZE, i*BLOCKSIZE, null);
					}
				}else{
					if(map.findNonEnemy(new Point(j, i)) == blockType.Turret) {
						g.drawImage(cannon_left_img.getImage(), j*BLOCKSIZE, i*BLOCKSIZE, null);
					}
					else if(map.findNonEnemy(new Point(j, i)) == blockType.Wall) {
						g.drawImage(wall.getImage(), j*BLOCKSIZE, i*BLOCKSIZE, null);
					}
				}
			}
		}
	}
	
	public void setHover(Point p) {
		hover = p;
	}
	
	public Map getMap() {
		return map;
	}
	
}
