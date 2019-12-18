package io.himoura.kata.tennis;

import java.util.ArrayList;
import java.util.List;

public class Game {

	List<String> history = new ArrayList<>();

	void winPoint(PlayerScore winner, PlayerScore loser) {
		processPoint(winner, loser);
		history.add(winner + " " + winner.nbPoint);
	}

	String scorePlayer(PlayerScore player, PlayerScore looser) {
		if (player.nbPoint == 0) {
			return "0";
		} else if (player.nbPoint == 1) {
			return "15";
		} else if (player.nbPoint == 2) {
			return "30";
		} else if (player.nbPoint == 3) {
			return "40";
		}
		else {
			if (player.nbPoint == looser.nbPoint) {
				return "DEUCE";
			} else if (player.nbPoint == (looser.nbPoint + 1)) {
				return "ADV";
			} else {
				return "40";
			}
		}
	}

	void processPoint(PlayerScore winner, PlayerScore loser) {
		if (winner.nbPoint < 3) {
			winner.nbPoint++;
		} else {
			// ADV, EGAL
			if (winner.nbPoint == loser.nbPoint || (winner.nbPoint + 1) == loser.nbPoint) {
				winner.nbPoint++;
			}
			// Game Win
			else if (winner.nbPoint == (loser.nbPoint + 1)) {
				winner.nbPoint = 0;
				loser.nbPoint = 0;
				winner.nbGame++;
			}
		}
	}

	public static void main(String[] args) {
	}
}

enum Score {
	S0, S15, S30, S40, DEUCE, ADV;
}

class PlayerScore {
	String name;
	int nbPoint;
	int nbGame;
	int nbSet;
	int nbTieBreak;
}
