package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import engine.Config;
import engine.ResourceManager;
import model.FinUpgrade;
import model.UpgradeWindowModel;

public class UpgradeWindow extends JFrame {

	/**
	 * 
	 */
	private UpgradeWindowModel model;
	private JPanel upgradesContainer;
	public UpgradeWindow(UpgradeWindowModel model) {
		this.model = model;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Time to upgrade");
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(640, 700);;
		setVisible(true);
		setLayout(new BorderLayout());
		JComponent centralThing = new JComponent() {
		
		   @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.drawImage(ResourceManager.getResourceManager().getImageIcon(Config.FinUpgradesScreen).getImage(), 0, 0, this);
		    }
			
		};
		centralThing.setLayout(new GridLayout(1, 2));
		
		add(centralThing, BorderLayout.CENTER);
		JButton closeButton = new JButton("Play next day");
		//closeButton.setIcon(ResourceManager.getResourceManager().getImageIcon(Config.FinUpgradesBottomBar));
		closeButton.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Unpause gameEngineHandler
				System.out.println("Here");
				UpgradeWindow.this.setVisible(false); //you can't see me!
				UpgradeWindow.this.dispose();
				
				
			}
		});
		closeButton.setBounds(0, 0, 640, 40);
		add(closeButton, BorderLayout.SOUTH);
		upgradesContainer = new JPanel();
		upgradesContainer.setLayout(new BoxLayout(upgradesContainer, BoxLayout.Y_AXIS));
		
		centralThing.add(upgradesContainer);
		updateUpgrades();
		
	}
	

	private void updateUpgrades() {
		upgradesContainer.removeAll();;
		for(FinUpgrade upgrade : model.getFinUpgrades()) {
			
			UpgradeOption upgradePannel = new UpgradeOption(ResourceManager.getResourceManager().getImageIcon(Config.greyWall), upgrade.getTitle(), upgrade.getSubtitle());
			upgradesContainer.add(upgradePannel);
			
			upgradesContainer.add(Box.createRigidArea(new Dimension(0, 20)));
		}
		
	}


	//Test it like there's no tomorrow
	public static void main(String args[]){
	
		System.out.println("HERE");
		UpgradeWindowModel mod = new UpgradeWindowModel();
		UpgradeWindow wind = new UpgradeWindow(mod); 
		System.out.println("HERE2");
		
	}
}
