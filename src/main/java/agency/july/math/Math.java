package agency.july.math;

public class Math {

	public static void main(String[] args) {
		
		int[] C = Combinatorics.getBinomial(4);
		System.out.println(C.length);
		for (int i= 0; i<C.length; i++) {
			System.out.println(C[i]);
		}
		
		Bezier bezier = new Bezier(new float[]{0,0,1,2,2,0,3,0});
		
	}

}
