package agency.july.math;

public class Polinomial {
	
	// Вычисляет значение полинома в точке t по схеме Горнера
	public static double gorner (double t, double[] A) { // a0 + a1*t + a2*t**2 + a3*t**3 ...
		int n = A.length-1;
		double b = A[n];
		for(int i = n-1; i >= 0; i--) {
			b = A[i]+b*t;
		}
		return b; // Создаем новый массив, а не новую ссылку на него, так как он портится рекурсивной функцией g() 
	}

	// Решение линейного уравнения вида a0 + a1*x = 0, где a1 != 0
	public static double[] linearRoots (double[] A) {
		if (java.lang.Math.abs(A[1]) < 1e-12) return null; // Это не уравнение (равен нулю коэффициент при переменной)
		double a = A[1]; // Kоэффициент при первой степени
		double b = A[0]; // Свободный член. То есть получили вид уравнения: ax + b = 0
		return new double[] {-1d,-b/a};
	}

	// Решение квадратного уравнения вида a0 + a1*x + a2*x**2 = 0, где a2 != 0
	public static double[] quadraticRoots (double[] A) {
		if (java.lang.Math.abs(A[2]) < 1e-12) return Polinomial.linearRoots(A); // Это не квадратное уравнение (равен нулю коэффициент при квадрате). Переводим стрелки на линейное уравнение
		double a = A[2]; // Kоэффициент при квадрате
		double b = A[1]; // Kоэффициент при первой степени
		double c = A[0]; // Свободный член. То есть получили вид уравнения: ax**2 + bx + c = 0
		double d = b*b - 4*a*c;
		System.out.println("D = " + d);
		a = a*2;
		double[] x = new double[3]; // Возвращаемый результат
		x[0] = -1f;
		if ( d > 1e-12 ) { // Дискриминант больше нуля - добавляем два корня
			d = java.lang.Math.sqrt(d);
			x[1] = (-b+d)/a;
			x[2] = (-b-d)/a;
		} else if ( d > -1e-12 ) { // Дискриминант близок к нулю - добавляем один корень
			x[1] = -b/a;
			x[2] = x[0];
		} else x[0] = 1f; // В остальных случаях - вещественных корней нет
		return x;
	}

	// Решение кубического уравнения вида a0 + a1*x + a2*x**2 + a3*x**3 = 0, где a3 != 0
	public static double[] cubicRoots (double[] A) {
		if (java.lang.Math.abs(A[3]) < 1e-12) return Polinomial.quadraticRoots(A); // Это не кубическое уравнение (равен нулю коэффициент при кубе). Переводим стрелки на квадратное уравнение
		double a = A[2]/A[3]; // Kоэффициент при квадрате
		double b = A[1]/A[3]; // Kоэффициент при первой степени
		double c = A[0]/A[3]; // Свободный член. То есть получили вид уравнения: x**3 + ax**2 + bx + c = 0
		double pi2 = 2*java.lang.Math.PI;
		double q = (a*a-3.*b)/9.;
		double r = (a*(2.*a*a-9.*b)+27.*c)/54.;
		double r2 = r*r;
		double q3 = q*q*q;
		double[] x = new double[4]; // Возвращаемый результат
	  
		x[0] = r2 < q3 ? -1d : 1d; 
	  if(x[0] < 0) { // Все корни действительные
		double t = java.lang.Math.acos(r/java.lang.Math.sqrt(q3));
		a /= 3.;
		q = -2.* java.lang.Math.sqrt(q);
		x[1]=q*java.lang.Math.cos(t/3.)-a;
		x[2]=q*java.lang.Math.cos((t+pi2)/3.) - a;
		x[3]=q*java.lang.Math.cos((t-pi2)/3.) - a;
	  } else { // Не все корни действительные
		  int sign;
		if(r <= 0.) {
			r = -r;
			sign = 1;
		} else {
			sign = -1;
		}
		double aa = sign * java.lang.Math.pow(r + java.lang.Math.sqrt(r2-q3), 1./3.);
		double bb = (java.lang.Math.abs(aa) > 1e-12) ? q/aa : 0.;
		a /= 3.;
		q = aa+bb;
		r = aa-bb; 
		x[1] = q-a; // Действительный корень
		x[2] = (-0.5)*q-a; // Действительная часть комплексно-сопряженного корня
		x[3] = (java.lang.Math.sqrt(3.)*0.5)*java.lang.Math.abs(r); // Положительная мнимая часть комплексно-сопряженного корня
	  }
		return x;
	}

}
