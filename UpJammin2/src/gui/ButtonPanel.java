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
		None, ArrowTurret, CannonTurret, Wall ,Wizard
	}
	
	private Bank bank;
	private Selected button;
	private String arrowLabel;
	private String cannonLabel;
	private String wallLabel;
	private String wizardLabel;
	
	private JToggleButton arrowTurret;
	private JToggleButton cannonTurret;
	private JToggleButton wall;
	private JToggleButton wizard;
	
	private JLabel progress;
	private JLabel money;
	
	public ButtonPanel(Bank bank) {
		
		this.progress = new JLabel("Evade that tax!");
		this.button = Selected.None;
		this.bank = bank;
		this.arrowLabel = "Arrow - " + bank.getCost(blockType.ArrowTurret);
		this.cannonLabel = "Cannon - " + bank.getCost(blockType.CannonTurret);
		this.wallLabel = "Wall - " + bank.getCost(blockType.Wall);
		this.wizardLabel = "Wizard - " + "";
		bank.addObserver(this);
		arrowTurret = new JToggleButton(arrowLabel);
		cannonTurret = new JToggleButton(cannonLabel);
		wall = new JToggleButton(wallLabel);
		wizard = new JToggleButton(wizardLabel);
		
		JPanel buttonPanel = new JPanel();
		//if not set to tower, set to tower, otherwise set to none
		arrowTurret.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					if(button != Selected.ArrowTurret) {
						button = Selected.ArrowTurret;
						wizard.setSelected(false);
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
						wizard.setSelected(false);
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
					wizard.setSelected(false);
					arrowTurret.setSelected(false);
					cannonTurret.setSelected(false);
				}
				else {
					button = Selected.None;
					wall.setSelected(false);
				}
			}
		});
		wizard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button != Selected.Wizard) {
					button = Selected.Wizard;
					wizard.setSelected(true);
					arrowTurret.setSelected(false);
					cannonTurret.setSelected(false);
					wall.setSelected(false);
			}
			else {
				button = Selected.None;
				wizard.setSelected(false);
			}
		}
	});
		
		money = new JLabel();
		money.setText("�" + bank.getBalance());
		buttonPanel.setLayout(new GridLayout(1,2));
		buttonPanel.add(arrowTurret);
		buttonPanel.add(cannonTurret);

		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new GridLayout(1,2));
		buttonPanel2.add(wall);
		buttonPanel2.add(wizard);
		
		//buttonPanel.add(money);
		
		setLayout(new GridLayout(1,3));
		
		add(buttonPanel);
		add(buttonPanel2);
		JPanel moneyPanel = new JPanel();
		moneyPanel.add(money, BorderLayout.CENTER);
		add(moneyPanel);
		
		JPanel progressPanel = new JPanel();
		progressPanel.add(progress, BorderLayout.CENTER);
		
		JPanel labels = new JPanel();
		labels.setLayout(new GridLayout(1,2));
		labels.add(moneyPanel);
		labels.add(progressPanel);
		add(labels);
	}
	
	public Selected getSelected() {
		return button;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(bank.getBalance() <= 0) {
			progress.setText("YOU LOSE");
		}
		arrowTurret.setText("Arrow Turret - " + bank.getCost(blockType.ArrowTurret));
		cannonTurret.setText("Cannon Turret - " + bank.getCost(blockType.CannonTurret));
		wall.setText("Wall - " + bank.getCost(blockType.Wall));

		wizard.setText("Wizard - " + bank.getCost(blockType.Wall));

		money.setText("�" + bank.getBalance());

		
	}
}
