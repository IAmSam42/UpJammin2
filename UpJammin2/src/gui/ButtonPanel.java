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
		None, Tower, Wall
	}
	
	private Selected button;
	
	public ButtonPanel() {
		
		this.button = Selected.None;
		
		JToggleButton tower = new JToggleButton("Tower");
		JToggleButton wall = new JToggleButton("Wall");
		JPanel buttonPanel = new JPanel();
		//if not set to tower, set to tower, otherwise set to none
		tower.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					if(button != Selected.Tower) {
						button = Selected.Tower;
						tower.setSelected(true);
						wall.setSelected(false);
					}
					else {
						button = Selected.None;
						tower.setSelected(false);
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
					tower.setSelected(false);
				}
				else {
					button = Selected.None;
					wall.setSelected(false);
				}
			}
		});
		
		buttonPanel.setLayout(new GridLayout(1,2));
		buttonPanel.add(tower);
		
		buttonPanel.add(wall);
		
		add(buttonPanel,BorderLayout.CENTER);
		
	}
	
	public Selected getSelected() {
		return button;
	}
}
