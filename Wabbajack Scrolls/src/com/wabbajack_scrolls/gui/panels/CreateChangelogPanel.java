package com.wabbajack_scrolls.gui.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.wabbajack_scrolls.util.CMD;
import com.wabbajack_scrolls.util.Settings;

@SuppressWarnings("serial")
public class CreateChangelogPanel extends JPanel implements ActionListener{
	
	//UI related
    private final JLabel header;
    private final JLabel jLblPrevML;
    private static JTextField pathToOriginalModlist;
    private final JButton selecPrevious;
    private final JLabel jLblCurML;
    private static JTextField pathToCurrent;
    private final JButton selectCurrent;
    private final JLabel jLblOutputFile;
    private static JTextField pathToOutput;
    private final JButton selectOutput;
    private final JComboBox<?> changesDownloads;
    private final JLabel jLblsettings;
    private final JLabel jLblDownloads;
    private final JComboBox<?> changesMods;
    private final JLabel jLblMods;
    private final JComboBox<?> changesLoadorder;
    private final JLabel jLblLO;
    private final JButton executeButton;
    
    
    //Code related
    public static JFileChooser fcclog;
    public static JFileChooser fcfile;
    private static String prevPath = "";
    private static String currPath = "";
    private static String outPath = "";
 	
	public CreateChangelogPanel(){
		
        //construct preComponents
        String[] changesDownloadsItems = {"Do", "Do not"};
        String[] changesModsItems = {"Do not", "Do"};
        String[] changesLoadorderItems = {"Do not", "Do"};

        //construct components
        header = new JLabel ("Generate a Changelog.");
        jLblPrevML = new JLabel ("Original/Previous Modlist : ");
        pathToOriginalModlist = new JTextField (5);
        selecPrevious = new JButton ("Select in Explorer");
        jLblCurML = new JLabel ("Current/Updated Modlist :");
        pathToCurrent = new JTextField (5);
        selectCurrent = new JButton ("Select in Expolrer");
        jLblOutputFile = new JLabel ("Output File :");
        pathToOutput = new JTextField (5);
        selectOutput = new JButton ("Select in Exploer");
        changesDownloads = new JComboBox<Object> (changesDownloadsItems);
        jLblsettings = new JLabel ("Settings :");
        jLblDownloads = new JLabel (" include download changes.");
        changesMods = new JComboBox<Object> (changesModsItems);
        jLblMods = new JLabel (" include mods changes.");
        changesLoadorder = new JComboBox<Object> (changesLoadorderItems);
        jLblLO = new JLabel (" include load order changes.");
        executeButton = new JButton ("Launch");

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 655));
        setLayout (null);

        //add components
        add (header);
        add (jLblPrevML);
        add (pathToOriginalModlist);
        add (selecPrevious);
        add (jLblCurML);
        add (pathToCurrent);
        add (selectCurrent);
        add (jLblOutputFile);
        add (pathToOutput);
        add (selectOutput);
        add (changesDownloads);
        add (jLblsettings);
        add (jLblDownloads);
        add (changesMods);
        add (jLblMods);
        add (changesLoadorder);
        add (jLblLO);
        add (executeButton);

        //set component bounds (only needed by Absolute Positioning)
        header.setBounds (25, 25, 235, 25);
        jLblPrevML.setBounds (25, 110, 200, 25);
        pathToOriginalModlist.setBounds (225, 110, 455, 25);
        selecPrevious.setBounds (680, 110, 185, 25);
        jLblCurML.setBounds (25, 160, 200, 25);
        pathToCurrent.setBounds (225, 160, 455, 25);
        selectCurrent.setBounds (680, 160, 185, 25);
        jLblOutputFile.setBounds (25, 210, 200, 25);
        pathToOutput.setBounds (225, 210, 455, 25);
        selectOutput.setBounds (680, 210, 185, 25);
        changesDownloads.setBounds (225, 330, 115, 25);
        jLblsettings.setBounds (25, 330, 200, 25);
        jLblDownloads.setBounds (340, 330, 430, 25);
        changesMods.setBounds (225, 365, 115, 25);
        jLblMods.setBounds (340, 365, 435, 25);
        changesLoadorder.setBounds (225, 400, 115, 25);
        jLblLO.setBounds (340, 400, 435, 25);
        executeButton.setBounds (760, 540, 120, 60);

        
        /*
         * Code to be put here!
         */
		
        FileFilter changelogfile = new FileNameExtensionFilter("Changelog File (*.txt,*.md)", "md","txt");
        
        fcclog = new JFileChooser();
        fcclog.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fcclog.setAcceptAllFileFilterUsed(false);
        fcclog.addChoosableFileFilter(changelogfile);
        
        FileFilter wabbajackModlist = new FileNameExtensionFilter("Wabbajack Modlist (*.wabbajack)", "wabbajack");
        
        fcfile = new JFileChooser();
		fcfile.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fcfile.setAcceptAllFileFilterUsed(false);
		fcfile.addChoosableFileFilter(wabbajackModlist);

        try {
            fcclog.setCurrentDirectory(new File(((String)Settings.ini.get("Main","WabbajackPath"))).getParentFile());
        } catch (Exception e) {
        }
        try {
            fcfile.setCurrentDirectory(new File(((String)Settings.ini.get("Main","WabbajackPath"))).getParentFile());
        } catch (Exception e) {
        }
		
		selecPrevious.addActionListener(this);
		selectCurrent.addActionListener(this);
		selectOutput.addActionListener(this);
        executeButton.addActionListener(this);
	}

	public static void init() {
		try {
			prevPath = Settings.ini.get("CreateChangelog", "PreviousModlist");
			pathToOriginalModlist.setText(prevPath);
			
			currPath = Settings.ini.get("CreateChangelog", "CurrentModlist");
			pathToCurrent.setText(currPath);
			
			outPath = Settings.ini.get("CreateChangelog", "OutputPath");
			pathToOutput.setText(outPath);
		} catch (NullPointerException e) {
			
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
        if (e.getSource() == selecPrevious) {

            try {
                if (!prevPath.isBlank()) {
                    fcfile.setCurrentDirectory(new File(prevPath));
                }
            } catch (NullPointerException e1) {

            }

            int returnVal = fcfile.showDialog(this,"Select");
 
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File path = fcfile.getSelectedFile();
                pathToOriginalModlist.setText(path.getAbsolutePath());
                Settings.ini.put("CreateChangelog", "PreviousModlist", pathToOriginalModlist.getText());
                try {
    				Settings.ini.store();
    			} catch (IOException e1) {
    				e1.printStackTrace();
    			}
            }
        }
        
        if (e.getSource() == selectCurrent) {

            try {
                if (!currPath.isBlank()) {
                    fcfile.setCurrentDirectory(new File(currPath));
                }
            } catch (NullPointerException e2) {

            }
            int returnVal = fcfile.showDialog(this,"Select");
 
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File path = fcfile.getSelectedFile();
                pathToCurrent.setText(path.getAbsolutePath());
                Settings.ini.put("CreateChangelog", "CurrentModlist", pathToCurrent.getText());
                try {
    				Settings.ini.store();
    			} catch (IOException e1) {
    				e1.printStackTrace();
    			}
            }
        }	
        
        if (e.getSource() == selectOutput) {

            try {
                if (!outPath.isBlank()) {
                    fcfile.setCurrentDirectory(new File(outPath));
                }
            } catch (NullPointerException e3) {

            }
        	
            int returnVal = fcclog.showDialog(this,"Select");
 
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File path = fcclog.getSelectedFile();
                pathToOutput.setText(path.getAbsolutePath());
                Settings.ini.put("CreateChangelog", "OutputPath", pathToOutput.getText());
                try {
    				Settings.ini.store();
    			} catch (IOException e1) {
    				e1.printStackTrace();
    			}
            }
        }
        

		if (e.getSource() == executeButton) {

			StringBuffer command = new StringBuffer();
			command.append("wabbajack-cli changelog");
			
			if (!pathToOriginalModlist.getText().isBlank()) {
                Settings.ini.put("CreateChangelog", "PreviousModlist", pathToOriginalModlist.getText());
                try {
                    Settings.ini.store();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
				command.append(" --original \""+ pathToOriginalModlist.getText()+"\"");
			}
			if (!pathToCurrent.getText().isBlank()) {
                Settings.ini.put("CreateChangelog", "CurrentModlist", pathToCurrent.getText());
                try {
                    Settings.ini.store();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
				command.append(" --update \""+ pathToCurrent.getText()+"\"");
			}
			
			if (!pathToOutput.getText().isBlank()) {
                Settings.ini.put("CreateChangelog", "OutputPath", pathToOutput.getText());
                try {
                    Settings.ini.store();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
				command.append(" --output \""+ pathToOutput.getText()+"\"");
			}
			
			if (changesDownloads.getSelectedItem().toString().equals("Do not")) {
				command.append(" --changes-downloads false");
			}
			
			if (changesMods.getSelectedItem().toString().equals("Do")) {
				command.append(" --changes-mods true");
			}
			
			if (changesLoadorder.getSelectedItem().toString().equals("Do")) {
				command.append(" --changes-loadorder true");
			}
			CMD.run( command.toString());
		}
		
	}
	
	
}
