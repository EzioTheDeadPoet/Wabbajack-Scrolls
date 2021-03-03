package en.wabbajack_scroll.gui.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SettingsPanel extends JPanel {
	
	private JLabel message = new JLabel("Settingspage here will open on 1st launch.");
	
	public SettingsPanel() {
		add(message);
	}
}
