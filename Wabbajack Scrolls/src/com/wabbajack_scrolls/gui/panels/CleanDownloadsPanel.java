package com.wabbajack_scrolls.gui.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.wabbajack_scrolls.util.CMD;
import com.wabbajack_scrolls.util.Settings;

@SuppressWarnings("serial")
public class CleanDownloadsPanel extends JPanel implements ActionListener{
	
    private JLabel header;
    private JLabel jLblDownloads;
    private static JTextField pathToDownloads;
    private JButton selectDownloads;
    private JLabel jLblModlistFile;
    private static JTextField pathToModlist;
    private JButton selectModlist;
    private JLabel jLblModsFolder;
    private static JTextField pathToMods;
    private JButton selectMods;
    private JLabel jLblModsNote;
    private JButton executeButton;
    
    //Code related
    public static JFileChooser fcdir;
    public static JFileChooser fcfile;
	
	public CleanDownloadsPanel() {
		
        //construct components
        header = new JLabel ("Clean your Downloads Folder from unused Downloads.");
        jLblDownloads = new JLabel ("Downloads Folder : ");
        pathToDownloads = new JTextField (5);
        selectDownloads = new JButton ("Select in Explorer");
        jLblModlistFile = new JLabel ("Modlist File :");
        pathToModlist = new JTextField (5);
        selectModlist = new JButton ("Select in Exploer");
        jLblModsFolder = new JLabel ("Mods Folder* :");
        pathToMods = new JTextField (5);
        selectMods = new JButton ("Select in Exporer");
        jLblModsNote = new JLabel ("*Mods folder location is only needed if the provided modlist file is an MO2 modlist.txt");
        executeButton = new JButton ("Launch");

        //set components properties
        jLblDownloads.setToolTipText ("Input folder containing the downloads you want to move.");
        pathToDownloads.setToolTipText ("Input folder containing the downloads you want to move.");
        selectDownloads.setToolTipText ("Input folder containing the downloads you want to move.");
        jLblModlistFile.setToolTipText ("The Modlist, can either be a .wabbajack or a modlist.txt file.");
        pathToModlist.setToolTipText ("The Modlist, can either be a .wabbajack or a modlist.txt file.");
        selectModlist.setToolTipText ("The Modlist, can either be a .wabbajack or a modlist.txt file.");
        jLblModsFolder.setToolTipText ("Mods folder location if the provided modlist file is an MO2 modlist.txt");
        pathToMods.setToolTipText ("Mods folder location if the provided modlist file is an MO2 modlist.txt");
        selectMods.setToolTipText ("Mods folder location if the provided modlist file is an MO2 modlist.txt");

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 655));
        setLayout (null);

        //add components
        add (header);
        add (jLblDownloads);
        add (pathToDownloads);
        add (selectDownloads);
        add (jLblModlistFile);
        add (pathToModlist);
        add (selectModlist);
        add (jLblModsFolder);
        add (pathToMods);
        add (selectMods);
        add (jLblModsNote);
        add (executeButton);

        //set component bounds (only needed by Absolute Positioning)
        header.setBounds (25, 25, 660, 25);
        jLblDownloads.setBounds (25, 110, 200, 25);
        pathToDownloads.setBounds (225, 110, 460, 25);
        selectDownloads.setBounds (685, 110, 180, 25);
        jLblModlistFile.setBounds (25, 160, 200, 25);
        pathToModlist.setBounds (225, 160, 460, 25);
        selectModlist.setBounds (685, 160, 180, 25);
        jLblModsFolder.setBounds (25, 210, 200, 25);
        pathToMods.setBounds (225, 210, 460, 25);
        selectMods.setBounds (685, 210, 180, 25);
        jLblModsNote.setBounds (225, 235, 640, 25);
        executeButton.setBounds (760, 540, 120, 60);
        
        
        /*
         * Code to be put here!
         */
        
        fcdir = new JFileChooser();
        fcdir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fcdir.setAcceptAllFileFilterUsed(false);
        
        fcfile = new JFileChooser();
		fcfile.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fcfile.setAcceptAllFileFilterUsed(false);
		
		FileFilter wabbajackModlist = new FileNameExtensionFilter("Wabbajack Modlist", "wabbajack");
		FileFilter MO2Modlist = new FileFilter() {
			
			@Override
			public String getDescription() {
				return "MO2 Modlist";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.getName().equals("modlist.txt")||f.isDirectory()) {
					return true;
				}
				return false;
			}
		};
		
		fcfile.addChoosableFileFilter(wabbajackModlist);
		fcfile.addChoosableFileFilter(MO2Modlist);
		
        
        selectDownloads.addActionListener(this);
        selectModlist.addActionListener(this);
        selectMods.addActionListener(this);
        executeButton.addActionListener(this);
        
	}
	
	public static void init() {
		pathToDownloads.setText((String) Settings.ini.get("ManageDownloads","DownloadsPath"));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
        //Handle open button action.
        if (e.getSource() == selectDownloads) {
            int returnVal = fcdir.showDialog(this,"Select");
 
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File path = fcdir.getSelectedFile();
                pathToDownloads.setText(path.getAbsolutePath());
                Settings.ini.put("ManageDownloads", "DownloadsPath", pathToDownloads.getText());
                try {
    				Settings.ini.store();

    			} catch (IOException e1) {
    				e1.printStackTrace();
    			}
            }
        }
           
        if (e.getSource() == selectModlist) {
            int returnVal = fcfile.showDialog(this,"Select");
 
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File path = fcfile.getSelectedFile();
                pathToModlist.setText(path.getAbsolutePath());
                Settings.ini.put("ManageDownloads", "ModlistPath", pathToModlist.getText());
                try {
    				Settings.ini.store();

    			} catch (IOException e1) {
    				e1.printStackTrace();
    			}
            }
        }
		
    
        if (e.getSource() == selectMods) {
            int returnVal = fcdir.showDialog(this,"Select");
 
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File path = fcdir.getSelectedFile();
                pathToMods.setText(path.getAbsolutePath());
                Settings.ini.put("ManageDownloads", "ModsPath", pathToMods.getText());
                try {
    				Settings.ini.store();

    			} catch (IOException e1) {
    				e1.printStackTrace();
    			}
            }
        }
		
        if (e.getSource() == executeButton) {
			String debugFront = "echo \"wabbajack-cli ";
			String debugEnd = "\"";
			
			StringBuffer command = new StringBuffer();
			command.append("change-donwloads");
			
			if (!pathToDownloads.getText().isEmpty()) {
				command.append(" --input \""+ pathToDownloads.getText()+"\"");
			}

			Path tempDir = null;
			try {
				tempDir = Files.createTempDirectory("Wabbajack-Scrolls-CleanDownloads");
			} catch (IOException e1) {
	
				e1.printStackTrace();
			}
			
			command.append(" --output \""+ tempDir.toString() +"\"");
			

			
			CMD.run("echo \"This is not finished yet!\"");
		}
	}
}
