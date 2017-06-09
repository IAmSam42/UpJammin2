package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import engine.GameEngine;

public class GameWindow extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	

	
	public GameWindow(int w, int h, String title, GameEngine game){
		

		Dimension dimention = new Dimension(w, h);
		setMaximumSize(dimention);
		setMinimumSize(dimention);
		setPreferredSize(dimention);
		
		pack();
	
		game.setBounds(0, 0, w, h);
		add(game, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		game.start();
		
	}
	
	public static void main(String[] args) {
		new GameWindow(Main.WIDTH, Main.HEIGHT, "Alpaca Attacker", new GameEngine());
	}

}