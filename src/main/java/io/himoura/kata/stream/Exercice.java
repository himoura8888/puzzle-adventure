package io.himoura.kata.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

interface ExerciceFacade {

	List<String> transformUpperCase(List<String> list);

	List<String> transformFilter(List<String> list);

	List<String> transformFlatten(List<List<String>> list);

	Person getOldest(List<Person> list);

	Person getYoungest(List<Person> list);

	Integer sumAllElement(List<Integer> list);

	List<String> getKidName(List<Person> list);

	Stats getStats(List<Person> list);

	Map<Boolean, List<Person>> partitionAdults(List<Person> collection);

	class Stats {

		IntSummaryStatistics summaryStatistics;
		private long average;
		private long count;
		private long sum;
		private int min;
		private int max;

		/**
		 * @param average
		 * @param count
		 * @param sum
		 * @param min
		 * @param max
		 */
		public Stats(long average, long count, long sum, int min, int max) {
			this.average = average;
			this.count = count;
			this.sum = sum;
			this.min = min;
			this.max = max;
		}

		public Stats(IntSummaryStatistics summaryStatistics) {
			this.summaryStatistics = summaryStatistics;
		}

		public long getAverage() {
			return (long) (Objects.isNull(summaryStatistics) ? average : summaryStatistics.getAverage());
		}

		public long getCount() {
			return Objects.isNull(summaryStatistics) ? count : summaryStatistics.getCount();
		}

		public long getSum() {
			return Objects.isNull(summaryStatistics) ? sum : summaryStatistics.getSum();
		}

		public long getMin() {
			return Objects.isNull(summaryStatistics) ? min : summaryStatistics.getMin();
		}

		public long getMax() {
			return Objects.isNull(summaryStatistics) ? max : summaryStatistics.getMax();
		}

	}

	Map<String, List<Person>> groupByNationality(List<Person> collection);

	Map<Job, List<Person>> groupByJobAndModifiedNationality(List<Person> collection);

	Object namesToString(List<Person> collection);

}

public class Exercice implements ExerciceFacade {

	@Override
	public List<String> transformUpperCase(List<String> list) {
		if (Objects.isNull(list) || list.isEmpty()) {
			return Collections.emptyList();
		}
		return list.stream().map(e -> e.toUpperCase()).collect(Collectors.toList());
	}

	@Override
	public List<String> transformFilter(List<String> list) {
		if (Objects.isNull(list) || list.isEmpty()) {
			return Collections.emptyList();
		}

		return list.stream().filter(s -> s.length() < 4).collect(Collectors.toList());
	}

	@Override
	public List<String> transformFlatten(List<List<String>> list) {
		if (Objects.isNull(list) || list.isEmpty()) {
			return Collections.emptyList();
		}

		return list.stream().flatMap(ll -> ll.stream()).collect(Collectors.toList());
	}

	@Override
	public Person getOldest(List<Person> list) {
		if (Objects.isNull(list) || list.isEmpty()) {
			return null;
		}
//		return list.stream().collect(Collectors.maxBy((p1,p2) -> p1.age > p2.age ? 1 : -1)).get();
		// Comparator function
		return list.stream().max(Comparator.comparing(p -> p.age)).get();
	}

	@Override
	public Integer sumAllElement(List<Integer> list) {

//		return list.stream().mapToInt(o->o).sum();

		return list.stream().reduce(0, (total, number) -> total + number);
	}

	@Override
	public List<String> getKidName(List<Person> list) {
		return list.stream().filter(p -> p.age < 18).map(p -> p.name).collect(Collectors.toList());
	}

	@Override
	public Stats getStats(List<Person> list) {

		return new Stats(list.stream().mapToInt(p -> p.age).summaryStatistics());
	}

	@Override
	public Map<Boolean, List<Person>> partitionAdults(List<Person> collection) {
		return collection.stream().collect(Collectors.partitioningBy(p -> p.age > 18));
	}

	@Override
	public Map<String, List<Person>> groupByNationality(List<Person> collection) {
		return collection.stream().collect(Collectors.groupingBy(p -> p.nationality));
	}

	@Override
	public Object namesToString(List<Person> collection) {
		return collection.stream().map(p -> p.name).collect(Collectors.joining(", ", "Names: ", "."));
	}

	@Override
	public Person getYoungest(List<Person> list) {
		return list.stream().min((p1, p2) -> p1.age - p2.age > 0 ? 1 : -1).get();
	}

