package agency.july.math;

public class Bezier {
	
	private int n; // degree of Bezier spline
	private float[] poligonX;
	private float[] poligonY;

	private int[] binomial;
	private int[][] N;
	private float[] polinomX;
	private float[] polinomY;

	public Bezier(float[] poligon) {
		this.n = poligon.length / 2 - 1;
		this.poligonX = new float[poligon.length / 2];
		this.poligonY = new float[poligon.length / 2];
		for (int i=0; i<this.poligonY.length; i++) {
			this.poligonX[i] = poligon[i*2];
			this.poligonY[i] = poligon[i*2+1];
		}
		this.binomial = Combinatorics.getBinomial(n);
		this.N = getNorma();
		
		this.polinomX = Matrix.multiplyByVector(this.N, this.poligonX);
		this.polinomY = Matrix.multiplyByVector(this.N, this.poligonY);
		System.out.println("polinomX = " + this.polinomX[0]);
		System.out.println("polinomX = " + this.polinomX[1]);
		System.out.println("polinomX = " + this.polinomX[2]);
		System.out.println("polinomX = " + this.polinomX[3]);
		System.out.println("polinomY = " + this.polinomY[0]);
		System.out.println("polinomY = " + this.polinomY[1]);
		System.out.println("polinomY = " + this.polinomY[2]);
		System.out.println("polinomY = " + this.polinomY[3]);
	}
	
	private int[][] getNorma() {
		int[][] N = new int[this.n + 1][this.n + 1];
		int sign = 1;
		int sign2;
		for (int i = 0; i < N.length; i++) {
			sign = -sign;
			sign2 = sign;
			for (int j = 0; j<=i; j++) {
				sign2 = -sign2;
				N[i][j] = sign2 * Combinatorics.getC(this.n,j) * Combinatorics.getC(this.n-j, this.n-i);
//				System.out.println("N[" +i+ "][" +j+"] = " + N[i][j]);
			}
			for (int j = i+1; j < N.length; j++) {
				N[i][j] = 0; // Все элементы над главной диагональю равны 0
			}
		}
		return N;
	}

}
