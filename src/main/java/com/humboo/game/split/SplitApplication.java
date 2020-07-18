package com.humboo.game.split;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.humboo.game.split.model.Card;
import com.humboo.game.split.model.Deck;
import com.humboo.game.split.model.Match;
import com.humboo.game.split.model.Player;
import com.humboo.game.split.model.SplitGame;
import com.humboo.game.split.model.Suit;

@SpringBootApplication
public class SplitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitApplication.class, args);
		
		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");
		Player player3 = new Player("Player 3");
		
		Player[] players = {player1, player2, player3};
		
		SplitGame game = new SplitGame(3, players);
		
		game.startGame();
		
//		player1.printCards(game.getDeck());
		
		System.out.println("---- possible matches ----");
		
//		player1.getPossibleMatches(game.getDeck());
		
		
		
		
		
	}

}
