package com.wabbajack_scrolls.gui.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartPanel extends JPanel {
	
	private JLabel startMesssage = new JLabel("This is a GUI for some neat Wabbajack-CLI features, for streamlined access. BUT still VERY WIP!");
	
	public StartPanel() {
		add(startMesssage);
	}
}
