package en.wabbajack_scroll.util;

public class CMD {
    public static void run(String args)
    {
        String cd = "cd " + (String)Settings.ini.get("Main","WabbajackPath") + " && ";
        try
        {
            System.out.println("cmd /c start cmd.exe /K \""+ cd + args +"\"");
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \""+ cd + args +"\"");
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }
    }
}
