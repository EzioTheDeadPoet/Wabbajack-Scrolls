package en.wabbajack_scroll.gui.panels;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CreateChangelogPanel extends JPanel {
	
    private JLabel header;
    private JLabel jLblPrevML;
    private JTextField pathToOriginalModlist;
    private JButton selecPrevious;
    private JLabel jLblCurML;
    private JTextField pathToOutput;
    private JButton selectCurrent;
    private JLabel jLblOutputFile;
    private JTextField outputFile;
    private JButton selectOutput;
    private JComboBox<?> changesDownloads;
    private JLabel jLblsettings;
    private JLabel jLblDownloads;
    private JComboBox<?> changesMods;
    private JLabel jLblMods;
    private JComboBox<?> changesLoadorder;
    private JLabel jLblLO;
    private JButton executeButton;

	
	public CreateChangelogPanel() {
		
        //construct preComponents
        String[] changesDownloadsItems = {"Do", "Do not"};
        String[] changesModsItems = {"Do not", "Do"};
        String[] changesLoadorderItems = {"Do not", "Do"};

        //construct components
        header = new JLabel ("Generate a Changelog");
        jLblPrevML = new JLabel ("Original/Previous Modlist : ");
        pathToOriginalModlist = new JTextField (5);
        selecPrevious = new JButton ("Select in Explorer");
        jLblCurML = new JLabel ("Current/Updated Modlist :");
        pathToOutput = new JTextField (5);
        selectCurrent = new JButton ("Select in Expolrer");
        jLblOutputFile = new JLabel ("Output File :");
        outputFile = new JTextField (5);
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
        add (pathToOutput);
        add (selectCurrent);
        add (jLblOutputFile);
        add (outputFile);
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
        header.setBounds (400, 40, 130, 35);
        jLblPrevML.setBounds (75, 110, 150, 25);
        pathToOriginalModlist.setBounds (225, 110, 455, 25);
        selecPrevious.setBounds (680, 110, 135, 25);
        jLblCurML.setBounds (80, 160, 145, 25);
        pathToOutput.setBounds (225, 160, 455, 25);
        selectCurrent.setBounds (680, 160, 135, 25);
        jLblOutputFile.setBounds (155, 210, 70, 25);
        outputFile.setBounds (225, 210, 455, 25);
        selectOutput.setBounds (680, 210, 135, 25);
        changesDownloads.setBounds (225, 330, 65, 25);
        jLblsettings.setBounds (170, 330, 60, 25);
        jLblDownloads.setBounds (290, 330, 430, 25);
        changesMods.setBounds (225, 365, 65, 25);
        jLblMods.setBounds (290, 365, 435, 25);
        changesLoadorder.setBounds (225, 400, 65, 25);
        jLblLO.setBounds (290, 400, 435, 25);
        executeButton.setBounds (760, 540, 120, 60);

        
        /*
         * Code to be put here!
         */
		
        //Background Color
//        setBackground(Design.BACKGROUNDCOLOR);
	}
}
