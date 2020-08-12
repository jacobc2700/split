package com.humboo.game.split.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SplitGame {
	private int numberOfPlayers;
	private Player[] players;
	private Deck deck;
	private String name;
	
	private int availableActions = 0;
	
	private static final int DRAW_FROM_DISCARD_PILE = 0B0000001;
	private static final int DRAW_FROM_REGULAR_PILE = 0B0000010;
	private static final int MAKE_MATCH = 0B0000100;
	
//	private static final int DRAW_FROM_REGULAR_PILE = 0B0001000;
//	private static final int DRAW_FROM_REGULAR_PILE = 0B0010000;
////	private static final int DRAW_FROM_REGULAR_PILE = 0B0001000;
//	4, 8, 16, 32...
	
	//number which is the current index you are on in your deck
	private int currentCardIndex = 0;
	
	//number which represents whose turn it is
	private int playerTurn = 0;
	
	private String status;
	
	private Stack<Integer> discardPile;
	
	public SplitGame(String[] names, String name) {
		Player[] players = new Player[names.length];
		
		for(int i = 0; i < names.length; i++) {
			players[i] = new Player(names[i], String.valueOf(i));
		}
		
		if(players.length <= 1 || players.length >= 5) {
			return;
		} else {
			this.numberOfPlayers = players.length;
			this.deck = new Deck();
			this.name = name;
			this.players = players;
			
			//when game starts, only 2 options for player:
			//draw from discard or draw from regular pile
			this.availableActions = DRAW_FROM_DISCARD_PILE + DRAW_FROM_REGULAR_PILE;
			discardPile = new Stack<>();
		}
	}
	
	public Map<String, Object> getInfo() {
		Map<String, Object> hashMap = new HashMap<>();
		
		hashMap.put("name", name);
		hashMap.put("players", players);
		hashMap.put("deck", deck);
		hashMap.put("players", players);
		hashMap.put("availableActions", availableActions);
		
		return hashMap;
	}
	
	public int getAvailableActions() {
		return availableActions;
	}
	

//		AVILABLE action = 3 == 0000011
//		0000001		
//		if (action & #0000001)
//			// private static final int DRAW_FROM_DISCARD_PILE = 1;
//		else if (action & 0000010)
//			// private static final int DRAW_FROM_REGULAR_PILE = 2;
//		else if (action & 0000010)
//			//private static final int DRAW_FROM_DISCARD_PILE = 4;
			
			
	//}
	public int getCurrentPlayerTurn() {
		return playerTurn;
	}
	
	public int getCurrentCardIndex() {
		return currentCardIndex;
	}
	
	public String getName() {
		return name;
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
	
	public Player getPlayerByID(String id) {
		return players[Integer.valueOf(id)];
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
