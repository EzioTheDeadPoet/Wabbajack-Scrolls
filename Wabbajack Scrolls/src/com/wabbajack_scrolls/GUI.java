package com.wabbajack_scrolls;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.wabbajack_scrolls.gui.MainGui;
import com.wabbajack_scrolls.gui.panels.CleanDownloadsPanel;
import com.wabbajack_scrolls.gui.panels.CreateChangelogPanel;
import com.wabbajack_scrolls.gui.panels.ManageDownloadsPanel;
import com.wabbajack_scrolls.gui.panels.SettingsPanel;
import com.wabbajack_scrolls.util.Settings;
import com.wabbajack_scrolls.util.ThemeSetter;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.JMarsDarkTheme;

public class GUI {
	private static MainGui mainGui;
	public static void main(String[] args) {





		Settings.Init();
	    try {
			ThemeSetter.set();
	    } catch (Exception ex) {
	    	try {
    			UIManager.setLookAndFeel(new MaterialLookAndFeel(new JMarsDarkTheme()));
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
