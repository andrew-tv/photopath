package agency.july.exif.photopaths;

import java.util.ArrayList;

public class Path extends ArrayList<Subpath> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public Path (String name, String subpathsStr) {
		
		this.name = name;
		
		String[] subpathsArr = subpathsStr.split(",(?=[-\\+],)");
		
		System.out.println("SubpathsArr len = " + subpathsArr.length);
		for (int i=0; i<subpathsArr.length; i++) {
			add(new Subpath(subpathsArr[i]));
		}
			
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
