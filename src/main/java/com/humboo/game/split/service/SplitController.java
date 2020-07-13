package com.humboo.game.split.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.humboo.game.split.model.Card;
import com.humboo.game.split.model.Suit;

@RestController
public class SplitController {

	@RequestMapping(value="/login")
	public Map<String, Object> getAppToken()
	{
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("token", "sometoken");
		return hashMap;
	}
	
}