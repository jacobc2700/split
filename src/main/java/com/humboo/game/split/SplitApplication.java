package com.humboo.game.split;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.humboo.game.split.model.Card;
import com.humboo.game.split.model.Deck;
import com.humboo.game.split.model.GamePool;
import com.humboo.game.split.model.Match;
import com.humboo.game.split.model.Player;
import com.humboo.game.split.model.SplitGame;
import com.humboo.game.split.model.Suit;

@SpringBootApplication
public class SplitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitApplication.class, args);
		
		String[] players = {"player 1", "player 2", "player3"};
		
		GamePool gamePool = GamePool.getInstance();
		
		gamePool.createNewGame("Humboo's game", players);
		
//		game/.startGame();
		
//		player1.printCards(game.getDeck());
		
		System.out.println("---- possible matches ----");
		
//		player1.getPossibleMatches(game.getDeck());
		
		
		
		
		
	}

}
