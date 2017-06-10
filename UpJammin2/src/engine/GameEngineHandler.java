package engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import gui.Main;
import model.Bank;
import model.Enemy;
import model.Entity;
import model.Map;

import model.enemies.BowlerAlpaca;

import model.Map.blockType;
//import java.awt.Graphics2D;

public class GameEngineHandler {

	private Map map;
	private static int BLOCKSIZE = 64;
	private int level;
	private JSONArray levelsArray;
	private int wave;
	int tickCounter;
	private Bank bank;
	private Point hover;
	
	public GameEngineHandler() throws ParseException, FileNotFoundException, IOException{
		this.map = new Map(Main.WIDTH/BLOCKSIZE, Main.HEIGHT/BLOCKSIZE, BLOCKSIZE);
		level = 0;
		wave = 0;
		JSONParser parser = new JSONParser();

		String fileContents = ResourceManager.getResourceManager().getFileContents(Config.levels_file);
		levelsArray = (JSONArray) ((JSONObject) parser.parse(fileContents)).get("levels");
		bank = new Bank();
		newWave();
		hover = null;

	}
	
	public void newWave() {		
		JSONArray currentLevel = null;
		System.out.println(levelsArray.size() > level);
		if(levelsArray.size() > level) {
			currentLevel = ((JSONArray) levelsArray.get(level));
		} else {
			System.out.println("GAME WON");
			return;
		}
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
			new BowlerAlpaca(map, 1000, new Point(0, gen.nextInt(map.getHeight() * map.getScale())));
		}
		System.out.println(map.getEnemies().size());
		
		y = (Long) currentWave.get("enemyType2");
		x = y != null ? y.intValue() : null;
		for(int i = 0; i < x; i++) {
			new Enemy(map, 1000, new Point(0, gen.nextInt(map.getHeight())));
		}
		
		y = (Long) currentWave.get("enemyType3");
		x = y != null ? y.intValue() : null;
		for(int i = 0; i < x; i++) {
			new Enemy(map, 1000, new Point(0, gen.nextInt(map.getHeight())));
		}
		
		y = (Long) currentWave.get("enemyType4");
		x = y != null ? y.intValue() : null;
		for(int i = 0; i < x; i++) {
			new Enemy(map, 1000, new Point(0, gen.nextInt(map.getHeight())));
		}
	}
		
	public void tick() {
//		System.out.println("HEYYY I TICKED");
//		System.out.println("Width: " + Main.WIDTH/BLOCKSIZE);
//		System.out.println("Hight: " + Main.HEIGHT/BLOCKSIZE);
		if(map.getEnemies().size() == 0){
			wave++;
			newWave();
		}
		for(int i = 0; i < map.getEnemies().size(); i++) {
			if(map.getEnemies().get(i).getHealth() == 0) {
				map.removeEnemy(map.getEnemies().get(i));
				i--;
			}
		}
		for(int i = 0; i < map.getNonEnemies().size(); i++) {
			if(map.getNonEnemies().get(i).getHealth() == 0) {
				map.removeNonEnemy(map.getNonEnemies().get(i));
				i--;
			}
		}
		for(Entity ent : map.getEnemies())
			ent.tick();
		for(int i = 0; i < map.getNonEnemies().size(); i++) 
		{
			map.getNonEnemies().get(i).tick();
		}
		//for(Entity ent : map.getNonEnemies())
			//ent.tick();
		
	}
	

	public void render(Graphics g) {
//		System.out.println("HEYYY I RENDERED");

		ImageIcon grass_img = ResourceManager.getResourceManager().getImageIcon(Config.grass_file);
		ImageIcon brighter_grass_img = ResourceManager.getResourceManager().getImageIcon(Config.brighter_grass_file);
		ImageIcon cannon_left_img = ResourceManager.getResourceManager().getImageIcon(Config.cannon_left_file);
		ImageIcon wall = ResourceManager.getResourceManager().getImageIcon(Config.wall);
		ImageIcon greyCannonLeft = ResourceManager.getResourceManager().getImageIcon(Config.greyCannonLeft);
		ImageIcon greyWall = ResourceManager.getResourceManager().getImageIcon(Config.greyWall);
		
		for (int i = 0; i < Main.HEIGHT/BLOCKSIZE; i++) {
			for (int j = 0; j < Main.WIDTH/BLOCKSIZE; j++) {
				if(!map.isBlocked(new Point(j, i))){
					if(hover == null || (hover.getX() != j || hover.getY() != i)) {
						g.drawImage(grass_img.getImage(), j*BLOCKSIZE, i*BLOCKSIZE, null);
					}
					else {
						if(map.isPlaceable(new Point(j, i))) {
							g.drawImage(brighter_grass_img.getImage(), j*BLOCKSIZE, i*BLOCKSIZE, null);
						}
						else {
							g.drawImage(new ImageIcon("resources/greyGrass.jpg").getImage(), j*BLOCKSIZE, i*BLOCKSIZE, null);
						}
					}
				}
			}
		}
		if(bank.getBalance() < 250) {
			g.drawImage(new ImageIcon("resources/GoldChestClosed.png").getImage(), (int)map.toPixelPoint(map.getGoal()).getX(), (int)map.toPixelPoint(map.getGoal()).getY(), null);
		}
		else if(bank.getBalance() < 750) {
			g.drawImage(new ImageIcon("resources/GoldChestPhase1.png").getImage(), (int)map.toPixelPoint(map.getGoal()).getX(), (int)map.toPixelPoint(map.getGoal()).getY(), null);
		}
		else if(bank.getBalance() < 1500) {
			g.drawImage(new ImageIcon("resources/GoldChestPhase2.png").getImage(), (int)map.toPixelPoint(map.getGoal()).getX(), (int)map.toPixelPoint(map.getGoal()).getY(), null);
		}
		else if(bank.getBalance() < 3000) {
			g.drawImage(new ImageIcon("resources/GoldChestPhase3.png").getImage(), (int)map.toPixelPoint(map.getGoal()).getX(), (int)map.toPixelPoint(map.getGoal()).getY(), null);
		}
		else {
			g.drawImage(new ImageIcon("resources/GoldChestPhase4.png").getImage(), (int)map.toPixelPoint(map.getGoal()).getX(), (int)map.toPixelPoint(map.getGoal()).getY(), null);
		}
				
		ArrayList<Entity> entities = map.getNonEnemies();
		for(int i = 0; i < entities.size(); i++) {
			if(hover == null || (hover.getX() != map.toGridPoint(entities.get(i).getPoint()).getX() || hover.getY() != map.toGridPoint(entities.get(i).getPoint()).getY())) {
				entities.get(i).render(g, false);
			}
			else {
				entities.get(i).render(g, true);
			}
		}
		
		
					
//		}
//		System.out.println(map.getEnemies().size());
		for(Entity ent : map.getEnemies()){
			ent.render(g, false);
			//System.out.println(ent.getPoint());
		}
}

	
	public void setHover(Point p) {
		hover = p;
	}
	
	public Map getMap() {
		return map;
	}
	
}
