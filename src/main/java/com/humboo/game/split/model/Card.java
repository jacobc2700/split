package com.humboo.game.split.model;

//Hearts/diamonds = red
//Spades/clubs = black

public class Card {
	//Card should have
	//Suit from enum, 
	
	//possible values: 1 to 13 -> A, 2, 3, ... King
	private int rank;
	private Suit _suit;
	private String color; //Get color from looking at suit
	
	//Takes rank and suit
	public Card(int rank, Suit suit) {
		this.rank = rank;
		this._suit = suit;
		this.color = getColor(suit);
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public Suit getSuit() {
		return this._suit;
	}
	
	public String getColor(Suit suit) {
		if(String.valueOf(suit).equals("SPADES") || String.valueOf(suit).equals("CLUBS")) {
			return "BLACK";
		} else {
			return "RED";
		}
	}
	
	public String toString() {
		return "Rank: " + rank + "| Suit: " + String.valueOf(_suit) + " | Color: " + color;
	}
}