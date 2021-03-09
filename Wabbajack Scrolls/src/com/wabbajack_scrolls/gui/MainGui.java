package com.wabbajack_scrolls.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import com.wabbajack_scrolls.GUI;
import com.wabbajack_scrolls.gui.panels.*;
import com.wabbajack_scrolls.util.ApiKey;
import com.wabbajack_scrolls.util.Setup;


@SuppressWarnings("serial")
public class MainGui extends JFrame implements ActionListener {

	private static MainGui instance;
	
	//Initializing Menu
	
	private final JMenuBar menubar = new JMenuBar();
	
	private final JMenu userOperations = new JMenu("Basic Operations");
	
	private final JMenuItem manageDownloads = new JMenuItem("Manage Downloads");
	private final JMenuItem cleanDownloads = new JMenuItem("Clean Downloads");
	private final JMenuItem createChangelog = new JMenuItem("Create Changelog");
//	private JMenuItem hashGameFiles = new JMenuItem("Hash Game Files");
	
	private final JMenu authorOperations = new JMenu("Author Operations");
	
	private final JMenuItem forceHeal = new JMenuItem("Force Heal");
	private final JMenuItem manageAuthoredFiles = new JMenuItem("Manage Authored Files");
	private final JMenuItem purgeArchive = new JMenuItem("Purge Archive");
	
	
	private final JMenu settingsMenu = new JMenu("Settings");
	
	//Initializing all used Panels
	
	private final JPanel mainPanel = new JPanel(new CardLayout());
	
		
//	private StartPanel welcome = new StartPanel();
	
	private final ManageDownloadsPanel manageDownloadsPanel = new ManageDownloadsPanel();
	private final CleanDownloadsPanel cleanDownloadsPanel = new CleanDownloadsPanel();
	private final CreateChangelogPanel createChangelogPanel = new CreateChangelogPanel();
//	private HashGameFilesPanel hashGameFilesPanel = new HashGameFilesPanel();
	
	private final ForceHealPanel forceHealPanel = new ForceHealPanel();
	private final ManageAuthoredFilesPanel manageAuthoredFilesPanel = new ManageAuthoredFilesPanel();
	private final PurgeArchivePanel purgeArchivePanel = new PurgeArchivePanel();
	
	private final SettingsPanel settingsPanel = new SettingsPanel();
	
	private MainGui() {
		
		super("Wabbajack Scrolls: Easy Access to The Wabbajack-CLI");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		List<Image> icons  = new ArrayList<>();
		icons.add(new ImageIcon(getClass().getResource("/com/wabbajack_scrolls/resources/wabbajack.png")).getImage());

		this.setIconImages(icons);

		initMainGui();
	}
	
	
	public static MainGui getInstance() {
		
		if (instance == null) {
			instance = new MainGui();
			
		}
		
		return instance;
	}
	
	
	public void dispose() {
		GUI.exit();
		super.dispose();
	}
	
	private void initMainGui() {
		
		//Top Menu User Operations
		
		manageDownloads.setActionCommand("manageDownloads");
		manageDownloads.addActionListener(this);
		userOperations.add(manageDownloads);
		
		cleanDownloads.setActionCommand("cleanDownloads");
		cleanDownloads.addActionListener(this);
		//Disabled for now!
//		userOperations.add(cleanDownloads);
		
		createChangelog.setActionCommand("createChangelog");
		createChangelog.addActionListener(this);
		userOperations.add(createChangelog);
		
//		hashGameFiles.setActionCommand("hashGameFiles");
//		hashGameFiles.addActionListener(this);
//		userOperations.add(hashGameFiles);
		
		//Top Menu Author Operations
		
		forceHeal.setActionCommand("forceHeal");
		forceHeal.addActionListener(this);
		authorOperations.add(forceHeal);
		
		manageAuthoredFiles.setActionCommand("manageAuthoredFiles");
		manageAuthoredFiles.addActionListener(this);
		authorOperations.add(manageAuthoredFiles);
		
		purgeArchive.setActionCommand("purgeArchive");
		purgeArchive.addActionListener(this);
		authorOperations.add(purgeArchive);
		
		//Add menus to menubar
		
		menubar.add(userOperations);
		if (ApiKey.found()) {
			menubar.add(authorOperations);
		}
		menubar.add(settingsMenu);
		
		JMenuItem settings = new JMenuItem("Settings");
		settings.setActionCommand("settings");
		settingsMenu.add(settings);
		
		//Add cards to the mainPanel
		
//		mainPanel.add("start", welcome);
		
		mainPanel.add("manageDownloads", manageDownloadsPanel);
		mainPanel.add("cleanDownloads", cleanDownloadsPanel);
		mainPanel.add("createChangelog", createChangelogPanel);

//		mainPanel.add("hashGameFiles", hashGameFilesPanel);
		
		mainPanel.add("forceHeal", forceHealPanel);
		mainPanel.add("manageAuthoredFiles", manageAuthoredFilesPanel);
		mainPanel.add("purgeArchive", purgeArchivePanel);
		
		mainPanel.add("settings", settingsPanel);		
		
		//Building the Main Window
		setJMenuBar(menubar);
		getContentPane().add("Center",mainPanel);
		
		pack();
		setLocationRelativeTo(null);

    SettingsPanel.init();
		ManageDownloadsPanel.init();
		CreateChangelogPanel.init();

		if (Setup.initializeIni()) {
			CardLayout mainLayout = (CardLayout)(mainPanel.getLayout());
			mainLayout.show(mainPanel, "settings");
		}
		SettingsPanel.init();
		ManageDownloadsPanel.init();
	}
	
	//Switches to the selected card 
	public void actionPerformed(ActionEvent e) {
			CardLayout mainLayout = (CardLayout)(mainPanel.getLayout());
			mainLayout.show(mainPanel, e.getActionCommand());
			if (e.getSource() == manageDownloads) {
				ManageDownloadsPanel.init();
			}
			return;
	}
}
