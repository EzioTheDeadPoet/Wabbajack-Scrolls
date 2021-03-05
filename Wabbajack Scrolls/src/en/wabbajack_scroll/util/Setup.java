package en.wabbajack_scroll.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Setup {
	
	/**
	 * Creates an settings.ini file in %localAppData% for this tool to save some setup values, if it doesn't exist.
	 * @return true if settings.ini had to be created and it is the first run and false if a settings setup exists.
	 */
	public static boolean initializeIni(){
	    String PATH = System.getProperty("user.home");
	    String directoryName = PATH.concat("/AppData/Local/Wabbajack_Scrolls");
	    String fileName = "settings.ini";

	    File directory = new File(directoryName);
	    if (! directory.exists()){
	        directory.mkdir();
	    }

	    File file = new File(directoryName + "/" + fileName);

	    if (!file.exists()) {
		    try{
		        FileWriter fw = new FileWriter(file.getAbsoluteFile());
		        BufferedWriter bw = new BufferedWriter(fw);
		        bw.write("");
		        bw.close();
				Settings.Init();
		    	Settings.ini.put("Main", "WabbajackPath", "");
		    	Settings.ini.store();
		    }
		    catch (IOException e){
		        e.printStackTrace();
		        System.exit(-1);
		    }
	    }
		if (file.exists()){
			try{
				Settings.Init();
				File testPath = new File((String)Settings.ini.get("Main", "WabbajackPath", String.class));
				if ((Settings.ini.get("Main", "WabbajackPath", String.class)).equals("") || !testPath.exists()) {
					return true;
				}

			} catch (NullPointerException e){

			}
		}


	    return false;

	}
	
}
