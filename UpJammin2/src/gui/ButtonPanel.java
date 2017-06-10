package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import model.Bank;
import model.Map.blockType;

public class ButtonPanel extends JPanel implements Observer {
	public enum Selected {
		None, ArrowTurret, CannonTurret, Wall
	}
	
	private Bank bank;
	private Selected button;
	private String arrowLabel;
	private String cannonLabel;
	private String wallLabel;
	
	private JToggleButton arrowTurret;
	private JToggleButton cannonTurret;
	private JToggleButton wall;
	
	public ButtonPanel(Bank bank) {
		
		this.button = Selected.None;
		this.bank = bank;
		this.arrowLabel = "Arrow Turret - " + bank.getCost(blockType.ArrowTurret);
		this.cannonLabel = "Cannon Turret - " + bank.getCost(blockType.CannonTurret);
		this.wallLabel = "Wall - " + bank.getCost(blockType.Wall);
		
		bank.addObserver(this);
		arrowTurret = new JToggleButton(arrowLabel);
		cannonTurret = new JToggleButton(cannonLabel);
		wall = new JToggleButton(wallLabel);
	
		
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

	@Override
	public void update(Observable o, Object arg) {
		arrowTurret.setText("Arrow Turret - " + bank.getCost(blockType.ArrowTurret));
		cannonTurret.setText("Cannon Turret - " + bank.getCost(blockType.CannonTurret));
		wall.setText("Wall - " + bank.getCost(blockType.Wall));
		
	}
}
