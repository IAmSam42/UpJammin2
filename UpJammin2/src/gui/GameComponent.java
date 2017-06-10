package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import engine.GameEngine;
import engine.GameEngineHandler;
import gui.ButtonPanel.Selected;
import model.Map;
import model.Turret;
import model.Wall;

public class GameComponent extends JPanel {
	public GameComponent(GameEngine game, ButtonPanel panel) {
		
		GameEngineHandler handler = game.getGameEngineHandler();
		
		Map map = handler.getMap();
		
		setLayout(new BorderLayout());
		
		add(game, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		game.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!map.isBlocked(map.toGridPoint(arg0.getPoint()))) {
					if(panel.getSelected() == Selected.Tower) {
						new Turret(map, 1, map.toPixelPoint(map.toGridPoint(arg0.getPoint())), 1, 1, 1, 1);
						//System.out.println(arg0.getPoint());
					}
					else if (panel.getSelected() == Selected.Wall) {
						new Wall(map, 1, map.toPixelPoint(map.toGridPoint(arg0.getPoint())));
						//System.out.println(arg0.getPoint());
					}
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
