package com.humboo.game.split.model;

//Information about matches:

//Hearts/diamonds = red
//Spades/clubs = black

//Weak: same rank, different color

//Strong: same rank, same color

//Perfect: same rank, same suit


public class Match {
	private Card card1;
	private Card card2;
	
	//Type of match: 
	private String type;
	
	public Match(Card card1, Card card2) {
		this.card1 = card1;
		this.card2 = card2;
		this.type = setType();
	}
	
	public String getType() {
		return this.type;
	}
	
	private String setType() {
		if(card1.getRank() == card2.getRank() && card1.getSuit() == card2.getSuit()) {
			return "Perfect";
		}
		if(card1.getRank() == card2.getRank() && card1.getColor(card1.getSuit()) == card2.getColor(card2.getSuit())) {
			return "Strong";
		}
		if(card1.getRank() == card2.getRank() && card1.getColor(card1.getSuit()) != card2.getColor(card2.getSuit())) {
			return "Weak";
		}
		return "Invalid Match";
	}
}
