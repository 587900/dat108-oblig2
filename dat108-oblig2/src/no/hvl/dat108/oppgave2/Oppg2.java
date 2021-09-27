package no.hvl.dat108.oppgave2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Oppg2 {

	public static void main(String[] args) {
		
		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt ("Kjetil", "Berg", Kjonn.MANN, "Studentkaffi-operatør", 388),
				new Ansatt ("Kristoffer", "Vågstøl", Kjonn.MANN, "Saueklemmer", 6599),
				new Ansatt ("Lima", "Aliar", Kjonn.KVINNE, "Repsilansvalig", 328922),
				new Ansatt ("Lars Erik", "Birkeland", Kjonn.MANN, "Hengselsmører", 288990),
				new Ansatt ("Bergliot", "Ås", Kjonn.KVINNE, "Direktør for studentkaffi-operatører", 658990)
				);
		
		skrivUtAlle(ansatte);

	}
	
	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> lonnsFunksjon) {
		
		
		
	}
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		ansatte.forEach(System.out::println);
	}

}
