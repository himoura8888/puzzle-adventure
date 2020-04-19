package io.himoura.interview.leetcode.challenge.april;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HappyNumberTest {

	@DisplayName("Base case")
	@Test
	void shoudReturnTrue() {

		// Given
		final HappyNumber happyNumber = new HappyNumber();
		// When
		boolean resultat = happyNumber.isHappy(19);
		boolean resultat2 = happyNumber.isHappy(1);
		boolean resultat3 = happyNumber.isHappy(1111111);
		// Then
		assertThat(resultat, is(true));
		assertThat(resultat2, is(true));
		assertThat(resultat3, is(true));
	}

	@DisplayName("Decompose number into list of digital")
	@Test
	@Disabled
	void shouldReturnListDigital() {

		// Given
		final HappyNumber happyNumber = new HappyNumber();

		// When
		List<Integer> resultat0 = happyNumber.getDigitalFromNumber(0);
		List<Integer> resultat1 = happyNumber.getDigitalFromNumber(9);
		List<Integer> resultat2 = happyNumber.getDigitalFromNumber(152);
		List<Integer> resultat3 = happyNumber.getDigitalFromNumber(98610);
		List<Integer> resultat4 = happyNumber.getDigitalFromNumber(100);

		// Then
		assertThat(resultat0, contains(0));
		assertThat(resultat1, contains(9));
		assertThat(resultat2, contains(1, 5, 2));
		assertThat(resultat3, contains(9, 8, 6, 1, 0));
		assertThat(resultat4, contains(1, 0, 0));
	}

}
