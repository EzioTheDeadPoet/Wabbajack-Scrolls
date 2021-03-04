package en.wabbajack_scroll;

import en.wabbajack_scroll.gui.MainGui;


public class GUI {

	public static void main(String[] args) {
		MainGui mainGui = MainGui.getInstance();
		mainGui.setVisible(true);
	}
	
	public static void exit() {
		System.exit(0);

	}

}
