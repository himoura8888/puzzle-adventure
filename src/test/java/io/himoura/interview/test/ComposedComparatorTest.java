package io.himoura.interview.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComposedComparatorTest {
	
	Person[] persons;
	
	@BeforeEach
	void setUpEachTest() {
		Person person1 = new Person("naruto", 20);
		Person person2 = new Person("nas",17);
		Person person3 = new Person("sasuke",20);
		Person person4 = new Person("aba",14);
		Person person5 = new Person("sasuke",2);
		persons = new Person[]{person1, person2, person3, person4, person5};
	}
	
	@DisplayName("Should order by age then name")
	@Test
	void shouldOrderByAgeName() {
		Arrays.sort(persons, ComposedComparator.byAgeName);
		assertThat(Arrays.stream(persons).map(p->p.toString()).collect(Collectors.joining("-")), is("sasuke 2-aba 14-nas 17-naruto 20-sasuke 20"));
	}
	
	@DisplayName("Should order by name then age")
	@Test
	void shouldOrderByNameAge() {
		Arrays.sort(persons, ComposedComparator.byNameAge);		
		assertThat(Arrays.stream(persons).map(p->p.toString()).collect(Collectors.joining("-")), is("aba 14-naruto 20-nas 17-sasuke 2-sasuke 20"));
	}
	
	@DisplayName("Should reversed order by name then age")
	@Test
	void shouldReversedOrderByNameAge() {
		Arrays.sort(persons, ComposedComparator.byNameAgeReversed);
		assertThat(Arrays.stream(persons).map(p->p.toString()).collect(Collectors.joining("-")), is("sasuke 20-sasuke 2-nas 17-naruto 20-aba 14"));
	}
	
	

}
