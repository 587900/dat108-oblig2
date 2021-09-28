package no.hvl.dat108.common;

public class Ansatt {
	
	private String fornavn;
	private String etternavn;
	private Kjonn kjonn;
	private String stilling;
	private int aarslonn;

	public Ansatt(String fornavn, String etternavn, Kjonn kjonn, String stilling, int aarslonn) {
		super();
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;
		this.stilling = stilling;
		this.aarslonn = aarslonn;
	}

	public String getEtternavn() {
		return etternavn;
	}
	
	public Kjonn getKjonn() {
		return kjonn;
	}
	
	public String getStilling() {
		return stilling;
	}
	
	public int getAarslonn() {
		return aarslonn;
	}

	public void setAarslonn(int aarslonn) {
		this.aarslonn = aarslonn;
	}
	
	@Override
	public String toString() {
		return fornavn + " " + etternavn + ", " + kjonn.name() + ", " + stilling + ", " + aarslonn;
	}

}
