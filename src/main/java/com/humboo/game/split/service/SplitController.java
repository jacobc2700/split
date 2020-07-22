package com.humboo.game.split.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.humboo.game.split.model.Card;
import com.humboo.game.split.model.Deck;
import com.humboo.game.split.model.GamePool;
import com.humboo.game.split.model.NewGameForm;
import com.humboo.game.split.model.Player;
import com.humboo.game.split.model.SplitGame;
import com.humboo.game.split.model.Suit;

@RestController
public class SplitController {
	
	GamePool gamePool = GamePool.getInstance();

	//@route POST /games
	//@description Create a new game with a name and players
	//@access Public
	@RequestMapping(value = "/games", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createGame(@RequestBody NewGameForm gameForm) {
		Map<String, Object> hashMap = new HashMap<>();
		String id = gamePool.createNewGame(gameForm.gameName, gameForm.playerNames);
		hashMap.put("id", id);		
		hashMap.put("status", gamePool.getGames().get(id).getStatus());
		return hashMap;
	}
	
	//@route GET /games/ids
	//@description Get all the ids of the games
	//@access Private for testing only
	@RequestMapping(value = "/games/ids", method = RequestMethod.GET)
	@ResponseBody
	public Set<String> getGameIds() {
		return gamePool.getGames().keySet();
	}
	
	//@route GET /games
	//@description Get all the games
	//@access Public
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, SplitGame> getGames() {
		return gamePool.getGames();
	}
	
	//@route GET /games/id
	//@description Get info for one game
	//@access Public
	@RequestMapping(value = "/games/{id}", method = RequestMethod.GET)
	@ResponseBody
	public SplitGame getGameByID(@PathVariable("id") String id) {
		return gamePool.getGames().get(id);
	}
	
}