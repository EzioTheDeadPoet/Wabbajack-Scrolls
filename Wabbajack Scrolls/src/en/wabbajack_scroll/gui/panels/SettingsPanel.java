package en.wabbajack_scroll.gui.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import en.wabbajack_scroll.util.Settings;

@SuppressWarnings("serial")
public class SettingsPanel extends JPanel implements ActionListener{
	
    private JLabel header;
    private JLabel jLblCliFolder;
    private static JLabel jLblSettingsSaved;
    private static JTextField pathToWabbajack;
    private JButton selectWabbajack;
    private JButton saveSettings;
	private JFileChooser fc;
//    private String PATH = System.getProperty("user.home");
//    private String directoryName = PATH.concat("/AppData/Local/Wabbajack_Scrolls");
//    private String fileName = "settings.ini";
//    private File iniFile = new File(directoryName + "/" + fileName);
	
    
	public SettingsPanel() {
	
        //construct components
        header = new JLabel ("Programm Settings");
        jLblCliFolder = new JLabel ("Wabbajack-CLI Folder : ");
        pathToWabbajack = new JTextField (5);
        selectWabbajack = new JButton ("Select in Explorer");
        saveSettings = new JButton ("Save Settings");
        jLblSettingsSaved = new JLabel ("");

        //set components properties
        jLblCliFolder.setToolTipText ("The folder named after the Wabbajack version number.");
        pathToWabbajack.setToolTipText ("The folder named after the Wabbajack version number.");
        selectWabbajack.setToolTipText ("The folder named after the Wabbajack version number.");

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

        //set component bounds (only needed by Absolute Positioning)
        header.setBounds (400, 40, 130, 35);
        jLblCliFolder.setBounds (90, 110, 135, 25);
        pathToWabbajack.setBounds (225, 110, 455, 25);
        selectWabbajack.setBounds (680, 110, 135, 25);
        saveSettings.setBounds (760, 540, 120, 60);
        jLblSettingsSaved.setBounds (655, 560, 95, 25);

        
        /*
         * Code to be put here!
         */
		
        
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setAcceptAllFileFilterUsed(false);
        
        selectWabbajack.addActionListener(this);
        saveSettings.addActionListener(this);
        

	}
	
	public static void init() {
	    try{
            pathToWabbajack.setText((String)Settings.ini.get("Main","WabbajackPath"));
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
    				jLblSettingsSaved.setText("Settigns Saved!");
    			} catch (IOException e1) {
    				e1.printStackTrace();
    			}
            }
        }
		
        if (e.getSource() == saveSettings) {
            Settings.ini.put("Main", "WabbajackPath", pathToWabbajack.getText());
            try {
				Settings.ini.store();
				jLblSettingsSaved.setText("Settigns Saved!");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        }
	}
}
