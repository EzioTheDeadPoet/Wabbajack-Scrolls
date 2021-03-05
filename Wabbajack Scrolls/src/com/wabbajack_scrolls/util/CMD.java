
package com.wabbajack_scrolls.util;

public class CMD {
    public static void run(String command)
    {
        String goToCliLocation = "cd " + (String)Settings.ini.get("Main","WabbajackPath") + " && ";
        try
        {
            System.out.println("cmd /c start cmd.exe /K \""+ goToCliLocation + command +"\"");
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \""+ goToCliLocation + command +"\"");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
