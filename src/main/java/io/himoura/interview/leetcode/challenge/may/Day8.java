package io.himoura.interview.leetcode.challenge.may;

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
 * @version 8 mai 2020
 */
public class Day8 {
	public boolean checkStraightLine(int[][] coordinates) {
		boolean result = true;
		for (int i = 2; i < coordinates.length && result; i++) {
			// Calculate coefficient
			final int coefficientFirstSecond = Math
					.abs((coordinates[0][0] - coordinates[1][0]) * (coordinates[0][1] - coordinates[i][1]));
			final int coefficientFirstIelement = Math
					.abs((coordinates[0][0] - coordinates[i][0]) * (coordinates[0][1] - coordinates[1][1]));
			result &= coefficientFirstIelement == coefficientFirstSecond;
		}
		return result;
	}
}
