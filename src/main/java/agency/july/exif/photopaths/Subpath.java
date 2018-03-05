package agency.july.exif.photopaths;

import java.util.Arrays;

public class Subpath {
	
	private double[] data; 
	private boolean closed; 
	
	public Subpath (String subPathStr) {
		String[] dataStr = subPathStr.split(",");
		closed = dataStr[0].equals("-");
		data = new double[dataStr.length-1];
		for (int i = 1; i<dataStr.length; i++) {
			data[i-1] = Double.parseDouble(dataStr[i]);
		}
	}
	
	public int getNodeCount() {
		return data.length / 6;
	}	

	public double[] getNode(int index) {
		return Arrays.copyOfRange(data, index*6, index*6 + 6);
	}	

	public double[] getSpline(int index) {
		if (index < data.length / 6) {
			return Arrays.copyOfRange(data, index*6+2, index*6 + 10);
		} else {
			double[] res = new double[8];
			for (int i=0; i<4; i++) {
				res[i] = data[data.length-4 + i];
				res[4+i] = data[i];
			}
			return res;
		}
	}	

	public double[] getData() {
		return data;
	}

	public void setData(double[] data) {
		this.data = data;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

}
