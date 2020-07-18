package com.humboo.game.split.service;

import java.util.HashMap;
import java.util.Map;

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

	@RequestMapping(value="/login")
	public Map<String, Object> getAppToken()
	{
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("token", "sometoken");
		return hashMap;
	}
	
	@RequestMapping(value="/deck")
	public Deck getDeck()
	{
		//Make a new deck and shuffle it
		Deck deck = new Deck();
		
		deck.shuffle();
//		
//		for(int i = 0; i < deck.getCards().length; i++) {
//			System.out.println(deck.getCards()[i]);
//		}
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("token", "sometoken");
		return deck;
	}
	
	@RequestMapping(value = "/game/create", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createGame(@RequestBody NewGameForm gameForm) {
//		System.out.println(gamePool.createNewGame(name, names));
		
		Map<String, Object> hashMap = new HashMap<>();
		
		String id = gamePool.createNewGame(gameForm.gameName, gameForm.playerNames);
		
		hashMap.put("id", id);		
		hashMap.put("status", gamePool.getGames().get(id).getStatus());
		
		return hashMap;
		
//		return ;
	}
	
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, SplitGame> getGames2() {
		return gamePool.getGames();
	}
	
//	@RequestMapping(value = "/helperpost", method = RequestMethod.POST)
//	public String postHelper(@RequestBody String[] names) {
//		System.out.println(names);
//		return "SUCCESS";
//	}
	
	@RequestMapping(value = "/helper", method = RequestMethod.GET)
	@ResponseBody
	public Object helper() {
		String [] names = { "name 1", "name 2", "name 3" };
		return names;
	}

	
//	@RequestMapping(value = "/{}/status", method = RequestMethod.GET)
//	@ResponseBody
//	public Map<String, SplitGame> getStatus() {
//		return gamePool.getGames();
//	}
	
	

	@RequestMapping(value = "/game/{id}/status", method = RequestMethod.GET)
	@ResponseBody
	public String getStatus(@PathVariable("id") String id) {
	    return "Gettin=" + id;
	}

	@RequestMapping(value = "/helperpost", method = RequestMethod.POST)
	public String postHelper(@RequestBody String[] names) {
		System.out.println(names);
		return "SUCCESS";
	}
	
	
	
	
	

}