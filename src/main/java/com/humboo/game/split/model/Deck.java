package com.humboo.game.split.model;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
	//104 cards in an array, randomly shuffled.
	//Card order will be: CLUBS, DIAMONDS, SPADES, HEARTS.
	//Number order will be: 1, 2, 3, ..., 11, 12, 13.
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
	
	//Getter for cards.
	//No need for any setters.
	public Card[] getCards() {
		return this.cards;
	}

	//Fisher-Yates Shuffle: O(n)
	public void shuffle() {
	  Random random = ThreadLocalRandom.current();
	  
	  for (int i = cards.length - 1; i > 0; i--) {
	    int index = random.nextInt(i + 1);
	    
	    //Simple swap.
	    Card a = cards[index];
	    cards[index] = cards[i];
	    cards[i] = a;
	  }
	}
}
