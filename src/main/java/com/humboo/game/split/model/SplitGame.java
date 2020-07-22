package com.humboo.game.split.model;

import java.util.Stack;

public class SplitGame {
	private int numberOfPlayers;
	private Player[] players;
	private Deck deck;
	private String name;
	
	//number which is the current index you are on in your deck
	private int currentCardIndex = 0;
	
	//number which represents whose turn it is
	private int playerTurn = 0;
	
	private String status;
	
	private Stack<Integer> discardPile;
	
	public SplitGame(String[] names) {
		Player[] players = new Player[names.length];
		
		for(int i = 0; i < names.length; i++) {
			players[i] = new Player(names[i]);
		}
		
		if(players.length <= 1 || players.length >= 5) {
			return;
		} else {
			this.numberOfPlayers = players.length;
			this.deck = new Deck();
			this.players = players;
			discardPile = new Stack<>();
		}
	}
	
	public Stack<Integer> getDiscardPile() {
		return discardPile;
	}
	
	public String getStatus() {
		return status;
	}
	
//	private void setStatus()
	
	public Player[] getPlayers() {
		return players;
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

		this.status = "Started game, " + players[playerTurn].getName() + " going first";
//		nextTurn(playerTurn++);
	}
//	
//	public void nextTurn(int playerTurn) {
//		players[playerTurn].promptTurn();
//		
////		nextTurn(playerTurn++);
//	}
	
}
