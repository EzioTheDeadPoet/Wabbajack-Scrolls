package en.wabbajack_scroll.gui.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import en.wabbajack_scroll.util.CMD;
import en.wabbajack_scroll.util.Settings;

@SuppressWarnings("serial")
public class ManageDownloadsPanel extends JPanel implements ActionListener{
	
    private JLabel header;
    private JLabel jLblDownloads;
    private static JTextField pathToDownloads;
    private JButton selectDownloads;
    private JLabel jLblOutput;
    private static JTextField pathToOutput;
    private JButton selectOutput;
    private JLabel jLblModlistFile;
    private static JTextField pathToModlist;
    private JButton selectModlist;
    private JLabel jLblModsFolder;
    private static JTextField pathToMods;
    private JButton selectMods;
    private JLabel jLblModsNote;
    private JComboBox<?> copyOrMove;
    private JLabel jLblsettings;
    private JLabel jLblMoveOrCopy;
    private JComboBox<?> overwriteExstingFiles;
    private JLabel jLblOverwrite;
    private JComboBox<?> copyMeta;
    private JLabel jLblMetafile;
    private JButton executeButton;
    private JFileChooser fcdir;
    private JFileChooser fcfile;
	
	public ManageDownloadsPanel() {
		
        //construct preComponents
        String[] copyOrMoveItems = {"Copy", "Move"};
        String[] overwriteExstingFilesItems = {"Do not", "Do"};
        String[] copyMetaItems = {"Do", "Do not"};

        //construct components
        header = new JLabel ("Move or Copy all used Mods from a Modlist to another directory.");
        jLblDownloads = new JLabel ("Downloads Folder : ");
        pathToDownloads = new JTextField (5);
        selectDownloads = new JButton ("Select in Explorer");
        jLblOutput = new JLabel ("Output Folder :");
        pathToOutput = new JTextField (5);
        selectOutput = new JButton ("Select in Expolrer");
        jLblModlistFile = new JLabel ("Modlist File :");
        pathToModlist = new JTextField (5);
        selectModlist = new JButton ("Select in Exploer");
        jLblModsFolder = new JLabel ("Mods Folder* :");
        pathToMods = new JTextField (5);
        selectMods = new JButton ("Select in Exporer");
        jLblModsNote = new JLabel ("*Mods folder location is only needed if the provided modlist file is an MO2 modlist.txt");
        copyOrMove = new JComboBox<Object> (copyOrMoveItems);
        jLblsettings = new JLabel ("Settings :");
        jLblMoveOrCopy = new JLabel (" the downloads of the modlist to the output folder.");
        overwriteExstingFiles = new JComboBox<Object> (overwriteExstingFilesItems);
        jLblOverwrite = new JLabel (" overwrite existing files in the output location.");
        copyMeta = new JComboBox<Object> (copyMetaItems);
        jLblMetafile = new JLabel (" copy the meta file with the download.");
        executeButton = new JButton ("Launch");

        //set components properties
        jLblDownloads.setToolTipText ("Input folder containing the downloads you want to move.");
        pathToDownloads.setToolTipText ("Input folder containing the downloads you want to move.");
        selectDownloads.setToolTipText ("Input folder containing the downloads you want to move.");
        jLblOutput.setToolTipText ("Output folder the downloads should be transferred to");
        pathToOutput.setToolTipText ("Output folder the downloads should be transferred to");
        selectOutput.setToolTipText ("Output folder the downloads should be transferred to");
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
        add (jLblOutput);
        add (pathToOutput);
        add (selectOutput);
        add (jLblModlistFile);
        add (pathToModlist);
        add (selectModlist);
        add (jLblModsFolder);
        add (pathToMods);
        add (selectMods);
        add (jLblModsNote);
        add (copyOrMove);
        add (jLblsettings);
        add (jLblMoveOrCopy);
        add (overwriteExstingFiles);
        add (jLblOverwrite);
        add (copyMeta);
        add (jLblMetafile);
        add (executeButton);

        //set component bounds (only needed by Absolute Positioning)
        header.setBounds (265, 45, 400, 30);
        jLblDownloads.setBounds (75, 110, 110, 25);
        pathToDownloads.setBounds (185, 110, 495, 25);
        selectDownloads.setBounds (680, 110, 135, 25);
        jLblOutput.setBounds (100, 160, 85, 25);
        pathToOutput.setBounds (185, 160, 495, 25);
        selectOutput.setBounds (680, 160, 135, 25);
        jLblModlistFile.setBounds (110, 210, 75, 25);
        pathToModlist.setBounds (185, 210, 495, 25);
        selectModlist.setBounds (680, 210, 135, 25);
        jLblModsFolder.setBounds (100, 260, 85, 25);
        pathToMods.setBounds (185, 260, 495, 25);
        selectMods.setBounds (680, 260, 135, 25);
        jLblModsNote.setBounds (185, 285, 495, 25);
        copyOrMove.setBounds (185, 330, 65, 25);
        jLblsettings.setBounds (125, 330, 60, 25);
        jLblMoveOrCopy.setBounds (250, 330, 435, 25);
        overwriteExstingFiles.setBounds (185, 365, 65, 25);
        jLblOverwrite.setBounds (250, 365, 435, 25);
        copyMeta.setBounds (185, 400, 65, 25);
        jLblMetafile.setBounds (250, 400, 435, 25);
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
        selectOutput.addActionListener(this);
        selectModlist.addActionListener(this);
        selectMods.addActionListener(this);
        executeButton.addActionListener(this);
        
	}
	
	public static void init() {
	    try {
            pathToDownloads.setText((String)Settings.ini.get("ManageDownloads","DownloadsPath"));
            pathToOutput.setText((String)Settings.ini.get("ManageDownloads","OutputPath"));
            pathToModlist.setText((String)Settings.ini.get("ManageDownloads","ModlistPath"));
            pathToMods.setText((String)Settings.ini.get("ManageDownloads","ModsPath"));
        } catch (NullPointerException e){

        }

		
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
        
        if (e.getSource() == selectOutput) {
            int returnVal = fcdir.showDialog(this,"Select");
 
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File path = fcdir.getSelectedFile();
                pathToOutput.setText(path.getAbsolutePath());
                Settings.ini.put("ManageDownloads", "OutputPath", pathToOutput.getText());
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
            StringBuffer command = new StringBuffer();
            command.append("wabbajack-cli change-download");
            if (!pathToDownloads.getText().isBlank()) {
                command.append(" --input \"" + pathToDownloads.getText() + "\"");
            } else {
                pathToDownloads.setText("missing input");
            }

            if (!pathToOutput.getText().isBlank()) {
                command.append(" --output \"" + pathToOutput.getText() + "\"");
            } else {
                pathToOutput.setText("missing input");
            }

            if (!pathToModlist.getText().isBlank()) {
                command.append(" --modlist \"" + pathToModlist.getText() + "\"");
            } else {
                pathToModlist.setText("missing input");
            }

            if (new File((String)pathToModlist.getText()).getName().equals("modlist.txt") && pathToMods.getText().isBlank()){
                command.append(" --mods \""+ pathToMods.getText() + "\"");
            } else if (new File((String)pathToModlist.getText()).getName().equals("modlist.txt")) {
                pathToMods.setText("missing input");
            }

            if (copyOrMove.getSelectedItem().toString().equals("move")) {
                command.append(" --move");
            }
            if (overwriteExstingFiles.getSelectedItem().toString().equals("Do")) {
                command.append(" --overwrite");
            }

            if (copyMeta.getSelectedItem().toString().equals("Do not")) {
                command.append(" --meta");
            }

            CMD.run(command.toString());
        }
	}
}
