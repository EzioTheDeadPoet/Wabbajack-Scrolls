package en.wabbajack_scroll.util;

public class CMD {
    public static void run(String command) {	
    	try{  
    		String goToLocation = "cd \""+(Settings.ini.get("Main","WabbajackPath", String.class) + "\" && ");
    		Runtime.getRuntime().exec("cmd /c start cmd.exe /K \""+ goToLocation + command +"\""); 
        } 
        catch (Exception e){ 
            System.out.println("HEY Buddy ! U r Doing Something Wrong "); 
            e.printStackTrace(); 
        } 
    } 
}
