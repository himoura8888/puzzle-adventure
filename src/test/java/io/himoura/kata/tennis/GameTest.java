package io.himoura.kata.tennis;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

	@DisplayName("Tennis Kata 40 - 0")
	@Test
	void testName2() throws Exception {
		
		// Given
		Game game = new Game();
		PlayerScore p1 = new PlayerScore();
		p1.name = "Federer";
		PlayerScore p2 = new PlayerScore();
		p2.name = "Nadal";

		// When
		game.winPoint(p1,p2);
		game.winPoint(p1,p2);
		game.winPoint(p1,p2);
		
		// Then
		assertThat(game.history, hasSize(3));
		assertThat(game.scorePlayer(p1, p2), is("40"));
	}
	
	
	@DisplayName("Tennis Kata ADV")
	@Test
	void testADV() throws Exception {
		
		// Given
		Game game = new Game();
		PlayerScore p1 = new PlayerScore();
		p1.name = "Federer";
		PlayerScore p2 = new PlayerScore();
		p2.name = "Nadal";

		// When
		game.winPoint(p1,p2);
		game.winPoint(p1,p2);
		game.winPoint(p1,p2);
		game.winPoint(p2,p1);
		game.winPoint(p2,p1);
		game.winPoint(p2,p1);
		game.winPoint(p1,p2);
		
		// Then
		assertThat(game.history, hasSize(7));
		assertThat(game.scorePlayer(p1, p2), is("ADV"));
	}
	
	@DisplayName("Tennis Kata EQUAL")
	@Test
	void testEQUAL() throws Exception {
		
		// Given
		Game game = new Game();
		PlayerScore p1 = new PlayerScore();
		p1.name = "Federer";
		PlayerScore p2 = new PlayerScore();
		p2.name = "Nadal";

		// When
		game.winPoint(p1,p2);
		game.winPoint(p1,p2);
		game.winPoint(p1,p2);
		game.winPoint(p2,p1);
		game.winPoint(p2,p1);
		game.winPoint(p2,p1);
		game.winPoint(p2,p1);
		game.winPoint(p1,p2);
		
		// Then
		assertThat(game.history, hasSize(8));
		assertThat(game.scorePlayer(p1, p2), is("DEUCE"));
	}
	
	@DisplayName("Tennis Kata WIN")
	@Test
	void testWIN() throws Exception {
		
		// Given
		Game game = new Game();
		PlayerScore p1 = new PlayerScore();
		p1.name = "Federer";
		PlayerScore p2 = new PlayerScore();
		p2.name = "Nadal";

		// When
		game.winPoint(p1,p2);
		game.winPoint(p1,p2);
		game.winPoint(p1,p2);
		game.winPoint(p2,p1);
		game.winPoint(p2,p1);
		game.winPoint(p2,p1);
		game.winPoint(p2,p1);
		game.winPoint(p1,p2);
		game.winPoint(p2,p1);
		game.winPoint(p1,p2);
		game.winPoint(p1,p2);
		game.winPoint(p1,p2);
		
		// Then
		assertThat(game.history, hasSize(12));
		assertThat(p1.nbGame, is(1));
		assertThat(game.scorePlayer(p1, p2), is("0"));
	}

}
