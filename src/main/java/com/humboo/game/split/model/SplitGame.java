package com.humboo.game.split.model;

import java.util.Stack;

public class SplitGame {
	private int numberOfPlayers;
	private Player[] players;
	private Deck deck;
	
	//number which is the current index you are on in your deck
	private int currentCardIndex = 0;
	
	private Stack<Card> discardPile;
	
	public SplitGame(int numberOfPlayers, Player[] players) {
		if(numberOfPlayers <= 1 || numberOfPlayers >= 5) {
			return;
		} else {
			this.numberOfPlayers = numberOfPlayers;
			this.deck = new Deck();
			this.players = players;
		}
	}
	
	//Getter for deck
	public Deck getDeck() {
		return deck;
	}
	
	//Call when game starts
	public void startGame() {
		//Shuffle deck
		deck.shuffle();
		
		//Give nine cards to all the players
		for(int i = 0; i < numberOfPlayers; i++) {
			for(int j = 0; j < 9; j++) {
				players[i].addCard(currentCardIndex);
				currentCardIndex++;
			}
		}

	}
	
}
