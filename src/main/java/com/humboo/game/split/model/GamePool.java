package com.humboo.game.split.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("singleton")
public class GamePool {
	public static String test() {
		return "Game pool for Split game.";
	}
	
	// static variable single_instance of type Singleton 
    private static GamePool game_pool = null;
    
    private static Map<String, SplitGame> games = new HashMap<>();
   
    public String s; 
  
    public String createNewGame(String name, String[] names) {
    	UUID uuid = UUID.randomUUID();
		
		SplitGame newGame = new SplitGame(names, name);
    	
    	games.put(uuid.toString(), newGame);
    	
    	newGame.startGame();
    	
    	return uuid.toString();
    }
    
    public static Map<String, SplitGame> getGames() {
    	return games;
    }    
    
    // private constructor restricted to this class itself 
    private GamePool() 
    { 
        s = "Hello I am a string part of Singleton class"; 
    } 
  
    // static method to create instance of Singleton class 
    public static GamePool getInstance() 
    { 
        if (game_pool == null) 
        	game_pool = new GamePool(); 
  
        return game_pool; 
    } 
}
