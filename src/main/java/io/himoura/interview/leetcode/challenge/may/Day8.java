package io.himoura.interview.leetcode.challenge.may;

import java.util.Arrays;

/**
 * <b>Check If It Is a Straight Line</b>
 * <p>
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y]
 * represents the coordinate of a point. Check if these points make a straight
 * line in the XY plane.
 * <dl>
 * <dt>Example 1:</dt>
 * <dd></br>
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]] </br>
 * Output: true</dd>
 * <dt>Example 2:</dt>
 * <dd></br>
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]] </br>
 * Output: false</dd>
 * </dl>
 * </p>
 * <p>
 * <i>Constraints:
 * <ul>
 * <li>2 <= coordinates.length <= 1000 coordinates[i].length == 2</li>
 * <li>-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4 coordinates</li>
 * <li>contains no duplicate point.</li>
 * </ul>
 * </i>
 * </p>
 * 
 * @see <a href=
 *      "https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/">Check
 *      If It Is a Straight Line</a>
 * @version 8 mai 2020
 */
public class Day8 {
	/**
	 * Time complexity O(n)
	 * 
	 * @param coordinates
	 * @return
	 */
	public boolean checkStraightLine(int[][] coordinates) {
		final int dy = coordinates[0][1] - coordinates[1][1];
		final int dx = coordinates[0][0] - coordinates[1][0];
		return !Arrays.stream(coordinates)
				.map(coord -> (coordinates[0][0] - coord[0]) * dy == (coordinates[0][1] - coord[1]) * dx)
				.anyMatch(b -> b == false);
	}
}
