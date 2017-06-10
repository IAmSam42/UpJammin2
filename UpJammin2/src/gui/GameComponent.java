package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import engine.GameEngine;
import gui.ButtonPanel.Selected;
import model.Turret;

public class GameComponent extends JPanel {
	public GameComponent(GameEngine game, ButtonPanel panel) {
		setLayout(new BorderLayout());
		
		add(game, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		game.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(panel.getSelected() == Selected.Tower) {
					//System.out.println(arg0.getPoint());
				}
				else if (panel.getSelected() == Selected.Wall) {
					//System.out.println(arg0.getPoint());
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
}
