package com.wabbajack_scrolls.gui.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ForceHealPanel extends JPanel {
	
	private final JLabel startMesssage = new JLabel("Force Heal panel.");
	
	public ForceHealPanel() {
		add(startMesssage);
	}
}
