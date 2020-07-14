package com.humboo.game.split.model;

public class ScoreSheet {
	private int strikes;
	
	//index 0: ace => 12 (king), increment for each Pair
	private int[] countedMatches = new int[13];
	
	public void addStrike() {
		strikes++;
	}
	
	public void addMatch(int rankIndex) {
		countedMatches[rankIndex]++;
	}
	
	public void addMatch(Match match) {
		if(match.isMatch() >= 0) {
			countedMatches[match.isMatch() - 1]++;
		}
	}
	
	public int getScore() {
		//CALCULATION:
		//loop through the countedMatches
		//add up scoreTable[countedMatches[i] - 1]
		//subtract (number of strikes - 1) * 5
		
		//13 rows, first row is for Ace points
		//2nd row = 2, ... 13th row = King points
		int[][] scoreTable = {
				{0, 30, 70, 120, 180, 200}, //ace
				{0, 5, 20, 40, 70, 200}, //2
				{0, 10, 30, 60, 100, 200}, //3
				{0, 10, 30, 60, 100, 200}, //4
				{0, 10, 30, 60, 100, 200}, //5
				{0, 10, 30, 60, 100, 200}, //6
				{0, 10, 30, 60, 100, 200}, //7
				{0, 10, 30, 60, 100, 200}, //8
				{0, 10, 30, 60, 100, 200}, //9
				{0, 10, 30, 60, 100, 200}, //10
				{0, 20, 50, 90, 140, 200}, //Jack
				{0, 20, 50, 90, 140, 200}, //Queen
				{0, 20, 50, 90, 140, 200}, //King
		};
		
		int score = 0;
		
		for(int i = 0; i < countedMatches.length; i++) {
			score += scoreTable[i][countedMatches[i] - 1];
		}
		
		score -= ((strikes - 1) * 5);
		
		return score;
//		scoreTable[0] = new int[6] {0, 30, 70, 120, 180, 200}; //Ace
	}
}
