package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UpgradeOption extends JPanel {

	public UpgradeOption(ImageIcon image, String title, String subtitle) {
		setLayout(new GridLayout(1,2));
		
		JPanel imagePanel = new JPanel();
		JLabel imageLabel = new JLabel();
		imageLabel.setIcon(image);
		imagePanel.add(imageLabel);
		add(imagePanel);
		
		JPanel titlepanel = new JPanel();
		titlepanel.setLayout(new BorderLayout());
		JLabel titleLabel = new JLabel(title);
		
		JLabel subtitleLabel = new JLabel(subtitle);
		titlepanel.add(titleLabel, BorderLayout.NORTH);
		titlepanel.add(subtitleLabel, BorderLayout.CENTER);
		
		add(titlepanel);
		setBounds(0, 0, 100, 300);
		
	}
}
