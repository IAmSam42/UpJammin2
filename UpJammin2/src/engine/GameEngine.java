package engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class GameEngine extends Canvas implements Runnable {
	private static final long serialVersionUID = 1750355504600161501L;
	public static boolean running;
	public static boolean paused;
	private Thread thread;
	
	
	public static int BLOCKSIZE = 32;
	
	private GameEngineHandler gameEngineHandler;
	
	public GameEngine(){
		
		try {
			this.gameEngineHandler = new GameEngineHandler();
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		running = false;
	}
	

	/**
	 * Starts the Game
	 */
	public synchronized void start(){
		
		if(running){
			return;
		}
		paused = false;
		running = true;
		thread = new Thread(this);
		thread.start();

	}
	
	/**
	 * Stops the Game
	 */
	public synchronized void stop(){
		System.out.println("STOP");
		running = false;
	}
	
	@Override
	public void run() {
		
		double fpsTimer = System.currentTimeMillis();
		double nsPerTick = 1000000000.0d/60;
		double then = System.nanoTime();
		double unprocessed = 0;
		while(running){

			boolean canRender = false;
			double now = System.nanoTime();
			unprocessed += (now - then) / nsPerTick;
			then = now;
			while(unprocessed >= 1){
				tick();
				canRender = true;
				--unprocessed;
			}
			try{
				Thread.sleep(1);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			if(canRender){
				render();
			}
			
			if(System.currentTimeMillis() - fpsTimer > 1000){
				fpsTimer += 1000;
			}
		}
		while(paused){}
	}
	

	/**
	 * Tick method for the game (Update)
	 */
	public void tick(){
//		System.out.println("TICK ME LIKE ONE OF YOUR FRENCH GIRLS");
		this.gameEngineHandler.tick();
	}


	/**
	 * Render all the graphics
	 */
	public void render(){
//		System.out.println("RENDER THE DUCK OUT OF ME ");
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
//		Create Graphics to draw
		Graphics g = bs.getDrawGraphics();
//		Graphics2D g2d = (Graphics2D)g;
				
//		Colour frame background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);

//		g2d.translate(cam.getX(), cam.getY());
		
		gameEngineHandler.render(g);
	
//		g2d.translate(-cam.getX(), -cam.getY());
		
		g.dispose();
		bs.show();
	}
	
	public GameEngineHandler getGameEngineHandler() {
		return gameEngineHandler;
	}
	
}
