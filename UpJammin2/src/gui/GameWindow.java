package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

import org.json.simple.parser.ParseException;

import engine.GameEngine;

public class GameWindow extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	
	public GameWindow(int w, int h, String title, GameEngine game){
		//System.out.println("hello");
		Dimension dimention = new Dimension(w, h);
		setMaximumSize(dimention);
		setMinimumSize(dimention);
		setPreferredSize(dimention);
		
		pack();
		
		ButtonPanel panel = new ButtonPanel(game.getGameEngineHandler().getBank());
		GameComponent comp = new GameComponent(game, panel);
		
		comp.setBounds(0, 0, w, h);
		add(comp, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		game.start();
		
	}
	
//	public static void main(String[] args) {
//			new GameWindow(Main.WIDTH, Main.HEIGHT, "Alpaca Attacker", new GameEngine());
//	}

}