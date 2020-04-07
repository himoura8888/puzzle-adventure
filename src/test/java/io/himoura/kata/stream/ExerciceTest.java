package io.himoura.kata.stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExerciceTest {

	@DisplayName("Upper case all elements of list")
	@Test
	public void transformShouldConvertCollectionElementsToUpperCase() {
		// Given
		ExerciceFacade exercice8 = new Exercice();
		ExerciceLegacy exercice7 = new ExerciceLegacy();

		List<String> collection = Arrays.asList("My", "name", "is", "John", "Doe");
		List<String> expected = Arrays.asList("MY", "NAME", "IS", "JOHN", "DOE");

		// When
		final List<String> target8 = exercice8.transformUpperCase(collection);
		final List<String> targetLegacy = exercice7.transformUpperCase(collection);

		// Then
		assertThat(target8, Matchers.contains(expected.toArray()));
		assertThat(targetLegacy, Matchers.contains(expected.toArray()));
	}

	@DisplayName("Filter collection so that only elements with less than 4 characters are returned")
	@Test
	void transformShouldFilterCollection() throws Exception {

		// Given
		ExerciceFacade exercice8 = new Exercice();
		ExerciceLegacy exercice7 = new ExerciceLegacy();
		List<String> collection = Arrays.asList("My", "name", "is", "John", "Doe");
		List<String> expected = Arrays.asList("My", "is", "Doe");

		// When
		final List<String> target8 = exercice8.transformFilter(collection);
		final List<String> targetLegacy = exercice7.transformFilter(collection);

		// Then
		assertThat(target8, contains(expected.toArray()));
		assertThat(targetLegacy, contains(expected.toArray()));
	}

	@DisplayName("Flatten multidimensional collection")
	@Test
	void transformShouldFlattenCollection() throws Exception {

		// Given
		ExerciceFacade exercice8 = new Exercice();
		ExerciceLegacy exercice7 = new ExerciceLegacy();
		List<List<String>> collection = Arrays.asList(Arrays.asList("Viktor", "Farcic"),
				Arrays.asList("John", "Doe", "Third"));
		List<String> expected = Arrays.asList("Viktor", "Farcic", "John", "Doe", "Third");

		// When
		final List<String> target8 = exercice8.transformFlatten(collection);
		final List<String> targetLegacy = exercice7.transformFlatten(collection);

		// Then
		assertThat(target8, contains(expected.toArray()));
		assertThat(targetLegacy, contains(expected.toArray()));
	}

	@DisplayName("Get oldest person from the collection")
	@Test
	void getOldestPersonShouldReturnOldestPerson() throws Exception {

		// Given
		ExerciceFacade exercice8 = new Exercice();
		ExerciceLegacy exercice7 = new ExerciceLegacy();

		Person sara = new Person("Sara", 4);
		Person viktor = new Person("Viktor", 40);
		Person eva = new Person("Eva", 42);
		List<Person> collection = Arrays.asList(sara, eva, viktor);

		// When
		final Person target8 = exercice8.getOldest(collection);
		final Person targetLegacy = exercice7.getOldest(collection);

		// Then
		assertThat(target8, is(eva));
		assertThat(targetLegacy, is(eva));
	}

	@DisplayName("Get youngest person from the collection")
	@Test
	void getYoungestPersonShouldReturnYoungestPerson() throws Exception {

		// Given
		ExerciceFacade exercice8 = new Exercice();
		ExerciceLegacy exercice7 = new ExerciceLegacy();

		Person sara = new Person("Sara", 4);
		Person viktor = new Person("Viktor", 40);
		Person eva = new Person("Eva", 42);
		List<Person> collection = Arrays.asList(sara, eva, viktor);

		// When
		final Person target8 = exercice8.getYoungest(collection);
		final Person targetLegacy = exercice7.getYoungest(collection);

		// Then
		assertThat(target8, is(sara));
		assertThat(targetLegacy, is(sara));
	}

	@DisplayName("Sum all elements of a collection")
	@Test
	void sumAllElement() throws Exception {

		// Given
		ExerciceFacade exercice8 = new Exercice();
		ExerciceLegacy exercice7 = new ExerciceLegacy();
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		// When
		final Integer target8 = exercice8.sumAllElement(numbers);
		final Integer targetLegacy = exercice7.sumAllElement(numbers);

		// Then
		assertThat(target8, is(15));
		assertThat(targetLegacy, is(15));
	}

	@DisplayName("Get names of all kids (under age of 18)")
	@Test
	void getKidNameShouldReturnNamesOfAllKidsFromNorway() throws Exception {

		// Given
		ExerciceFacade exercice8 = new Exercice();
		ExerciceLegacy exercice7 = new ExerciceLegacy();
		Person sara = new Person("Sara", 4);
		Person viktor = new Person("Viktor", 40);
		Person eva = new Person("Eva", 42);
		Person anna = new Person("Anna", 5);
		List<Person> collection = Arrays.asList(sara, eva, viktor, anna);
		List<String> expected = Arrays.asList("Sara", "Anna");

		// When
		final List<String> target8 = exercice8.getKidName(collection);
		final List<String> targetLegacy = exercice7.getKidName(collection);

		// Then
		assertThat(target8, contains(expected.toArray()));
		assertThat(targetLegacy, contains(expected.toArray()));
	}

	@DisplayName("Get people statistics: average age, count, maximum age, minimum age and sum og all ages.")
	@Test
	void testStatistic() throws Exception {

		// Given
		ExerciceFacade exercice8 = new Exercice();
		ExerciceLegacy exercice7 = new ExerciceLegacy();
		Person sara = new Person("Sara", 4);
		Person viktor = new Person("Viktor", 40);
		Person eva = new Person("Eva", 42);
		List<Person> collection = Arrays.asList(sara, eva, viktor);

		// When
		assertThat(exercice8.getStats(collection).getAverage(), is(28L));
		assertThat(exercice8.getStats(collection).getCount(), is(3L));
		assertThat(exercice8.getStats(collection).getMax(), is(42L));
		assertThat(exercice8.getStats(collection).getMin(), is(4L));
		assertThat(exercice8.getStats(collection).getSum(), is(86L));
		assertThat(exercice7.getStats(collection).getAverage(), is(28L));
		assertThat(exercice7.getStats(collection).getCount(), is(3L));
		assertThat(exercice7.getStats(collection).getMax(), is(42L));
		assertThat(exercice7.getStats(collection).getMin(), is(4L));
		assertThat(exercice7.getStats(collection).getSum(), is(86L));
		// Then
	}

	@DisplayName("Partition adults and kids")
	@Test
	void testPartition() throws Exception {

		// Given
		ExerciceFacade exercice8 = new Exercice();
		ExerciceLegacy exercice7 = new ExerciceLegacy();
		Person sara = new Person("Sara", 4);
		Person viktor = new Person("Viktor", 40);
		Person eva = new Person("Eva", 42);
		List<Person> collection = Arrays.asList(sara, eva, viktor);

		// When
		Map<Boolean, List<Person>> result = exercice8.partitionAdults(collection);
		assertThat(result.get(true), contains(eva, viktor));
		assertThat(result.get(false), contains(sara));
		result = exercice7.partitionAdults(collection);
		assertThat(result.get(true), contains(eva, viktor));
		assertThat(result.get(false), contains(sara));

		// Then
	}

	@DisplayName("Group people by nationality")
	@Test
	void testGroup() throws Exception {

		// Given
		ExerciceFacade exercice8 = new Exercice();
		ExerciceLegacy exercice7 = new ExerciceLegacy();
		Person sara = new Person("Sara", 4, "Norwegian");
		Person viktor = new Person("Viktor", 40, "Serbian");
		Person eva = new Person("Eva", 42, "Norwegian");
		List<Person> collection = Arrays.asList(sara, eva, viktor);

		// When
		Map<String, List<Person>> result8 = exercice8.groupByNationality(collection);
		Map<String, List<Person>> result7 = exercice7.groupByNationality(collection);

		// Then
		assertThat(result8.get("Norwegian"), contains(sara, eva));
		assertThat(result8.get("Serbian"), contains(viktor));
		assertThat(result7.get("Norwegian"), contains(sara, eva));
		assertThat(result7.get("Serbian"), contains(viktor));
	}

	@DisplayName("Return people names separated by comma")
	@Test
	void testJoin() throws Exception {

		// Given
		ExerciceFacade exercice8 = new Exercice();
		ExerciceLegacy exercice7 = new ExerciceLegacy();
		Person sara = new Person("Sara", 4);
		Person viktor = new Person("Viktor", 40);
		Person eva = new Person("Eva", 42);
		List<Person> collection = Arrays.asList(sara, viktor, eva);

		// When

		// Then
		assertThat(exercice8.namesToString(collection), is("Names: Sara, Viktor, Eva."));
		assertThat(exercice7.namesToString(collection), is("Names: Sara, Viktor, Eva."));
	}

	@DisplayName("Group people by Job")
	@Test
	void testGroupJob() throws Exception {

		// Given
		ExerciceFacade exercice8 = new Exercice();
		ExerciceLegacy exercice7 = new ExerciceLegacy();
		Person sara = new Person("Sara", 4, "Norwegian", Job.STUDENT);
		Person viktor = new Person("Viktor", 40, "Serbian", Job.ENGINEER);
		Person eva = new Person("Eva", 42, "Norwegian", Job.ENGINEER);
		Person lionel = new Person("Lionel", 72, "Norwegian", Job.RETIRED);
		List<Person> collection = Arrays.asList(sara, eva, viktor, lionel);

		// When
		Map<Job, List<Person>> result8 = exercice8.groupByJobAndModifiedNationality(collection);
		Map<Job, List<Person>> result7 = exercice7.groupByJobAndModifiedNationality(collection);

		// Then
		assertThat(result8.get(Job.STUDENT), contains(sara));
		assertThat(result8.get(Job.RETIRED), contains(lionel));
		assertThat(result8.get(Job.RETIRED).get(0).nationality, is("modified"));
		assertThat(result8.get(Job.ENGINEER), containsInAnyOrder(viktor, eva));
		assertThat(result7.get(Job.STUDENT), contains(sara));
		assertThat(result7.get(Job.RETIRED), contains(lionel));
		assertThat(result7.get(Job.RETIRED).get(0).nationality, is("modified"));
		assertThat(result7.get(Job.ENGINEER), containsInAnyOrder(viktor, eva));
	}

	@DisplayName("Sort by Name and Age")
	@Test
	void testSortNameAge() throws Exception {

		// Given
		ExerciceFacade exercice8 = new Exercice();
		ExerciceLegacy exercice7 = new ExerciceLegacy();
		Person sara = new Person("Sara", 4, "Norwegian", Job.STUDENT);
		Person viktor = new Person("Viktor", 40, "Serbian", Job.ENGINEER);
		Person eva = new Person("Eva", 42, "Norwegian", Job.ENGINEER);
		Person lionel = new Person("Lionel", 72, "Norwegian", Job.RETIRED);
		Person viktorBaby = new Person("Viktor", 1, "Serbian", Job.STUDENT);
		Person evaSenior = new Person("Eva", 42, "Norwegian", Job.RETIRED);
		List<Person> collection = Arrays.asList(sara, eva, viktor, lionel, viktorBaby, evaSenior);

		// When
		List<Person> result8 = exercice8.sortByNameAge(collection);
		List<Person> result7 = exercice7.sortByNameAge(collection);

		// Then
		assertThat(result8, contains(eva, evaSenior, lionel, sara, viktorBaby, viktor));
		assertThat(result7, contains(eva, evaSenior, lionel, sara, viktorBaby, viktor));
	}

}
