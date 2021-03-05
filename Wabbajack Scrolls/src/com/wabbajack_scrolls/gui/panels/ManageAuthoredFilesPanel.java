package com.wabbajack_scrolls.gui.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ManageAuthoredFilesPanel extends JPanel {
	
	private JLabel startMesssage = new JLabel("Authored files manager panel.");
	
	public ManageAuthoredFilesPanel() {
		add(startMesssage);
	}
}
