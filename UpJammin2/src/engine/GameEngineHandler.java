package engine;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import gui.GameWindow;
import gui.Main;
import model.Map;
//import java.awt.Graphics2D;

public class GameEngineHandler {

	private Map map;
	private static int BLOCKSIZE = 64;
	
	public GameEngineHandler(){
		this.map = new Map(Main.WIDTH/BLOCKSIZE, Main.HEIGHT/BLOCKSIZE, BLOCKSIZE);
	}
	
	public void tick() {
//		System.out.println("HEYYY I TICKED");
//		System.out.println("Width: " + Main.WIDTH/BLOCKSIZE);
//		System.out.println("Hight: " + Main.HEIGHT/BLOCKSIZE);
		
		
	}
	

	public void render(Graphics g) {
//		System.out.println("HEYYY I RENDERED");
		for (int i = 0; i < Main.HEIGHT/BLOCKSIZE; i++) {
			for (int j = 0; j < Main.WIDTH/BLOCKSIZE; j++) {
				if(!map.getBlockedLocation(j, i)){
					g.drawImage(new ImageIcon("resources/grassTexture.jpg").getImage(), j*BLOCKSIZE, i*BLOCKSIZE, null);
				}else{
					g.drawImage(new ImageIcon("resources/cannonLeft.jpg").getImage(), j*BLOCKSIZE, i*BLOCKSIZE, null);
					System.out.println("something else should be rendered instead of the floor in this positon");
				}
			}
		}
	}
	
}
