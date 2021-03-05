package com.wabbajack_scrolls.util;

import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.JMarsDarkTheme;
import mdlaf.themes.MaterialLiteTheme;
import mdlaf.themes.MaterialOceanicTheme;

import javax.swing.*;

public class ThemeSetter {
    public static void set() throws UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        if (Settings.ini.get("Main","Theme", String.class).equals("MaterialOceanicTheme")) {
            UIManager.setLookAndFeel(new MaterialLookAndFeel(new MaterialOceanicTheme()));
        }
        if (Settings.ini.get("Main","Theme", String.class).equals("MaterialLiteTheme")) {
            UIManager.setLookAndFeel(new MaterialLookAndFeel(new MaterialLiteTheme()));
        }
        if (Settings.ini.get("Main","Theme", String.class).equals("JMarsDarkTheme")) {
            UIManager.setLookAndFeel(new MaterialLookAndFeel(new JMarsDarkTheme()));
        }
        if (Settings.ini.get("Main","Theme", String.class).equals("System")) {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
    }
}
