package io.himoura.interview.test;

import java.util.Comparator;
import java.util.Objects;

public class ComposedComparator {
	
	static Comparator<Person> byAgeName = (p1, p2) ->{
		
		if (p1.getAge() == p2.getAge()) {
			return p1.getName().compareTo(p2.getName());
		}
		else {
			return p1.getAge() > p2.getAge() ? 1 : -1;
		}
	};
	
	static Comparator<Person> byNameAge = (p1, p2) ->{
		if (Objects.equals(p1.getName(), p2.getName())) {
			return p1.getAge() > p2.getAge() ? 1 : -1;
		}
		else {
			return p1.getName().compareTo(p2.getName());
		}
	};
	
	static Comparator<Person> byNameAgeReversed = (p1, p2) ->{
		if (Objects.equals(p1.getName(), p2.getName())) {
			return p1.getAge() > p2.getAge() ? -1 : 1;
		}
		else {
			return -p1.getName().compareTo(p2.getName());
		}
	};
	
	public static void main(String[] args) {
	}
	
}


class Person{
	private String name;
	private int age;	
	/**
	 * @param name
	 * @param age
	 */
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + " " + age;
	}
	
}