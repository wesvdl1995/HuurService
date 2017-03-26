package com.iac.rest;

public class Kamer{
	private int verdiepingNr;
	private int kamerNr;
	private int aantalPersonen;
	private int bezet;
	private double prijs;
	private String omschrijving;
	
	public Kamer(int verdiepingNr, int kamerNr, int aantalPersonen, int bezet, double prijs, String omschrijving){
		this.setVerdiepingNr(verdiepingNr);
		this.setKamerNr(kamerNr);
		this.setAantalPersonen(aantalPersonen);
		this.setBezet(bezet);
		this.setPrijs(prijs);
		this.setOmschrijving(omschrijving);
	}

	public int getVerdiepingNr() {
		return verdiepingNr;
	}

	public void setVerdiepingNr(int verdiepingNr) {
		this.verdiepingNr = verdiepingNr;
	}

	public int getKamerNr() {
		return kamerNr;
	}

	public void setKamerNr(int kamerNr) {
		this.kamerNr = kamerNr;
	}

	public int getAantalPersonen() {
		return aantalPersonen;
	}

	public void setAantalPersonen(int aantalPersonen) {
		this.aantalPersonen = aantalPersonen;
	}

	public int getBezet() {
		return bezet;
	}

	public void setBezet(int bezet) {
		this.bezet = bezet;
	}
	
	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
}