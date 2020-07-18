package com.humboo.game.split.model;

import java.util.Stack;

public class SplitGame {
	private int numberOfPlayers;
	private Player[] players;
	private Deck deck;
	
	//number which is the current index you are on in your deck
	private int currentCardIndex = 0;
	
	//number which represents whose turn it is
	private int playerTurn = 0;
	
	private Stack<Integer> discardPile;
	
	public SplitGame(int numberOfPlayers, Player[] players) {
		if(numberOfPlayers <= 1 || numberOfPlayers >= 5) {
			return;
		} else {
			this.numberOfPlayers = numberOfPlayers;
			this.deck = new Deck();
			this.players = players;
			discardPile = new Stack<>();
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
				players[i].drawCard(currentCardIndex);
				currentCardIndex++;
			}
		}
		
		//Put the next card as the first card for discard pile
		discardPile.push(currentCardIndex);
		currentCardIndex++;

		nextTurn(playerTurn++);
	}
	
	public void nextTurn(int playerTurn) {
		players[playerTurn].promptTurn();
		
//		nextTurn(playerTurn++);
	}
	
}
