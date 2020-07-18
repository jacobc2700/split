package com.humboo.game.split.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.humboo.game.split.model.Card;
import com.humboo.game.split.model.Deck;
import com.humboo.game.split.model.GamePool;
import com.humboo.game.split.model.Player;
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
	
	@RequestMapping(value = "/ex/foos", method = RequestMethod.POST)
	@ResponseBody
	public String postFoos() {
		return gamePool.test();
//		return "D";
	}


}