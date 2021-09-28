package no.hvl.dat108.common;

import java.util.List;

public class Util {
	
	public static void skrivUtAlle(List<?> ansatte) {
		ansatte.forEach(System.out::println);
		System.out.println("");
	}

}
