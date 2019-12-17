package io.himoura.kata.tennis;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Game 
{
	int gamePlayer1;
	int gamePlayer2;
	int scorePlayer1;
	int scorePlayer2;
	int timebreakPlayer1;
	int timebreakPlayer2;
	
	List<String> history= new ArrayList<>();
	
	void winPoint(String player) {
		processPoint(player);
		history.add(player + " " + ("Federer".equals(player) ? gamePlayer1 : gamePlayer2));
	}
	
	String scorePlayer(String player) {
		switch (gamePlayer1) {
		case 0:
			return "0";
		case 1 : 
			return "15";
		case 2 : 
			return "30";
		case 3 :
			return "40";
		}
		if (gamePlayer1 > 3) {
			// ADV, EGAL
			if (gamePlayer1 == gamePlayer2) {
				return "DEUCE";
			}
			else if (gamePlayer1 == (gamePlayer2+1)){
				return "ADV";
			}
			else {
				return "40";
			}
		}
		return "0";
	}
	
	
	void processPoint(String player) {
		if ("Federer".equals(player)) {	
				if (gamePlayer1 < 3) {
					gamePlayer1++;
				}
				else {
					// ADV, EGAL
					if (gamePlayer1 == gamePlayer2 || (gamePlayer1+1) == gamePlayer2) {
						gamePlayer1++;
					}
					// Game Win
					else if (gamePlayer1 == (gamePlayer2+1)){
						gamePlayer1 = 0;
						gamePlayer2 = 0;
						scorePlayer1++;
					}
				}
			}
			else {
				if (gamePlayer2 < 3) {
					gamePlayer2++;
				}
				else {
					// ADV, EGAL
					if (gamePlayer2 == gamePlayer1 || (gamePlayer2+1) == gamePlayer1) {
						gamePlayer2++;
					}
					// Game Win
					else if (gamePlayer2 == (gamePlayer1+1)){
						gamePlayer1 = 0;
						gamePlayer2 = 0;
						scorePlayer2++;
					}
				}
			}
	}
	
    public static void main( String[] args )
    {
    }
}
