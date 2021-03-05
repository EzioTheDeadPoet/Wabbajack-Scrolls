package en.wabbajack_scroll;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import en.wabbajack_scroll.gui.MainGui;
import en.wabbajack_scroll.gui.panels.*;

import en.wabbajack_scroll.util.Settings;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.*;

public class GUI {
	private static MainGui mainGui;
	public static void main(String[] args) {
		Settings.SettingsInit();
	    try {
	    	if (Settings.ini.get("Main","Theme", String.class).equals("MaterialOceanicTheme")) {
    			UIManager.setLookAndFeel(new MaterialLookAndFeel(new MaterialOceanicTheme()));
    		}
    		if (Settings.ini.get("Main","Theme", String.class).equals("MaterialLiteTheme")) {
    			UIManager.setLookAndFeel(new MaterialLookAndFeel(new MaterialLiteTheme()));
    		}
    		if (Settings.ini.get("Main","Theme", String.class).equals("JMarsDarkTheme")) {
    			UIManager.setLookAndFeel(new MaterialLookAndFeel(new JMarsDarkTheme()));
    		}
    		if (Settings.ini.get("Main","Theme", String.class).equals("System")) {
    			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    		}
	    } catch (Exception ex) {
	    	try {
    			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		mainGui = MainGui.getInstance();
		mainGui.setVisible(true);
	}
	
	public static void exit() {
		System.exit(0);

	}

	public static void restart() {
		SwingUtilities.updateComponentTreeUI(mainGui);
		SettingsPanel.fc.updateUI();
		ManageDownloadsPanel.fcdir.updateUI();
		ManageDownloadsPanel.fcfile.updateUI();
		CleanDownloadsPanel.fcdir.updateUI();
		CleanDownloadsPanel.fcfile.updateUI();
		CreateChangelogPanel.fcclog.updateUI();
		CreateChangelogPanel.fcfile.updateUI();
		
	}

}
