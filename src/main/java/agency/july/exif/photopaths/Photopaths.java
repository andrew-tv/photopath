package agency.july.exif.photopaths;

import java.io.File;
import java.io.IOException;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.psd.PsdMetadataReader;
import com.drew.imaging.tiff.TiffMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class Photopaths {

	public static void main(String[] args) throws ImageProcessingException, IOException {
		// TODO Auto-generated method stub
		
		new Executor("/Users/andrew/Work/Clients/Systembollaget/Recognizing/650");
		
		PathExtractor extractor = new PathExtractor();
		
		String output = extractor.extract("58_9809010.tif");
		
		System.out.println(output);
		
		Paths paths = new Paths(output);
		
		System.out.println("Path 1 name : " + paths.get(0).getName());
		System.out.println("SubPath isClosed : " + paths.get(0).get(0).isClosed() );
		
		float[] spline0 = paths.get(0).get(0).getSpline(0);
		System.out.println("B1 : " + spline0[0] + " : " + spline0[1] );
		System.out.println("B2 : " + spline0[2] + " : " + spline0[3] );
		System.out.println("B3 : " + spline0[4] + " : " + spline0[5] );
		System.out.println("B4 : " + spline0[6] + " : " + spline0[7] );
		
		float[] spline1 = paths.get(0).get(0).getSpline(1);
		System.out.println("B1 : " + spline1[0] + " : " + spline1[1] );
		System.out.println("B2 : " + spline1[2] + " : " + spline1[3] );
		System.out.println("B3 : " + spline1[4] + " : " + spline1[5] );
		System.out.println("B4 : " + spline1[6] + " : " + spline1[7] );
		
		float[] splineLast = paths.get(0).get(0).getSpline(paths.get(0).get(0).getNodeCount());
		System.out.println("getNodeCount : " + paths.get(0).get(0).getNodeCount() );
		System.out.println("B1 : " + splineLast[0] + " : " + splineLast[1] );
		System.out.println("B2 : " + splineLast[2] + " : " + splineLast[3] );
		System.out.println("B3 : " + splineLast[4] + " : " + splineLast[5] );
		System.out.println("B4 : " + splineLast[6] + " : " + splineLast[7] );

		System.out.println("Done");

/*

        File file = new File("/Users/andrew/Work/Clients/Systembollaget/Recognizing/650/58_9809010.psd");

		Metadata metadata = PsdMetadataReader.readMetadata(file);
		for (Directory directory : metadata.getDirectories() ) {
		    for (Tag tag : directory.getTags()) {
		        System.out.format("[%s] - %s = %s",
		            directory.getName(), tag.getTagName(), tag.getDescription());
		    }
		    if (directory.hasErrors()) {
		        for (String error : directory.getErrors()) {
		            System.err.format("ERROR: %s", error);
		        }
		    }
		}
		
		for (Directory directory : metadata.getDirectories()) {
	        System.out.println(directory.getName());
	        if (directory.getName().equals("Photoshop")) {
			    for (Tag tag : directory.getTags()) {
			    	if (tag.getTagType() == 2000)
			    		System.out.println(tag.getTagName() + " >> " + tag.getTagType() + " >> " + tag.getDescription());
			    }
	        }
		}
*/		
	}

}
