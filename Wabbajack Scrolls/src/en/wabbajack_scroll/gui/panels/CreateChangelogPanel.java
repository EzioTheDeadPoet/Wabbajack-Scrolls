package en.wabbajack_scroll.gui.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import en.wabbajack_scroll.util.CMD;
import en.wabbajack_scroll.util.Settings;

@SuppressWarnings("serial")
public class CreateChangelogPanel extends JPanel implements ActionListener{
	
	//UI related
    private JLabel header;
    private JLabel jLblPrevML;
    private static JTextField pathToOriginalModlist;
    private JButton selecPrevious;
    private JLabel jLblCurML;
    private static JTextField pathToCurrent;
    private JButton selectCurrent;
    private JLabel jLblOutputFile;
    private static JTextField pathToOutput;
    private JButton selectOutput;
    private JComboBox<?> changesDownloads;
    private JLabel jLblsettings;
    private JLabel jLblDownloads;
    private JComboBox<?> changesMods;
    private JLabel jLblMods;
    private JComboBox<?> changesLoadorder;
    private JLabel jLblLO;
    private JButton executeButton;
    
    
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
		
		
		selecPrevious.addActionListener(this);
		selectCurrent.addActionListener(this);
		selectOutput.addActionListener(this);
        executeButton.addActionListener(this);
	}

	public static void init() {
		try {
			prevPath = Settings.ini.get("CreateChangelog", "PreviousModlist", String.class);
			pathToOriginalModlist.setText(prevPath);
			
			currPath = Settings.ini.get("CreateChangelog", "CurrentModlist", String.class);
			pathToCurrent.setText(currPath);
			
			outPath = Settings.ini.get("CreateChangelog", "OutputPath", String.class);
			pathToOutput.setText(outPath);
		} catch (NullPointerException e) {
			
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
        if (e.getSource() == selecPrevious) {
            
        	if (!prevPath.isEmpty()) {
        		fcfile.setCurrentDirectory(new File(prevPath));
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
        	
        	if (!currPath.isEmpty()) {
        		fcfile.setCurrentDirectory(new File(currPath));
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
        	
        	if (!outPath.isEmpty()) {
        		fcfile.setCurrentDirectory(new File(outPath));
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
        
        /*
         * replace is empty with .isBlank() 
         */
		
		if (e.getSource() == executeButton) {
			String debugFront = "echo \"wabbajack-cli ";
			String debugEnd = "\"";
			
			StringBuffer command = new StringBuffer();
			command.append("changelog");
			
			if (!pathToOriginalModlist.getText().isEmpty()) {
				command.append(" --original \""+ pathToOriginalModlist.getText()+"\"");
			}
			if (!pathToCurrent.getText().isEmpty()) {
				command.append(" --update \""+ pathToCurrent.getText()+"\"");
			}
			
			if (!pathToOutput.getText().isEmpty()) {
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
			CMD.run(debugFront + command.toString() + debugEnd);
		}
		
	}
	
	
}
