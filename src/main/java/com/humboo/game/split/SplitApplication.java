package com.humboo.game.split;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.humboo.game.split.model.Card;
import com.humboo.game.split.model.Deck;
import com.humboo.game.split.model.Match;
import com.humboo.game.split.model.Suit;

@SpringBootApplication
public class SplitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitApplication.class, args);
		
		//test to see if match works: WEAK
		Card card1 = new Card(7, Suit.SPADES);
		Card card2 = new Card(7, Suit.DIAMONDS);
		Match match1 = new Match(card1, card2);
		System.out.println(match1.getType());
		
		//STRONG
		Card card3 = new Card(11, Suit.HEARTS);
		Card card4 = new Card(11, Suit.DIAMONDS);
		Match match2 = new Match(card3, card4);
		System.out.println(match2.getType());
		
		//PERFECT
		Card card5 = new Card(13, Suit.CLUBS);
		Card card6 = new Card(13, Suit.CLUBS);
		Match match3 = new Match(card5, card6);
		System.out.println(match3.getType());
		
		//Make a new deck and shuffle it
		Deck deck = new Deck();
		
//		for(int i = 0; i < deck.getCards().length; i++) {
//			System.out.println(deck.getCards()[i]);
//		}
		
		deck.shuffle();
		
		for(int i = 0; i < deck.getCards().length; i++) {
			System.out.println(deck.getCards()[i]);
		}
		
	}

}
