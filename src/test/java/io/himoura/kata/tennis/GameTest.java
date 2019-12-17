package io.himoura.kata.tennis;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

	@DisplayName("Tennis Kata 40")
	@Test
	void testName2() throws Exception {
		
		// Given
		Game game = new Game();

		// When
		game.winPoint("Federer");
		game.winPoint("Federer");
		game.winPoint("Federer");
//		game.winPoint("Federer");
		
		// Then
		assertThat(game.history, hasSize(3));
		assertThat(game.gamePlayer1, is(3));
		assertThat(game.scorePlayer("Federer"), is("40"));
	}
	
	
	@DisplayName("Tennis Kata ADV")
	@Test
	void testADV() throws Exception {
		
		// Given
		Game game = new Game();

		// When
		game.winPoint("Federer");
		game.winPoint("Federer");
		game.winPoint("Federer");
		game.winPoint("Nadal");
		game.winPoint("Nadal");
		game.winPoint("Nadal");
		game.winPoint("Federer");
		
		// Then
		assertThat(game.history, hasSize(7));
		assertThat(game.gamePlayer1, is(4));
		assertThat(game.gamePlayer2, is(3));
		assertThat(game.scorePlayer("Federer"), is("ADV"));
	}
	
	@DisplayName("Tennis Kata EQUAL")
	@Test
	void testEQUAL() throws Exception {
		
		// Given
		Game game = new Game();

		// When
		game.winPoint("Federer");
		game.winPoint("Federer");
		game.winPoint("Federer");
		game.winPoint("Nadal");
		game.winPoint("Nadal");
		game.winPoint("Nadal");
		game.winPoint("Nadal");
		game.winPoint("Federer");
		
		// Then
		assertThat(game.history, hasSize(8));
		assertThat(game.gamePlayer1, is(4));
		assertThat(game.gamePlayer2, is(4));
		assertThat(game.scorePlayer("Federer"), is("DEUCE"));
	}
	
	@DisplayName("Tennis Kata WIN")
	@Test
	void testWIN() throws Exception {
		
		// Given
		Game game = new Game();

		// When
		game.winPoint("Federer");
		game.winPoint("Federer");
		game.winPoint("Federer");
		game.winPoint("Nadal");
		game.winPoint("Nadal");
		game.winPoint("Nadal");
		game.winPoint("Nadal");
		game.winPoint("Federer");
		game.winPoint("Nadal");
		game.winPoint("Federer");
		game.winPoint("Federer");
		game.winPoint("Federer");
		
		// Then
		assertThat(game.history, hasSize(12));
		assertThat(game.gamePlayer1, is(0));
		assertThat(game.gamePlayer2, is(0));
		assertThat(game.scorePlayer("Federer"), is("0"));
	}

}
