package com.humboo.game.split.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GamePoolTest {

	@Test
	public void createNewGameTest() {
		
		String name = "Game1";
		String [] players = new String[] { "Jacob", "David", "Judy", "Grace" };
		
		String gameId = GamePool.getInstance().createNewGame(name, players);
		GamePool.getInstance();		
		int gameCount = GamePool.getGames().size();
		
		Assertions.assertEquals(1, gameCount);
		Assertions.assertTrue(GamePool.getGames().containsKey(gameId));
		
		SplitGame game = GamePool.getGames().get(gameId);
		assertEquals(4, game.getPlayers().length);
		
	
	}
}
