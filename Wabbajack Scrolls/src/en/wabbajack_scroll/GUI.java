package en.wabbajack_scroll;

import en.wabbajack_scroll.gui.MainGui;
import en.wabbajack_scroll.util.Settings;

public class GUI {

	public static void main(String[] args) {
		Settings.SettingsInit();
		MainGui mainGui = MainGui.getInstance();
		mainGui.setVisible(true);
	}
	
	public static void exit() {
		System.exit(0);

	}

}
