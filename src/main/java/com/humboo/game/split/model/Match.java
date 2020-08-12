package com.humboo.game.split.model;

//Hearts/Diamonds = Red
//Spades/Clubs = Black

//Weak: same rank, different color.
//Strong: same rank, same color.
//Perfect: same rank, same suit.

public class Match {
	private Card card1;
	private Card card2;
	
	public Match(Card card1, Card card2) {
		this.card1 = card1;
		this.card2 = card2;
	}
	
	public int isMatch() {
		if(card1.getRank() == card2.getRank()) {
			return card1.getRank();
		} else {
			return -1;
		}
	}
	
	//Get the type of match (perfect, strong, weak).
	public String getType() {
		if(card1.getRank() == card2.getRank() && card1.getSuit().equals(card2.getSuit())) {
			return "Perfect";
		}
		if(card1.getRank() == card2.getRank() && card1.getColor().equals(card2.getColor())) {
			return "Strong";
		}
		if(card1.getRank() == card2.getRank() && !card1.getColor().equals(card2.getColor())) {
			return "Weak";
		}
		return "Invalid Match";
	}
}
