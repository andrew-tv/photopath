package agency.july.exif.photopaths;

import java.util.ArrayList;

public class Paths extends ArrayList<Path> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Paths (String pathsStr) {
		
		String[] pathsArr = pathsStr.split(" +: +|\\n|\\r");
		
		for (int i=0; i<pathsArr.length; i+=2) {
			add(new Path( pathsArr[i], pathsArr[i+1] ) );
		}			
	}
}
