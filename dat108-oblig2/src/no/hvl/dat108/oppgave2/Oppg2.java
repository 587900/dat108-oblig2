package no.hvl.dat108.oppgave2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import no.hvl.dat108.common.Ansatt;
import no.hvl.dat108.common.Kjonn;
import no.hvl.dat108.common.Util;

public class Oppg2 {

	public static void main(String[] args) {
		
		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt ("Kjetil", "Berg", Kjonn.MANN, "Studentkaffi-operatør", 388),
				new Ansatt ("Kristoffer", "Vågstøl", Kjonn.MANN, "Saueklemmer", 6599),
				new Ansatt ("Lima", "Aliar", Kjonn.KVINNE, "Repsilansvalig", 328922),
				new Ansatt ("Lars Erik", "Birkeland", Kjonn.MANN, "Hengselsmører", 288990),
				new Ansatt ("Bergliot", "Ås", Kjonn.KVINNE, "Direktør for studentkaffi-operatører", 658990)
				);
		
		Function<Ansatt, Integer> fastKronetillegg = a -> (a.getAarslonn() + 8750);
		Function<Ansatt, Integer> fastProsenttillegg = a -> (int)(a.getAarslonn() * 1.02);
		Function<Ansatt, Integer> fastKronetilleggLav = a -> a.getAarslonn() + (a.getAarslonn() < 345000 ? 8750 : 0);
		Function<Ansatt, Integer> fastProsenttilleggMann = a -> (int)(a.getAarslonn() * (a.getKjonn() == Kjonn.MANN ? 1.03 : 1));
		Function<Ansatt, Integer> fastProsenttrekk = a -> (int)(a.getAarslonn() * 0.8);
		
		Util.skrivUtAlle(ansatte);
		
		lonnsoppgjor(ansatte, fastKronetillegg);
		Util.skrivUtAlle(ansatte);
		
		lonnsoppgjor(ansatte, fastProsenttillegg);
		Util.skrivUtAlle(ansatte);
		
		lonnsoppgjor(ansatte, fastKronetilleggLav);
		Util.skrivUtAlle(ansatte);
		
		lonnsoppgjor(ansatte, fastProsenttilleggMann);
		Util.skrivUtAlle(ansatte);
		
		lonnsoppgjor(ansatte, fastProsenttrekk);
		Util.skrivUtAlle(ansatte);

	}
	
	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> lonnsFunksjon) {
		
		ansatte.forEach(ansatt -> ansatt.setAarslonn(lonnsFunksjon.apply(ansatt)));
		
	}

}
