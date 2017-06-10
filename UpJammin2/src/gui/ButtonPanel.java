package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ButtonPanel extends JPanel {
	public enum Selected {
		None, ArrowTurret, CannonTurret, Wall
	}
	
	private Selected button;
	
	public ButtonPanel() {
		
		this.button = Selected.None;
		
		JToggleButton arrowTurret = new JToggleButton("ArrowTurret");
		JToggleButton cannonTurret = new JToggleButton("CannonTurret");
		JToggleButton wall = new JToggleButton("Wall");
		
		
		JPanel buttonPanel = new JPanel();
		//if not set to tower, set to tower, otherwise set to none
		arrowTurret.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					if(button != Selected.ArrowTurret) {
						button = Selected.ArrowTurret;
						arrowTurret.setSelected(true);
						wall.setSelected(false);
						cannonTurret.setSelected(false);
					}
					else {
						button = Selected.None;
						arrowTurret.setSelected(false);
					}
			}
		});
		
		cannonTurret.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					if(button != Selected.CannonTurret) {
						button = Selected.CannonTurret;
						cannonTurret.setSelected(true);
						wall.setSelected(false);
						arrowTurret.setSelected(false);
					}
					else {
						button = Selected.None;
						cannonTurret.setSelected(false);
					}
			}
		});
		
		//if not set to wall, set to wall, otherwise set to none
		wall.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(button != Selected.Wall) {
					button = Selected.Wall;
					wall.setSelected(true);
					arrowTurret.setSelected(false);
					cannonTurret.setSelected(false);
				}
				else {
					button = Selected.None;
					wall.setSelected(false);
				}
			}
		});
		
		buttonPanel.setLayout(new GridLayout(1,3));
		buttonPanel.add(arrowTurret);
		buttonPanel.add(cannonTurret);
		buttonPanel.add(wall);
		
		add(buttonPanel,BorderLayout.CENTER);
		
	}
	
	public Selected getSelected() {
		return button;
	}
}
