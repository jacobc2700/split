package com.humboo.game.split.model;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
	//How to keep 104 default cards in a deck, array?
	//Card order will be:
	//CLUBS, DIAMONDS, SPADES, HEARTS (same order as enum)
	//1, 2, 3... 13 where each rank pairs with the enum (two times for each)
			
	private Card[] cards;
	
	public Deck() {
		this.cards = new Card[104];
		
		int currentIndex = 0;
		
		for(int i = 1; i <= 13; i++) {
			for (Suit suit: Suit.values()) { 
				cards[currentIndex] = new Card(i, suit);
				currentIndex++;
				cards[currentIndex] = new Card(i, suit);
				currentIndex++;
			}
		}
	}
	
	public Card[] getCards() {
		return this.cards;
	}

	// Implementing Fisher–Yates shuffle O(n)
	public void shuffle()
	{
	  Random rnd = ThreadLocalRandom.current();
	  for (int i = cards.length - 1; i > 0; i--)
	  {
	    int index = rnd.nextInt(i + 1);
	    // Simple swap
	    Card a = cards[index];
	    cards[index] = cards[i];
	    cards[i] = a;
	  }
	}
	
	
}
