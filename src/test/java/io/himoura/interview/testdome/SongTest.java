package io.himoura.interview.testdome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SongTest {

	@Test
	void test() {
		Song first = new Song("Hello");
		Song second = new Song("Eye of the tiger");
		Song third = new Song("I like to move it");
		Song fourth = new Song("Stand up");

		first.setNextSong(first);
		second.setNextSong(first);
		third.setNextSong(fourth);

		assertTrue(first.isRepeatingPlaylist());
		assertTrue(second.isRepeatingPlaylist());
		assertFalse(third.isRepeatingPlaylist());
	}
	
	@Test
	void testV2() {
		Song first = new Song("Hello");
		Song second = new Song("Eye of the tiger");
		Song third = new Song("I like to move it");
		Song fourth = new Song("Stand up");
		
		first.setNextSong(first);
		second.setNextSong(first);
		third.setNextSong(fourth);
		
		assertTrue(first.isRepeatingPlaylistV2());
		assertTrue(second.isRepeatingPlaylistV2());
		assertFalse(third.isRepeatingPlaylistV2());
	}

}
