package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import engine.GameEngine;
import engine.GameEngineHandler;
import gui.ButtonPanel.Selected;
import model.Map;
import model.Turret;
import model.Wall;
import model.turrets.ArrowTurret;
import model.turrets.CannonTurret;
import model.turrets.WizardTower;

public class GameComponent extends JPanel {
	public GameComponent(GameEngine game, ButtonPanel panel) {
		
		GameEngineHandler handler = game.getGameEngineHandler();
		
		Map map = handler.getMap();
		setLayout(new BorderLayout());
		add(game, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
	
		game.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				handler.setHover(map.toGridPoint(arg0.getPoint()));
			}
			
		});
		
		
		game.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

				if(map.isPlaceable(map.toGridPoint(arg0.getPoint()))) {

					if(panel.getSelected() == Selected.ArrowTurret) {
						
						//If the player can afford the ArrowTurret:
						if(map.getBank().canAfford(Map.blockType.ArrowTurret))
						{
							new ArrowTurret(map, 1, map.toPixelPoint(map.toGridPoint(arg0.getPoint())), 3, 50, 40, 20);
						}
						//System.out.println(arg0.getPoint());
					}
					else if (panel.getSelected() == Selected.Wall) {
						
						//If the player can afford the Wall:
						if(map.getBank().canAfford(Map.blockType.Wall))
						{
							new Wall(map, 1, map.toPixelPoint(map.toGridPoint(arg0.getPoint())));
						}
						//System.out.println(arg0.getPoint());
					}
					else if(panel.getSelected() == Selected.CannonTurret) {
						
						//If the player can afford the cannon turret:
						if(map.getBank().canAfford(Map.blockType.CannonTurret))
						{
							new CannonTurret(map, 1, map.toPixelPoint(map.toGridPoint(arg0.getPoint())), 5, 200, 200, 5);
						}
						//System.out.println(arg0.getPoint());
					} 
						else if(panel.getSelected() == Selected.Wizard) {
						
						//If the player can afford the cannon turret:
						if(map.getBank().canAfford(Map.blockType.Wizard))
						{
							new WizardTower(map, 1, map.toPixelPoint(map.toGridPoint(arg0.getPoint())), 7, 500, 400, 10);
						}
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
