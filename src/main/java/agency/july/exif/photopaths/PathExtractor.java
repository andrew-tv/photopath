package agency.july.exif.photopaths;

public class PathExtractor {

	String extract (String from) {

		String[] command;
		
		command = new String[]{
				"/usr/local/bin/exiftool", 
				"-config", 
				"photoshop_paths.config", 
				"-allpathpix", // allpaths
				"-userparam", 
				"anchoronly", 
				from};

		return Executor.executeCommand(command);
		
	}

}
