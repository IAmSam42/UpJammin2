package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.GameEngine;

public class Main {
	private static JFrame frame;
	private static JPanel panel;

	public static int HEIGHT = 535;

	//public static int WIDTH = ((HEIGHT * 16)/9); 
	public static int WIDTH = (((HEIGHT * 16)/9)-42) - ((((HEIGHT * 16)/9)-42) - (((((HEIGHT * 16)/9)-42)/GameEngine.BLOCKSIZE)*GameEngine.BLOCKSIZE)); 
	
	//public static int WIDTH = (((HEIGHT * 16)/9)) - ((((HEIGHT * 16)/9)) - (((((HEIGHT * 16)/9))/GameEngine.BLOCKSIZE)*GameEngine.BLOCKSIZE)); 
	
	

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
		JLabel studios = new JLabel("By UpJammin' Studios");
		studios.setBounds(WIDTH*84/100, HEIGHT*95/100, 750, 15);
		studios.setFont(new Font("Press Start K", Font.PLAIN, 12));
		studios.setForeground(Color.WHITE);
		panel.add(studios);
		
		
		JButton play = new JButton("Play");
		play.setBounds(WIDTH/2-50, HEIGHT/2-25, 100, 50);
		play.setFont(new Font("Play", Font.PLAIN, 20));
		play.setForeground(Color.BLACK);
		play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new GameWindow(Main.WIDTH, HEIGHT, "Alpaca Attacker", new GameEngine());
				
			}
		});
		panel.add(play);
		
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new Main();
	}

}