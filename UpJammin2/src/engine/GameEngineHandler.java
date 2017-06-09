package engine;

import java.awt.Graphics;

import gui.GameWindow;
import gui.Main;
import model.Map;
//import java.awt.Graphics2D;

public class GameEngineHandler {

	private Map map;
	private static int BLOCKSIZE = 32;
	
	public GameEngineHandler(){
		this.map = new Map(Main.WIDTH, Main.HEIGHT, BLOCKSIZE);
	}
	
	public void tick() {
		System.out.println("HEYYY I TICKED");
		
		
	}
	

	public void render(Graphics g) {
		System.out.println("HEYYY I RENDERED");
		for (int i = 0; i < Main.WIDTH; i++) {
			for (int j = 0; j < Main.HEIGHT; j++) {
				
			}
		}
		
		
	}
	
}
