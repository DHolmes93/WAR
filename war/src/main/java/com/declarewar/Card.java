package com.declarewar;

public class Card {
	private String name;
	private String domain;
	private int rank;
	
	
	public Card(String name, String domain, int rank) {
		this.name = name;
		this.domain = domain;
		this.rank = rank;
	}


	public String getName() {
		return name;
	}


	public String getDomain() {
		return domain;
	}


	public int getRank() {
		return rank;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " of " + domain;
	}

}

    

