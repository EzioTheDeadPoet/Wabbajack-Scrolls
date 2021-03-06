package com.wabbajack_scrolls.util;

import java.io.File;
import java.io.IOException;

import org.ini4j.Wini;

public class Settings {
    private static final String PATH = System.getProperty("user.home");
    private static final String directoryName = PATH.concat("/AppData/Local/Wabbajack_Scrolls");
    private static final String fileName = "settings.ini";
    public static File iniFile = new File(directoryName + "/" + fileName);
    public static Wini ini;
    public static void Init() {
        try {
        	ini = new Wini(Settings.iniFile);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
