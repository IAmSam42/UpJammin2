package engine;

import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import gui.GameWindow;
import gui.Main;
import model.Bank;
import model.Enemy;
import model.Entity;
import model.Map;
//import java.awt.Graphics2D;

public class GameEngineHandler {

	private Map map;
	private static int BLOCKSIZE = 64;
	private int level;
	private JSONArray levelsArray;
	private int wave;
	int tickCounter;
	private Bank bank;
	
	public GameEngineHandler() throws ParseException, FileNotFoundException, IOException{
		this.map = new Map(Main.WIDTH/BLOCKSIZE, Main.HEIGHT/BLOCKSIZE, BLOCKSIZE);
		level = 0;
		wave = 0;
		JSONParser parser = new JSONParser();
		


		
		levelsArray = (JSONArray) ((JSONObject) parser.parse(new FileReader("resources/levels.json"))).get("levels");
		bank = new Bank();
		newWave();
	}
	
	public void newWave() {		
		JSONArray currentLevel = null;
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
	
		System.out.println("hello1");
		for(int i = 0; i < x; i++) {
			System.out.println(map.getEnemies());
			//map.getEnemies().add(new Enemy(map, 10, new Point(map.getWidth(), gen.nextInt(map.getHeight()))));
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
		for (int i = 0; i < Main.HEIGHT/BLOCKSIZE; i++) {
			for (int j = 0; j < Main.WIDTH/BLOCKSIZE; j++) {
				if(!map.isBlocked(new Point(j, i))){
					g.drawImage(new ImageIcon("resources/grassTexture.jpg").getImage(), j*BLOCKSIZE, i*BLOCKSIZE, null);
				}else{
					g.drawImage(new ImageIcon("resources/cannonLeft.jpg").getImage(), j*BLOCKSIZE, i*BLOCKSIZE, null);
//					System.out.println("something else should be rendered instead of the floor in this positon");
				}
			}
		}
	}
	
}
