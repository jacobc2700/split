package com.humboo.game.split.model;

//Hearts/diamonds = red
//Spades/clubs = black

public class Card {
	//Card should have
	//Suit from enum, 
	
	private static final String BLACK = "BLACK";
	private static final String RED = "RED";
	
	//possible values: 1 to 13 -> A, 2, 3, ... King
	private int rank;
	private Suit _suit;

	//Takes rank and suit
	public Card(int rank, Suit suit) {
		this.rank = rank;
		this._suit = suit;
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public Suit getSuit() {
		return this._suit;
	}
	
	public String getColor() {
		if(_suit.equals(Suit.SPADES) || _suit.equals(Suit.CLUBS)) {
			return BLACK;
		} else {
			return RED;
		}
	}
	
	public String toString() {
		return "Rank: " + rank + "| Suit: " + String.valueOf(_suit) + " | Color: " + getColor();
	}
}