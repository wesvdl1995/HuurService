package com.iac.rest;

import java.util.ArrayList;

public class Building {
	private String name;
	private ArrayList<Kamer> listOfKamers;
	
	public Building(String name, ArrayList<Kamer> listOfKamers){
		this.setName(name);
		this.setListOfKamers(listOfKamers);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Kamer> getListOfKamers() {
		return listOfKamers;
	}

	public void setListOfKamers(ArrayList<Kamer> listOfKamers) {
		this.listOfKamers = listOfKamers;
	}
	
	public void addKamer(Kamer k){
		this.listOfKamers.add(k);
	}
}
