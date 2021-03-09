package com.wabbajack_scrolls.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

//import com.wabbajack_scrolls.gui.panels.CleanDownloadsPanel;
import com.wabbajack_scrolls.gui.panels.CreateChangelogPanel;
//import com.wabbajack_scrolls.gui.panels.ForceHealPanel;
//import com.wabbajack_scrolls.gui.panels.ManageAuthoredFilesPanel;
import com.wabbajack_scrolls.gui.panels.ManageDownloadsPanel;
//import com.wabbajack_scrolls.gui.panels.PurgeArchivePanel;
import com.wabbajack_scrolls.gui.panels.SettingsPanel;
import java.awt.Frame;
import org.eclipse.swt.awt.SWT_AWT;


public class MainGuiRework {
	
	protected Shell mainFrame;
	
	private final ManageDownloadsPanel manageDownloadsPanel = new ManageDownloadsPanel();
//	private final CleanDownloadsPanel cleanDownloadsPanel = new CleanDownloadsPanel();
	private final CreateChangelogPanel createChangelogPanel = new CreateChangelogPanel();
//	private HashGameFilesPanel hashGameFilesPanel = new HashGameFilesPanel();
	
//	private final ForceHealPanel forceHealPanel = new ForceHealPanel();
//	private final ManageAuthoredFilesPanel manageAuthoredFilesPanel = new ManageAuthoredFilesPanel();
//	private final PurgeArchivePanel purgeArchivePanel = new PurgeArchivePanel();
	
	private final SettingsPanel settingsPanel = new SettingsPanel();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainGuiRework window = new MainGuiRework();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents(display);
		while (!mainFrame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents(Display d) {
		mainFrame = new Shell(d);
		mainFrame.setText("GUI Rework");
		
		Menu menu = new Menu(mainFrame, SWT.BAR);
		mainFrame.setMenuBar(menu);
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("User Mode");
		
		Menu userMenu = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(userMenu);
		
		MenuItem mntmNormal = new MenuItem(userMenu, SWT.RADIO);
		mntmNormal.setSelection(true);
		mntmNormal.setText("Normal");
		
		MenuItem mntmAuthor = new MenuItem(userMenu, SWT.RADIO);
		mntmAuthor.setText("Author");
		
		CTabFolder tabFolder = new CTabFolder(mainFrame, SWT.BORDER);
		tabFolder.setBounds(0, 0, 944, 655);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmManageDownloads = new CTabItem(tabFolder, SWT.NONE);
		tbtmManageDownloads.setText("Manage Downloads");
		
		Composite compositeManDownloads = new Composite(tabFolder, SWT.EMBEDDED);
		tbtmManageDownloads.setControl(compositeManDownloads);
		
		Frame manDownloadsFrame = SWT_AWT.new_Frame(compositeManDownloads);
		manDownloadsFrame.setLayout(null);
		manageDownloadsPanel.setBounds(0, 0, 940, 650);
		
		manDownloadsFrame.add(manageDownloadsPanel);

		
		CTabItem tbtmGenerateChangelog = new CTabItem(tabFolder, SWT.NONE);
		tbtmGenerateChangelog.setText("Generate Changelog");
		
		Composite compositeChangelog = new Composite(tabFolder, SWT.EMBEDDED);
		tbtmGenerateChangelog.setControl(compositeChangelog);
		
		Frame changelogFrame = SWT_AWT.new_Frame(compositeChangelog);
		changelogFrame.setLayout(null);
		createChangelogPanel.setBounds(0, 0, 940, 650);

		changelogFrame.add(createChangelogPanel);

		
		CTabItem tbtmSettings = new CTabItem(tabFolder, SWT.NONE);
		tbtmSettings.setText("Settings");
		
		Composite compositeSettings = new Composite(tabFolder, SWT.EMBEDDED);
		tbtmSettings.setControl(compositeSettings);
		
		Frame settingsFrame = SWT_AWT.new_Frame(compositeSettings);
		settingsFrame.setLayout(null);
		settingsPanel.setBounds(0, 0, 940, 650);
		
		settingsFrame.add(settingsPanel);
		
		mainFrame.pack();
		mainFrame.setActive();
	}
	
	
}
