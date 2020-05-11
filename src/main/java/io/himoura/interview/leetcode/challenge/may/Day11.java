package io.himoura.interview.leetcode.challenge.may;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * <b>Flood Fill</b>
 * 
 * @see <a href=
 *      "https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/">Flood
 *      Fill</a>
 * @version 11 mai 2020
 */
public class Day11 {

	private final Algo algo;

	/**
	 * @param algo
	 */
	public Day11(Algo algo) {
		this.algo = algo;
	}

	/**
	 * Time Complexity O(h*w) </br>
	 * <i>given h=image height and w=image width</i>
	 * 
	 * @param image
	 * @param sr
	 * @param sc
	 * @param newColor
	 * @return
	 */
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		int colorStartPoint = image[sr][sc];

		if (colorStartPoint == newColor) {
			return image;
		}

		algo.floodFill(image, sr, sc, colorStartPoint, newColor);

		return image;
	}

	interface Algo {
		void floodFill(int[][] image, int sr, int sc, int srcColor, int newColor);
	}

	static class Dfs implements Algo {

		/**
		 * DFS
		 * 
		 * @param image
		 * @param sr
		 * @param sc
		 * @param srcColor
		 * @param newColor
		 */
		@Override
		public void floodFill(int[][] image, int sr, int sc, int srcColor, int newColor) {
			// Eliminate impossible point which are out of bond
			if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
				return;
			}

			if (image[sr][sc] == srcColor) {
				image[sr][sc] = newColor;
				// North
				floodFill(image, sr - 1, sc, srcColor, newColor);
				// South
				floodFill(image, sr + 1, sc, srcColor, newColor);
				// West
				floodFill(image, sr, sc - 1, srcColor, newColor);
				// East
				floodFill(image, sr, sc + 1, srcColor, newColor);
			}

		}

	}

	static class Bfs implements Algo {

		@Override
		public void floodFill(int[][] image, int sr, int sc, int srcColor, int newColor) {

			Queue<Integer> pointToProcess = new LinkedList<>();
			pointToProcess.add(sr);
			pointToProcess.add(sc);

			while (!pointToProcess.isEmpty()) {
				int y = pointToProcess.poll();
				int x = pointToProcess.poll();

				if (image[y][x] == srcColor) {
					image[y][x] = newColor;
					// Find a candidate in 4 direction
					// North
					if (y - 1 >= 0) {
						pointToProcess.add(y - 1);
						pointToProcess.add(x);
					}
					// South
					if (y + 1 < image.length) {
						pointToProcess.add(y + 1);
						pointToProcess.add(x);
					}
					// West
					if (x - 1 >= 0) {
						pointToProcess.add(y);
						pointToProcess.add(x - 1);
					}

					// East
					if (x + 1 < image[0].length) {
						pointToProcess.add(y);
						pointToProcess.add(x + 1);
					}
				}
			}

		}
	}

	static class CustomClassAndSet implements Algo {

		/**
		 * Time complexity O(h*w) </br>
		 * Space complexity O(h*w) </br>
		 * <i>given h=image height and w=image width</i>
		 * 
		 * @param image
		 * @param sr
		 * @param sc
		 * @param newColor
		 * @return
		 */
		@Override
		public void floodFill(int[][] image, int sr, int sc, int srcColor, int newColor) {

			class Point {
				final int x;
				final int y;

				/**
				 * @param x
				 * @param y
				 */
				public Point(int x, int y) {
					this.x = x;
					this.y = y;
				}

				@Override
				public int hashCode() {
					return x + y * 100;
				}

				@Override
				public boolean equals(Object obj) {
					if (obj instanceof Point) {
						Point point2 = (Point) obj;
						return point2.x == x && point2.y == y;
					}
					return false;
				}

			}

			final Set<Point> pointsToProcess = new HashSet<>();
			pointsToProcess.add(new Point(sc, sr));

			while (!pointsToProcess.isEmpty()) {
				final Point point = pointsToProcess.iterator().next();
				pointsToProcess.remove(point);

				image[point.y][point.x] = newColor;

				// Find a candidate in 4 direction
				// North
				if (point.y - 1 >= 0) {
					if (image[point.y - 1][point.x] == srcColor) {
						pointsToProcess.add(new Point(point.x, point.y - 1));
					}
				}
				// South
				if (point.y + 1 < image.length) {
					if (image[point.y + 1][point.x] == srcColor) {
						pointsToProcess.add(new Point(point.x, point.y + 1));
					}
				}
				// West
				if (point.x - 1 >= 0) {
					if (image[point.y][point.x - 1] == srcColor) {
						pointsToProcess.add(new Point(point.x - 1, point.y));
					}
				}

				// East
				if (point.x + 1 < image[0].length) {
					if (image[point.y][point.x + 1] == srcColor) {
						pointsToProcess.add(new Point(point.x + 1, point.y));
					}
				}

			}
		}
	}

}
