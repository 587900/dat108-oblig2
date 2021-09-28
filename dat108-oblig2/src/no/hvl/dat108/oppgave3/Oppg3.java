package no.hvl.dat108.oppgave3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import no.hvl.dat108.common.Ansatt;
import no.hvl.dat108.common.Kjonn;
import no.hvl.dat108.common.Util;

public class Oppg3 {

	public static void main(String[] args) {
		
		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt ("Kjetil", "Berg", Kjonn.MANN, "Studentkaffi-operatør", 388),
				new Ansatt ("Kristoffer", "Vågstøl", Kjonn.MANN, "Saueklemmer", 6599),
				new Ansatt ("Lima", "Aliar", Kjonn.KVINNE, "Repsilsjef", 328922),
				new Ansatt ("Lars Erik", "Birkeland", Kjonn.MANN, "Hengselsmører", 288990),
				new Ansatt ("Bergliot", "Ås", Kjonn.KVINNE, "Sjef for studentkaffi-operatører", 658990)
				);
		
		// Oppgave 3a - Liste som kun inneholder etternavnene til de ansatte

		List<String> etternavnene = ansatte.stream()
				.map(a -> a.getEtternavn())
				.collect(Collectors.toList());
		System.out.println("Oppg 3a: Liste over etternavn på ansatte:\n" + etternavnene + "\n");
		
		// Oppgave 3b - Antall kvinner blant de ansatte
		
		long antallKvinner = ansatte.stream()
				.filter(a -> a.getKjonn() == Kjonn.KVINNE)
				.count();
		System.out.println("Oppg 3b: Kvinnelige ansatte:\n" + antallKvinner + "\n");
		
		// Oppgave 3c - Gjennomsnittslønnen til kvinnene
		
		double gjennomsnittKvinner = ansatte.stream()
				.filter(a -> a.getKjonn() == Kjonn.KVINNE)
				.mapToInt(Ansatt::getAarslonn)
				.average()
				.orElse(0);
		System.out.println("Oppg 3c: Gjennomsnittslønn for kvinner:\n" + gjennomsnittKvinner + "\n");
		
		// Oppgave 3d - Lønnsøkning for sjefer
		
		ansatte.stream()
				.filter(a -> a.getStilling().toLowerCase().contains("sjef"))
				.forEach(a -> a.setAarslonn((int)(a.getAarslonn() * 1.07)));
		System.out.println("Oppg 3d: Liste av ansatte etter lønndøkning:");
		Util.skrivUtAlle(ansatte);
		
		// Oppgave 3e - Ansatte som tjener mer enn 800.000,-
		
		boolean tjenerMer = ansatte.stream()
				.anyMatch(a -> (a.getAarslonn() > 800000));
		System.out.println("Oppg 3e: Finnes det ansatte som tjener mer enn kr 800.000?:\n" + tjenerMer + "\n");
		
		// Oppgave 3f - Skriv ut alle de ansatte med System.out.println() uten å bruke løkke.
		
		System.out.println("Oppg 3f: Utskrift uten løkke:");
		ansatte.stream()
			.forEach(System.out::println);
		System.out.println("");
		
		// Oppgave 3g - Finn den/de ansatte som har lavest lønn.
		Ansatt ansattMinstLonn = ansatte.stream()
				.min(Comparator.comparing(Ansatt::getAarslonn))
				.orElse(null);
		System.out.println("Oppg 3g: Ansatt med minst lønn:\n" + ansattMinstLonn + "\n");
		
		// Oppgave 3h - Summen av alle heltall i [1, 1000> som er delelig med 3 eller 5
		System.out.println("Oppg 3h: Summen av alle heltall i [1, 1000> som er delelig med 3 eller 5:");
		int sum = IntStream.range(1, 1000)
			.filter(x -> (x%3 == 0) || (x%5 == 0))
			.sum();
		System.out.println(sum);
	}
}
