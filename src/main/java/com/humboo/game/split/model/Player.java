package com.humboo.game.split.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Player {
	private String name;
	
	private String id;
	
	//matches that were already placed down and counted for points
	private Match[] matches;
	
	//cards in hand
	private ArrayList<Integer> holdingCardIndexes;
	
	private boolean isTurn = false;
	
	private ScoreSheet scoreSheet;
	
	public Player(String name, String id) {
		this.name = name;
		this.id = id;
		holdingCardIndexes = new ArrayList<>();
	}
	
//	getter/setter lay out nicely soon
	
	public boolean isTurn() {
		return isTurn;
	}
	
	public String getID() {
		return id;
	}
	
	public ScoreSheet getScoreSheet() {
		return scoreSheet;
	}
	
	public Match[] getMatches() {
		return matches;
	}
	
//	public Map<String, Object>
	
	//show everything for the player in a hashmap...
	public Map<String, Object> getInfo(SplitGame game) {
		Map<String, Object> hashMap = new HashMap<>();
		
//		Map<String, Object> matches = new HashMap<>();
		
		for(int i = 0; i < game.getPlayers().length; i++) {
			hashMap.put("matchesFor_PLAYER_" + game.getPlayers()[i].id, game.getPlayers()[i].getMatches());
		}
		
		hashMap.put("name", this.getName());
		hashMap.put("id", this.getID());
		hashMap.put("holdingCards", this.getCards(game.getDeck()));
		hashMap.put("matches", this.getMatches());
		hashMap.put("scoreSheet", this.getScoreSheet());
		
		return hashMap;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Card> getCards(Deck deck) {
		ArrayList<Card> cards = new ArrayList<>();
		
		for(int i = 0; i < holdingCardIndexes.size(); i++) {
			cards.add(deck.getCards()[holdingCardIndexes.get(i)]);
		}
		return cards;
	}
	
	public ArrayList<Integer> getHoldingCardIndexes() {
		return holdingCardIndexes;
	}
	
	//add new card to holding cards
	public void drawCard(int cardIndex) {
		holdingCardIndexes.add(cardIndex);
	}
	
	public void printCards(Deck deck) {
		for(int i = 0; i < holdingCardIndexes.size(); i++) {
			System.out.println(deck.getCards()[i]);
		}
	}
	
	public Card[] getHoldingCards(Deck deck) {
		Map<String, Object> hashMap = new HashMap<>();
		
		
		Card[] cards = new Card[holdingCardIndexes.size()];
		
		for(int i = 0; i < holdingCardIndexes.size(); i++) {
			cards[i] = deck.getCards()[i];
//			hashMap.put(Integer.toString(i), deck.getCards()[i]);
		}
		return cards;
	}
	
	//Function that lists all the possible matches made from holding cards
	//Lists all the versions of Matches
	public void getPossibleMatches(Deck deck) {
		for(int i = 0; i < holdingCardIndexes.size(); i++) {
			for(int j = i + 1; j < holdingCardIndexes.size(); j++) {
				if(deck.getCards()[holdingCardIndexes.get(i)].getRank() == deck.getCards()[holdingCardIndexes.get(j)].getRank()) {
					System.out.println("Match: " + deck.getCards()[holdingCardIndexes.get(i)] + " --- " + deck.getCards()[holdingCardIndexes.get(j)]);
				}
			}
		}
	}
	
//	public void promptTurn() {
//		Scanner sc = new Scanner(System.in);
//		isTurn = !isTurn;
//		while(isTurn) {
//			System.out.println("Your turn, " + name);
//			System.out.println("Choices for this turn, press the number please:");
//			
//		}
//		
//	}
	
	//Options for user each round:
	
	//draw from discard pile: you pick a number which is how many you want from the end of
		//the stack
	
	//draw from the holdingCardIndexes
	
	//user's moves is still going until they want to stop
	
	
}