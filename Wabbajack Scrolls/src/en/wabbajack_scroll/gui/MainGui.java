package en.wabbajack_scroll.gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import en.wabbajack_scroll.*;
import en.wabbajack_scroll.gui.panels.*;
import en.wabbajack_scroll.util.*;


@SuppressWarnings("serial")
public class MainGui extends JFrame implements ActionListener {

	private static MainGui instance;
	
	//Initializing Menu
	
	private JMenuBar menubar = new JMenuBar();
	
	private JMenu userOperations = new JMenu("Basic Operations");
	
	private JMenuItem createChangelog = new JMenuItem("Create Changelog");
	private JMenuItem manageDownloads = new JMenuItem("Manage Downloads");
//	private JMenuItem hashGameFiles = new JMenuItem("Hash Game Files");
	
	private JMenu authorOperations = new JMenu("Author Operations");
	
	private JMenuItem forceHeal = new JMenuItem("Force Heal");
	private JMenuItem manageAuthoredFiles = new JMenuItem("Manage Authored Files");
	private JMenuItem purgeArchive = new JMenuItem("Purge Archive");
	
	
	private JMenu settingsMenu = new JMenu("Settings");
	
	private JMenuItem settings = new JMenuItem("Settings");
	
	//Initializing all used Panels
	
	private JPanel mainPanel = new JPanel(new CardLayout());
	
		
//	private StartPanel welcome = new StartPanel();
	
	private CreateChangelogPanel createChangelogPanel = new CreateChangelogPanel();
//	private HashGameFilesPanel hashGameFilesPanel = new HashGameFilesPanel();
	private ManageDownloadsPanel manageDownloadsPanel = new ManageDownloadsPanel();
	
	private ForceHealPanel forceHealPanel = new ForceHealPanel();
	private ManageAuthoredFilesPanel manageAuthoredFilesPanel = new ManageAuthoredFilesPanel();
	private PurgeArchivePanel purgeArchivePanel = new PurgeArchivePanel();
	
	private SettingsPanel settingsPanel = new SettingsPanel();
	
	private MainGui() {
		
		super("Wabbajack Scroll");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
		
		//Top Menu Settigns
		
		settings.setActionCommand("settings");
		settings.addActionListener(this);
		settingsMenu.add(settings);
		
		//Add menus to menubar
		
		menubar.add(userOperations);
		if (ApiKey.found()) {
			menubar.add(authorOperations);
		}
		menubar.add(settingsMenu);
		
		//Add cards to the mainPanel
		
//		mainPanel.add("start", welcome);
		
		mainPanel.add("manageDownloads", manageDownloadsPanel);
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

		
		if (Setup.initializeIni()) {
			CardLayout mainLayout = (CardLayout)(mainPanel.getLayout());
			mainLayout.show(mainPanel, "settings");
		}
		
	}
	
	//Switches to the selected card 
	public void actionPerformed(ActionEvent e) {
			CardLayout mainLayout = (CardLayout)(mainPanel.getLayout());
			mainLayout.show(mainPanel, e.getActionCommand());
			if (e.getSource() == settings) {
				SettingsPanel.init();
			}
			if (e.getSource() == manageDownloads) {
				ManageDownloadsPanel.init();
			}
			return;
	}
	

}
