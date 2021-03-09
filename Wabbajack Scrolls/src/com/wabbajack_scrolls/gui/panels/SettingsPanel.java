package com.wabbajack_scrolls.gui.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.wabbajack_scrolls.util.Settings;
import com.wabbajack_scrolls.GUI;
import com.wabbajack_scrolls.util.ThemeSetter;

@SuppressWarnings("serial")
public class SettingsPanel extends JPanel implements ActionListener,ItemListener{
	
    private final JLabel header;
    private final JLabel jLblCliFolder;
    private static JLabel jLblSettingsSaved;
    private static JTextField pathToWabbajack;
    private final JButton selectWabbajack;
    private final JButton saveSettings;
    private final JLabel jLblTheme;
    public static JComboBox<?> jCBTheme;
    
    //Code related
	public static JFileChooser fc;
//    private String PATH = System.getProperty("user.home");
//    private String directoryName = PATH.concat("/AppData/Local/Wabbajack_Scrolls");
//    private String fileName = "settings.ini";
//    private File iniFile = new File(directoryName + "/" + fileName);
	
    
	public SettingsPanel() {
        //construct preComponents
        String[] jCBThemeItems = {"JMarsDarkTheme", "MaterialLiteTheme", "MaterialOceanicTheme", "System"};

        //construct components
        header = new JLabel ("Tool Settings");
        jLblCliFolder = new JLabel ("Wabbajack-CLI Folder : ");
        pathToWabbajack = new JTextField (5);
        selectWabbajack = new JButton ("Select in Explorer");
        saveSettings = new JButton ("Save Settings");
        jLblSettingsSaved = new JLabel ("Path Saved!");
        jLblTheme = new JLabel ("Change Theme : ");
        jCBTheme = new JComboBox<Object> (jCBThemeItems);

        //set components properties
        jLblCliFolder.setToolTipText ("The folder named after the Wabbajack version number.");
        pathToWabbajack.setToolTipText ("The folder named after the Wabbajack version number.");
        selectWabbajack.setToolTipText ("The folder named after the Wabbajack version number.");
        jCBTheme.setToolTipText("If you get visual glitches just restart.");

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 655));
        setLayout (null);

        //add components
        add (header);
        add (jLblCliFolder);
        add (pathToWabbajack);
        add (selectWabbajack);
        add (saveSettings);
        add (jLblSettingsSaved);
        add (jLblTheme);
        add (jCBTheme);

        //set component bounds (only needed by Absolute Positioning)
        header.setBounds (25, 25, 230, 25);
        jLblCliFolder.setBounds (25, 110, 200, 25);
        pathToWabbajack.setBounds (225, 110, 455, 25);
        selectWabbajack.setBounds (680, 110, 140, 25);
        saveSettings.setBounds (760, 540, 120, 60);
        jLblSettingsSaved.setBounds (225, 135, 645, 25);
        jLblTheme.setBounds (25, 160, 200, 25);
        jCBTheme.setBounds (225, 160, 455, 25);
                 
        /*
         * Code to be put here!
         */
		
        
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setAcceptAllFileFilterUsed(false);
        try {
            fc.setCurrentDirectory(new File(((String)Settings.ini.get("Main","WabbajackPath"))).getParentFile());
        } catch (Exception e) {
        }

        
        selectWabbajack.addActionListener(this);
        saveSettings.addActionListener(this);
        jCBTheme.addItemListener(this);

	}
	
	public static void init() {
	    try{
            pathToWabbajack.setText(Settings.ini.get("Main","WabbajackPath"));
        } catch (NullPointerException e) {
	        pathToWabbajack.setText("");
        }
		jLblSettingsSaved.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        //Handle open button action.
        if (e.getSource() == selectWabbajack) {
            int returnVal = fc.showDialog(this,"Select");
 
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File path = fc.getSelectedFile();
                pathToWabbajack.setText(path.getAbsolutePath());
                Settings.ini.put("Main", "WabbajackPath", pathToWabbajack.getText());
                try {
    				Settings.ini.store();
    				jLblSettingsSaved.setText("Path " + pathToWabbajack.getText() + " Saved!");
    			} catch (IOException e1) {
    				e1.printStackTrace();
    			}
            }
        }
		
        if (e.getSource() == saveSettings) {
            Settings.ini.put("Main", "WabbajackPath", pathToWabbajack.getText());
            try {
				Settings.ini.store();
				jLblSettingsSaved.setText("Path " + pathToWabbajack.getText() + " Saved!");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        }
         
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	    if (e.getStateChange() == ItemEvent.SELECTED) {
	    	Settings.ini.put("Main", "Theme", jCBTheme.getSelectedItem());
		    try {
		    	Settings.ini.store();
                ThemeSetter.set();
	        	GUI.restart();
		    } catch (Exception ex) {
		    	try {
	    			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	            	GUI.restart();
				} catch (Exception lol) {
					lol.printStackTrace();
				}
			}
	    }
		
	}
}
