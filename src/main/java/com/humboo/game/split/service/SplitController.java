package com.humboo.game.split.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
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
		hashMap.put("players", gamePool.getGames().get(id).getPlayers());
		hashMap.put("deck", gamePool.getGames().get(id).getDeck());
//		hashMap.put("cards", gamePool.getGames().get(id).getPlayers().getClass()
		
		Player[] players = gamePool.getGames().get(id).getPlayers();
//		
		Map<String, Object> discardMatches = new HashMap<>();
		Map<String, Object> holdingCards = new HashMap<>();
		
		for(Player player:players) {
			discardMatches.put(player.getID(), player.getMatches());
			holdingCards.put(player.getID(), player.getHoldingCards(gamePool.getGames().get(id).getDeck()));
		}
		hashMap.put("PlayerMatches", discardMatches);
		hashMap.put("PlayerHoldingCards", holdingCards);
		
		for(Player player:players) {
			hashMap.put("PLAYER_" + player.getID(), player.getInfo(gamePool.getGames().get(id)));
		}
		
		hashMap.put("gameInfo", gamePool.getGames().get(id).getInfo());
		
		
		//hashMap.put("Cards", currentPlayer.getCards(gamePool.getGames().get(gameId).getDeck()));
		
		hashMap.put("name", gamePool.getGames().get(id).getName());
		hashMap.put("currentCardIndex", gamePool.getGames().get(id).getCurrentCardIndex());
		hashMap.put("playerTurn", gamePool.getGames().get(id).getCurrentPlayerTurn());
		hashMap.put("availableActions", gamePool.getGames().get(id).getAvailableActions());
//		current card index, player turn
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
	
	
	//@route GET /games/games_id/player/player_id
	//@description Get info for one player in one game
	//@access Public
	@RequestMapping(value = "/games/{gameId}/player/{playerId}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getPlayerInfo(@PathVariable("gameId") String gameId, @PathVariable("playerId") String playerId) {
//		return gamePool.getGames().get(gameId).getPlayerByID(playerId);
		Player currentPlayer = gamePool.getGames().get(gameId).getPlayerByID(playerId);
		
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("name", currentPlayer.getName());
		hashMap.put("id", currentPlayer.getID());
		hashMap.put("matches", currentPlayer.getMatches());
		hashMap.put("holdingCardIndexes", currentPlayer.getHoldingCardIndexes());
		hashMap.put("isTurn", currentPlayer.isTurn());
		hashMap.put("scoreSheet", currentPlayer.getScoreSheet());
		
		
//		hashMap.put
		//, isTurn, scoreSheet
		return hashMap;
	}
}