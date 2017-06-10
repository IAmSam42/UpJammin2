package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.GameEngine;

public class Main {
	private static JFrame frame;
	private static JPanel panel;

	public static int HEIGHT = 750;
	//public static int WIDTH = ((HEIGHT * 16)/9); 
	public static int WIDTH = ((HEIGHT * 16)/9) - (((HEIGHT * 16)/9) - ((((HEIGHT * 16)/9)/GameEngine.BLOCKSIZE)*GameEngine.BLOCKSIZE)); 
	
	

	public Main(){
		
		
		frame = new JFrame("Alpaca Attacker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.BLACK);
		panel.setSize(WIDTH, HEIGHT);

	    frame.getContentPane().add(panel);
		panel.setLayout(null);

		//Uptown Jammin'
		JLabel studios = new JLabel("By UpJammin' Studios, Version 0.7");
		studios.setBounds(15, 740, 750, 15);
		studios.setFont(new Font("Press Start K", Font.PLAIN, 12));
		studios.setForeground(Color.BLUE);
		panel.add(studios);
		
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new Main();
	}

}