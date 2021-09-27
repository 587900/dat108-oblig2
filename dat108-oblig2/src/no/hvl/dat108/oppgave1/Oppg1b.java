package no.hvl.dat108.oppgave1;

@FunctionalInterface
interface Beregning {
	int beregn(int a, int b);
}

public class Oppg1b {

	public static void main(String[] args) {
		
		Beregning summerFunksjon = (a,b) -> (a + b);
		Beregning storstAv = (a,b) -> (a > b) ? a:b;
		Beregning absoluttVerdi = (a,b) -> Math.abs(a - b);
		
		System.out.println(beregn(12, 13, summerFunksjon));
		System.out.println(beregn(-5, 3, storstAv));
		System.out.println(beregn(54, 45, absoluttVerdi));

	}
	
	public static int beregn(int a, int b, Beregning beregning) {
		
		return beregning.beregn(a, b);
	}

}

