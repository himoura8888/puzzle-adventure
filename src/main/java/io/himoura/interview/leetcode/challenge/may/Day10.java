package io.himoura.interview.leetcode.challenge.may;

/**
 * <b>Find the Town Judge</b>
 * 
 * <p>
 * In a town, there are <b>N</b> people labelled from <b>1 to N</b>. There is a
 * rumor that one of these people is secretly the town judge.
 * 
 * </br>
 * If the town judge exists, then:
 * <ul>
 * <li>The town judge trusts nobody.</li>
 * <li>Everybody (except for the town judge) trusts the town judge.</li>
 * <li>There is exactly one person that satisfies properties 1 and 2.</li>
 * </ul>
 * 
 * </br>
 * You are given <b>trust</b>, an array of pairs <b>trust[i] = [a, b]</b>
 * representing that the person labelled <b>a</b> trusts the person labelled
 * <b>b</b>. </br>
 * If the town judge exists and can be identified, return the label of the town
 * judge. Otherwise, return <b>-1</b>.
 * </p>
 * <dl>
 * <dt>Example 1:</dt>
 * <dd></br>
 * Input: N = 2, trust = [[1,2]]</br>
 * Output: 2</dd>
 * <dt>Example 2:</dt>
 * <dd></br>
 * Input: N = 3, trust = [[1,3],[2,3]]</br>
 * Output: 3</dd>
 * <dt>Example 3:</dt>
 * <dd></br>
 * </br>
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]</br>
 * Output: -1</dd>
 * <dt>Example 4:</dt>
 * <dd></br>
 * Input: N = 3, trust = [[1,2],[2,3]]</br>
 * Output: -1</dd>
 * <dt>Example 4:</dt>
 * <dd></br>
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]] </br>
 * Output: 3
 * <dd></br>
 * </dl>
 * <ul>
 * 
 * <b>Note:</b>
 * <ol>
 * 1 <= N <= 1000 trust.length <= 10000
 * </ol>
 * <ol>
 * trust[i] are all different
 * </ol>
 * <ol>
 * trust[i][0] != trust[i][1] 1 <= trust[i][0],
 * </ol>
 * <ol>
 * trust[i][1] <= N
 * </ol>
 * 
 * </ul>
 * 
 * @version 10 mai 2020
 */
public class Day10 {
	public int findJudge(int N, int[][] trust) {
		return Integer.MIN_VALUE;
	}
}