	@Override
	public Map<Job, List<Person>> groupByJobAndModifiedNationality(List<Person> collection) {
		return collection.stream().peek(p->p.nationality="modified").collect(Collectors.groupingBy(p -> p.job));
	}

}

class ExerciceLegacy implements ExerciceFacade {

	@Override
	public List<String> transformUpperCase(List<String> list) {
		if (Objects.isNull(list) || list.isEmpty()) {
			return Collections.emptyList();
		}

		final List<String> result = new ArrayList<>();

		for (String string : list) {
			result.add(string.toUpperCase());
		}
		return result;
	}

	@Override
	public List<String> transformFilter(List<String> list) {
		if (Objects.isNull(list) || list.isEmpty()) {
			return Collections.emptyList();
		}

		final List<String> result = new ArrayList<>();

		for (String string : list) {
			if (string.length() < 4) {
				result.add(string);
			}
		}
		return result;
	}

	@Override
	public List<String> transformFlatten(List<List<String>> list) {
		if (Objects.isNull(list) || list.isEmpty()) {
			return Collections.emptyList();
		}

		final List<String> result = new ArrayList<>();

		for (List<String> subList : list) {
			result.addAll(subList);
		}
		return result;
	}

	@Override
	public Person getOldest(List<Person> list) {

		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.age > p2.age ? 1 : -1;
			}

		});

		return list.get(list.size() - 1);
	}

	@Override
	public Integer sumAllElement(List<Integer> list) {
		if (Objects.isNull(list) || list.isEmpty()) {
			return 0;
		}
		Integer result = 0;

		for (Integer number : list) {
			result += number;
		}
		return result;
	}

	@Override
	public List<String> getKidName(List<Person> list) {
		if (Objects.isNull(list) || list.isEmpty()) {
			return Collections.emptyList();
		}

		final List<String> result = new ArrayList<>();
		for (Person person : list) {
			if (person.age < 18) {
				result.add(person.name);
			}
		}
		return result;
	}

	@Override
	public Stats getStats(List<Person> list) {
		long average;
		int count = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sum = 0;

		for (Person person : list) {
			count++;
			sum += person.age;
			max = person.age > max ? person.age : max;
			min = person.age < min ? person.age : min;
		}
		average = sum / count;
		return new Stats(average, count, sum, min, max);
	}

	@Override
	public Map<Boolean, List<Person>> partitionAdults(List<Person> collection) {
		Map<Boolean, List<Person>> result = new HashMap<>();
		result.put(Boolean.TRUE, new ArrayList<>());
		result.put(Boolean.FALSE, new ArrayList<>());
		for (Person person : collection) {
			if (person.age > 18) {
				result.get(Boolean.TRUE).add(person);
			} else {
				result.get(Boolean.FALSE).add(person);
			}
		}
		return result;
	}

	@Override
	public Map<String, List<Person>> groupByNationality(List<Person> collection) {
		Map<String, List<Person>> result = new HashMap<>();

		for (Person person : collection) {
			if (!result.containsKey(person.nationality)) {
				result.put(person.nationality, new ArrayList<>());
			}
			result.get(person.nationality).add(person);
		}

		return result;
	}

	@Override
	public Object namesToString(List<Person> collection) {

		StringBuffer buffer = new StringBuffer("Names: ");
		for (Person p : collection) {
			buffer.append(p.name).append(", ");
		}
		buffer.setLength(buffer.length() - 2);

		return buffer.append(".").toString();
	}

	@Override
	public Person getYoungest(List<Person> list) {

		list.sort(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.age.compareTo(o2.age);
			}
		});

		return list.get(0);
	}

	@Override
	public Map<Job, List<Person>> groupByJobAndModifiedNationality(List<Person> collection) {
		Map<Job, List<Person>> result = new HashMap<>();

		for (Person person : collection) {
			if (!result.containsKey(person.job)) {
				person.nationality = "modified";
				result.put(person.job, new ArrayList<>());
			}
			result.get(person.job).add(person);
		}

		return result;
	}

}

class Person {
	String name;
	Integer age;
	String nationality;
	Job job;

	/**
	 * @param name
	 * @param age
	 */
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Person(String string, int i, String string2) {
		this(string, i);
		this.nationality = string2;
	}

	public Person(String string, int i, String string2, Job job) {
		this(string, i);
		this.nationality = string2;
		this.job = job;
	}

}

enum Job {
	STUDENT, ENGINEER, RETIRED
}