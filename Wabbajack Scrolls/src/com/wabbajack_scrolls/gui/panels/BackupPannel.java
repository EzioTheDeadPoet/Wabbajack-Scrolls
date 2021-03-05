package com.wabbajack_scrolls.gui.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BackupPannel extends JPanel {
	
	private JLabel startMesssage = new JLabel("Backup panel.");
	
	public BackupPannel() {
		add(startMesssage);
	}
}
