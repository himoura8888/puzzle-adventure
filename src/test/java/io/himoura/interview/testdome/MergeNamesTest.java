package io.himoura.interview.testdome;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MergeNamesTest {
	
	@DisplayName("MergeNames v1")
	@Test
	void testV1() {
		String[] names1 = new String[] { "Ava", "Emma", "Olivia" };
		String[] names2 = new String[] { "Olivia", "Sophia", "Emma" };
		assertThat(Arrays.toString(MergeNames.uniqueNamesv1(names1, names2)), is("[Ava, Emma, Olivia, Sophia]"));
	}
	
	@DisplayName("MergeNames v2")
	@Test
	void testV2() {
		String[] names1 = new String[] { "Ava", "Emma", "Olivia" };
		String[] names2 = new String[] { "Olivia", "Sophia", "Emma" };
		assertThat(Arrays.toString(MergeNames.uniqueNamesv2(names1, names2)), is("[Ava, Emma, Olivia, Sophia]"));
	}

}
