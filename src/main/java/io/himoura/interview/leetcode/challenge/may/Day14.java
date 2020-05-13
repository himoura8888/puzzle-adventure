package io.himoura.interview.leetcode.challenge.may;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * <b>Implement Trie (Prefix Tree)</b> <a href=
 * "https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3329/">Implement
 * Trie (Prefix Tree)</a>
 * 
 * @version 14 mai 2020
 */
public class Day14 {

}

class Trie {

	char value;
	List<Trie> child = new ArrayList<>();

	/** Initialize your data structure here. */
	public Trie() {
		child = new ArrayList<>();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Trie current = this;
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);

			// Search character into child of current node
			Trie nodeIsCharacter = null;
			for (Trie child : current.child) {
				if (!Objects.isNull(child) && child.value == character) {
					nodeIsCharacter = child;
					break;
				}
			}

			if (Objects.isNull(nodeIsCharacter)) {
				nodeIsCharacter = new Trie();
				nodeIsCharacter.value = character;
				current.child.add(nodeIsCharacter);
			}
			current = nodeIsCharacter;
		}
		// leaft
		current.child.add(null);
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {

		return helperSearch(word, true);

	}

	private boolean helperSearch(String word, boolean isStrictlySearch) {
		if (isStrictlySearch) {
			word = word + '0';
		}
		// DPS
		List<Trie> currentChild = this.child;
		if (currentChild.isEmpty()) {
			return false;
		}
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);

			Trie nodeHasValue = null;
			for (Trie child : currentChild) {
				if (child != null && child.value == character) {
					nodeHasValue = child;
					break;
				} else if (isStrictlySearch && child == null && character == '0') {
					return true;
				}
			}
			if (Objects.isNull(nodeHasValue))
				return false;
			currentChild = nodeHasValue.child;
		}
		return true;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		return helperSearch(prefix, false);
	}

	void displayByLevel() {
		Queue<Trie> nodesToProcess = new LinkedList<>();
		nodesToProcess.offer(this);
		Trie currentNode = null;
		int countCurrentLevel = 1;
		int countNextLevel = 0;
		while (!nodesToProcess.isEmpty()) {
			currentNode = nodesToProcess.poll();
			countCurrentLevel--;
			if (Objects.isNull(currentNode)) {
				System.out.print(" NULL ");
				continue;
			}
			System.out.print(currentNode.value + " ");

			countNextLevel += currentNode.child.size();
			nodesToProcess.addAll(currentNode.child);

			if (countCurrentLevel == 0) {
				System.out.println("");
				System.out.println("------------------------");
				System.out.println("");
				countCurrentLevel = countNextLevel;
				countNextLevel = 0;
			}
		}

	}
}