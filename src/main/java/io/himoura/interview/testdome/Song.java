package io.himoura.interview.testdome;

import java.util.HashSet;
import java.util.Objects;

/**
 * 
 * A playlist is considered a repeating playlist if any of the songs contain a
 * reference to a previous song in the playlist. Otherwise, the playlist will
 * end with the last song which points to null.
 * 
 * Implement a function isRepeatingPlaylist that, efficiently with respect to
 * time used, returns true if a playlist is repeating or false if it is not.
 * 
 * For example, the following code prints "true" as both songs point to each
 * other.
 *
 */
public class Song {
	private String name;
	private Song nextSong;

	public Song(String name) {
		this.name = name;
	}

	public void setNextSong(Song nextSong) {
		this.nextSong = nextSong;
	}

	/**
	 * Stock played song and check if song has been already played
	 * @return
	 */
	public boolean isRepeatingPlaylist() {
		HashSet<String> playList = new HashSet<>();
		Song current = this;
		while (current != null) {
			if (playList.contains(current.name)) {
				return true;
			} else {
				playList.add(current.name);
				current = current.nextSong;
			}
		}
		return false;
	}
	
	
	/**
	 * Implementation with 2 pointing
	 * @return
	 */
	public boolean isRepeatingPlaylistV2() {
		Song current = this;
		Song next = current.nextSong;
		while (current != null) {
				
				if (Objects.equals(current, next)) {
					return true;
				}
				else {
					current = current.nextSong;
					if (current != null)
						next = current.nextSong;
					else
						return false;
				}
		}
		return false;
	}

	public static void main(String[] args) {
		Song first = new Song("Hello");
		Song second = new Song("Eye of the tiger");
		Song third = new Song("I like to move it");

		first.setNextSong(first);

		System.out.println(first.isRepeatingPlaylist());
	}
}
