package stats;

public class Analizador {
	public static void main(String arg[]) {
		int[] n = {1,2,4,8,10,20,40,80,100,200,400,800,1000, 2000, 4000, 8000, 10000, 20000, 40000, 80000,
				100000, 200000, 400000, 800000, 1000000, 2000000, 4000000, 16000000};
		int i = 0, maxLength = 16;
		Temporizador t = new Temporizador();
		long t1;
		long t2;
		double ratioMin = Double.MAX_VALUE, ratioMax = Double.MIN_VALUE;
		do{
			t1 = 0;
			for (int j = 0; j < 5; j++) {
				t.iniciar();
				Algoritmo.f(n[i]);
				t.parar();
				t1 += t.tiempoPasado();
			}
			t1 = t1/5;
			i++;

			System.out.println("Doing shtuff!!");
			t.reiniciar();
			t2 = 0;
			for (int j = 0; j < 5; j++) {
				t.iniciar();
				Algoritmo.f(n[i]);
				t.parar();
				t2 += t.tiempoPasado();
			}
			t2 = t2/5;
			i++;

			double ratio = (double)t2/t1;
			if(ratio < ratioMin) ratioMin = ratio;
			if(ratio > ratioMax) ratioMax  = ratio;
			System.out.println("Ratio: " + ratio + "\n");
		}while (i < maxLength);
		System.out.println("RatioMin: " + ratioMin + ", RatioMax: " + ratioMax);
	}
}
